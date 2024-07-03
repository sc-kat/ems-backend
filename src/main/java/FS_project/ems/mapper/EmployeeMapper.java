package FS_project.ems.mapper;

import FS_project.ems.dto.EmployeeDto;
import FS_project.ems.entity.EmployeeEntity;


public class EmployeeMapper {

    public static EmployeeDto mapToEmployeeDto(EmployeeEntity employeeEntity){
        return new EmployeeDto(
                employeeEntity.getId(),
                employeeEntity.getFirstName(),
                employeeEntity.getLastName(),
                employeeEntity.getEmail()
        );
    }

    public static EmployeeEntity mapToEmployee(EmployeeDto employeeDto){
        return new EmployeeEntity(
                employeeDto.getId(),
                employeeDto.getFirstName(),
                employeeDto.getLastName(),
                employeeDto.getEmail()
        );
    }
}