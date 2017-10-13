package br.com.rogrs.demo.service.mapper;

import br.com.rogrs.demo.domain.*;
import br.com.rogrs.demo.service.dto.JobDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity Job and its DTO JobDTO.
 */
@Mapper(componentModel = "spring", uses = {TaskMapper.class, EmployeeMapper.class, })
public interface JobMapper extends EntityMapper <JobDTO, Job> {

    @Mapping(source = "employee.id", target = "employeeId")
    @Mapping(source = "employee.lastName", target = "employeeLastName")
    JobDTO toDto(Job job); 

    @Mapping(source = "employeeId", target = "employee")
    Job toEntity(JobDTO jobDTO); 
    default Job fromId(Long id) {
        if (id == null) {
            return null;
        }
        Job job = new Job();
        job.setId(id);
        return job;
    }
}
