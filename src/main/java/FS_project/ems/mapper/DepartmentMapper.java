package FS_project.ems.mapper;

import FS_project.ems.dto.DepartmentDto;
import FS_project.ems.entity.DepartmentEntity;

public class DepartmentMapper {

    public static DepartmentDto mapToDepartmentDto(DepartmentEntity departmentEntity) {
        return new DepartmentDto(
                departmentEntity.getId(),
                departmentEntity.getDepartmentName(),
                departmentEntity.getDepartmentDescription()
        );
    }

    public static DepartmentEntity mapToDepartmentEntity(DepartmentDto departmentDto) {
        return new DepartmentEntity(
                departmentDto.getId(),
                departmentDto.getDepartmentName(),
                departmentDto.getDepartmentDescription()
        );
    }
}
