package br.com.rogrs.demo.service.mapper;

import br.com.rogrs.demo.domain.*;
import br.com.rogrs.demo.service.dto.DepartmentDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity Department and its DTO DepartmentDTO.
 */
@Mapper(componentModel = "spring", uses = {LocationMapper.class, })
public interface DepartmentMapper extends EntityMapper <DepartmentDTO, Department> {

    @Mapping(source = "location.id", target = "locationId")
    @Mapping(source = "location.streetAddress", target = "locationStreetAddress")
    DepartmentDTO toDto(Department department); 

    @Mapping(source = "locationId", target = "location")
    @Mapping(target = "employees", ignore = true)
    Department toEntity(DepartmentDTO departmentDTO); 
    default Department fromId(Long id) {
        if (id == null) {
            return null;
        }
        Department department = new Department();
        department.setId(id);
        return department;
    }
}
