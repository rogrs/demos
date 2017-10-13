package br.com.rogrs.demo.service.mapper;

import br.com.rogrs.demo.domain.*;
import br.com.rogrs.demo.service.dto.JobHistoryDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity JobHistory and its DTO JobHistoryDTO.
 */
@Mapper(componentModel = "spring", uses = {JobMapper.class, DepartmentMapper.class, EmployeeMapper.class, })
public interface JobHistoryMapper extends EntityMapper <JobHistoryDTO, JobHistory> {

    @Mapping(source = "job.id", target = "jobId")
    @Mapping(source = "job.jobTitle", target = "jobJobTitle")

    @Mapping(source = "department.id", target = "departmentId")
    @Mapping(source = "department.departmentName", target = "departmentDepartmentName")

    @Mapping(source = "employee.id", target = "employeeId")
    @Mapping(source = "employee.lastName", target = "employeeLastName")
    JobHistoryDTO toDto(JobHistory jobHistory); 

    @Mapping(source = "jobId", target = "job")

    @Mapping(source = "departmentId", target = "department")

    @Mapping(source = "employeeId", target = "employee")
    JobHistory toEntity(JobHistoryDTO jobHistoryDTO); 
    default JobHistory fromId(Long id) {
        if (id == null) {
            return null;
        }
        JobHistory jobHistory = new JobHistory();
        jobHistory.setId(id);
        return jobHistory;
    }
}
