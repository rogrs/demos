package br.com.rogrs.demo.service.impl;

import br.com.rogrs.demo.service.RegionService;
import br.com.rogrs.demo.domain.Region;
import br.com.rogrs.demo.repository.RegionRepository;
import br.com.rogrs.demo.repository.search.RegionSearchRepository;
import br.com.rogrs.demo.service.dto.RegionDTO;
import br.com.rogrs.demo.service.mapper.RegionMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static org.elasticsearch.index.query.QueryBuilders.*;

/**
 * Service Implementation for managing Region.
 */
@Service
@Transactional
public class RegionServiceImpl implements RegionService{

    private final Logger log = LoggerFactory.getLogger(RegionServiceImpl.class);

    private final RegionRepository regionRepository;

    private final RegionMapper regionMapper;

    private final RegionSearchRepository regionSearchRepository;

    public RegionServiceImpl(RegionRepository regionRepository, RegionMapper regionMapper, RegionSearchRepository regionSearchRepository) {
        this.regionRepository = regionRepository;
        this.regionMapper = regionMapper;
        this.regionSearchRepository = regionSearchRepository;
    }

    /**
     * Save a region.
     *
     * @param regionDTO the entity to save
     * @return the persisted entity
     */
    @Override
    public RegionDTO save(RegionDTO regionDTO) {
        log.debug("Request to save Region : {}", regionDTO);
        Region region = regionMapper.toEntity(regionDTO);
        region = regionRepository.save(region);
        RegionDTO result = regionMapper.toDto(region);
        regionSearchRepository.save(region);
        return result;
    }

    /**
     *  Get all the regions.
     *
     *  @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public List<RegionDTO> findAll() {
        log.debug("Request to get all Regions");
        return regionRepository.findAll().stream()
            .map(regionMapper::toDto)
            .collect(Collectors.toCollection(LinkedList::new));
    }


    /**
     *  get all the regions where Country is null.
     *  @return the list of entities
     */
    @Transactional(readOnly = true) 
    public List<RegionDTO> findAllWhereCountryIsNull() {
        log.debug("Request to get all regions where Country is null");
        return StreamSupport
            .stream(regionRepository.findAll().spliterator(), false)
            .filter(region -> region.getCountry() == null)
            .map(regionMapper::toDto)
            .collect(Collectors.toCollection(LinkedList::new));
    }

    /**
     *  Get one region by id.
     *
     *  @param id the id of the entity
     *  @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public RegionDTO findOne(Long id) {
        log.debug("Request to get Region : {}", id);
        Region region = regionRepository.findOne(id);
        return regionMapper.toDto(region);
    }

    /**
     *  Delete the  region by id.
     *
     *  @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete Region : {}", id);
        regionRepository.delete(id);
        regionSearchRepository.delete(id);
    }

    /**
     * Search for the region corresponding to the query.
     *
     *  @param query the query of the search
     *  @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public List<RegionDTO> search(String query) {
        log.debug("Request to search Regions for query {}", query);
        return StreamSupport
            .stream(regionSearchRepository.search(queryStringQuery(query)).spliterator(), false)
            .map(regionMapper::toDto)
            .collect(Collectors.toList());
    }
}
