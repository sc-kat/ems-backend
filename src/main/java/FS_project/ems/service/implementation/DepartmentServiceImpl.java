package FS_project.ems.service.implementation;

import FS_project.ems.dto.DepartmentDto;
import FS_project.ems.entity.DepartmentEntity;
import FS_project.ems.mapper.DepartmentMapper;
import FS_project.ems.repository.DepartmentRepository;
import FS_project.ems.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private DepartmentRepository departmentRepository;

    @Override
    public DepartmentDto createDepartment(DepartmentDto departmentDto) {

        DepartmentEntity department = DepartmentMapper.mapToDepartmentEntity(departmentDto);

        return DepartmentMapper.mapToDepartmentDto(departmentRepository.save(department));
    }
}