package FS_project.ems.controller;

import FS_project.ems.dto.DepartmentDto;
import FS_project.ems.dto.EmployeeDto;
import FS_project.ems.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/departments")
public class DepartmentController {

    private DepartmentService departmentService;

    @PostMapping
    public ResponseEntity<DepartmentDto> createDepartment(@RequestBody DepartmentDto departmentDto) {

        DepartmentDto department = departmentService.createDepartment(departmentDto);
        return new ResponseEntity<>(department, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<DepartmentDto> findDepartmentById(@PathVariable("id") Long departmentId) {

        DepartmentDto departmentById = departmentService.findDepartmentById(departmentId);
        return ResponseEntity.ok(departmentById);
    }

    @GetMapping
    public ResponseEntity<List<DepartmentDto>> findAllDepartments() {
        List<DepartmentDto> allDepartments = departmentService.findAllDepartments();

        return ResponseEntity.ok(allDepartments);
    }
}
