package FS_project.ems.mapper;

import FS_project.ems.dto.EmployeeDto;
import FS_project.ems.entity.EmployeeEntity;


public class EmployeeMapper {

    public static EmployeeDto mapToEmployeeDto(EmployeeEntity employeeEntity){
        return new EmployeeDto(
                employeeEntity.getId(),
                employeeEntity.getFirstName(),
                employeeEntity.getLastName(),
                employeeEntity.getEmail(),
                employeeEntity.getDepartment().getId()
        );
    }

    public static EmployeeEntity mapToEmployeeEntity(EmployeeDto employeeDto){
        EmployeeEntity employee = new EmployeeEntity();

        employee.setId(employeeDto.getId());
        employee.setFirstName(employeeDto.getFirstName());
        employee.setLastName(employeeDto.getLastName());
        employee.setEmail(employeeDto.getEmail());

        return employee;
    }
}