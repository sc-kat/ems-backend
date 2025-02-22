package FS_project.ems.service.implementation;

import FS_project.ems.dto.EmployeeDto;
import FS_project.ems.entity.DepartmentEntity;
import FS_project.ems.entity.EmployeeEntity;
import FS_project.ems.exception.ResourceNotFoundException;
import FS_project.ems.mapper.EmployeeMapper;
import FS_project.ems.repository.DepartmentRepository;
import FS_project.ems.repository.EmployeeRepository;
import FS_project.ems.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;
    private DepartmentRepository departmentRepository;

    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {

        EmployeeEntity employee = EmployeeMapper.mapToEmployeeEntity(employeeDto);

        DepartmentEntity department = departmentRepository.findById(employeeDto.getDepartmentId()).orElseThrow(() ->
                new ResourceNotFoundException("The department with id: " + employeeDto.getDepartmentId()
                        + "cannot be found"));

        employee.setDepartment(department);

        EmployeeEntity savedEmployee = employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDto(savedEmployee);
    }

    @Override
    public EmployeeDto getEmployeeById(Long employeeId) {
        EmployeeEntity employee = employeeRepository.findById(employeeId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Employee with id : " + employeeId + " doesn't exist"));

        return EmployeeMapper.mapToEmployeeDto(employee);
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {
        List<EmployeeEntity> employees = employeeRepository.findAll();
        return employees.stream().map(EmployeeMapper::mapToEmployeeDto)
                .collect(Collectors.toList());
    }

    @Override
    public EmployeeDto updateEmployee(Long employeeId, EmployeeDto updatedEmployee) {

        EmployeeEntity employee = employeeRepository.findById(employeeId).orElseThrow(
                () -> new ResourceNotFoundException("Employee with id : " + employeeId + " doesn't exist")
        );

        employee.setFirstName(updatedEmployee.getFirstName());
        employee.setLastName(updatedEmployee.getLastName());
        employee.setEmail(updatedEmployee.getEmail());

        DepartmentEntity department = departmentRepository.findById(updatedEmployee.getDepartmentId()).orElseThrow(() ->
                new ResourceNotFoundException("The department with id: " + updatedEmployee.getDepartmentId()
                        + "cannot be found"));

        employee.setDepartment(department);
        EmployeeEntity savedEmployee = employeeRepository.save(employee);


        return EmployeeMapper.mapToEmployeeDto(savedEmployee);
    }

    @Override
    public void deleteEmployee(Long employeeId) {

        EmployeeEntity employee = employeeRepository.findById(employeeId).orElseThrow(
                () -> new ResourceNotFoundException("Employee with id : " + employeeId + " doesn't exist")
        );

        employeeRepository.deleteById(employeeId);
    }
}
