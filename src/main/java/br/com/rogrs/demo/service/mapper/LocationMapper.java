package br.com.rogrs.demo.service.mapper;

import br.com.rogrs.demo.domain.*;
import br.com.rogrs.demo.service.dto.LocationDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity Location and its DTO LocationDTO.
 */
@Mapper(componentModel = "spring", uses = {CountryMapper.class, })
public interface LocationMapper extends EntityMapper <LocationDTO, Location> {

    @Mapping(source = "country.id", target = "countryId")
    @Mapping(source = "country.countryName", target = "countryCountryName")
    LocationDTO toDto(Location location); 

    @Mapping(source = "countryId", target = "country")
    @Mapping(target = "departament", ignore = true)
    Location toEntity(LocationDTO locationDTO); 
    default Location fromId(Long id) {
        if (id == null) {
            return null;
        }
        Location location = new Location();
        location.setId(id);
        return location;
    }
}
