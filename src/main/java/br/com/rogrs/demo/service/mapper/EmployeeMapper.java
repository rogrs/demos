package br.com.rogrs.demo.service.mapper;

import br.com.rogrs.demo.domain.*;
import br.com.rogrs.demo.service.dto.EmployeeDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity Employee and its DTO EmployeeDTO.
 */
@Mapper(componentModel = "spring", uses = {DepartmentMapper.class, })
public interface EmployeeMapper extends EntityMapper <EmployeeDTO, Employee> {

    @Mapping(source = "manager.id", target = "managerId")
    @Mapping(source = "manager.lastName", target = "managerLastName")

    @Mapping(source = "department.id", target = "departmentId")
    @Mapping(source = "department.departmentName", target = "departmentDepartmentName")
    EmployeeDTO toDto(Employee employee); 
    @Mapping(target = "jobs", ignore = true)

    @Mapping(source = "managerId", target = "manager")

    @Mapping(source = "departmentId", target = "department")
    Employee toEntity(EmployeeDTO employeeDTO); 
    default Employee fromId(Long id) {
        if (id == null) {
            return null;
        }
        Employee employee = new Employee();
        employee.setId(id);
        return employee;
    }
}
