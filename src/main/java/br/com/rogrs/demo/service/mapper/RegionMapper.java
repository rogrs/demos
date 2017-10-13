package br.com.rogrs.demo.service.mapper;

import br.com.rogrs.demo.domain.*;
import br.com.rogrs.demo.service.dto.RegionDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity Region and its DTO RegionDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface RegionMapper extends EntityMapper <RegionDTO, Region> {
    
    @Mapping(target = "country", ignore = true)
    Region toEntity(RegionDTO regionDTO); 
    default Region fromId(Long id) {
        if (id == null) {
            return null;
        }
        Region region = new Region();
        region.setId(id);
        return region;
    }
}
