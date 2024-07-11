package FS_project.ems.service;

import FS_project.ems.dto.DepartmentDto;

public interface DepartmentService {

     DepartmentDto createDepartment(DepartmentDto departmentDto);

     DepartmentDto findDepartmentById(Long departmentId);
}
