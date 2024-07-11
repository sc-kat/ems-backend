package FS_project.ems.service;

import FS_project.ems.dto.DepartmentDto;

import java.util.List;

public interface DepartmentService {

     DepartmentDto createDepartment(DepartmentDto departmentDto);

     DepartmentDto findDepartmentById(Long departmentId);

     List<DepartmentDto> findAllDepartments();
}
