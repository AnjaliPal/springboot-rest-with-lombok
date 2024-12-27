package com.example.lombok.service.impl;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.lombok.entity.Department;
import com.example.lombok.repository.DepartmentRepository;
import com.example.lombok.service.DepartmentService;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    protected static final Logger logger = LogManager.getLogger();

    @Autowired
    DepartmentRepository departmentRepository;

    @Override
    public List<Department> getDepartmentList() {
        logger.info("Finding all the departments!");
        return departmentRepository.findAll();
    }

    @Override
    public Optional<Department> getDepartmentById(Integer departmentId) {
        return departmentRepository.findById(departmentId);
    }

    @Override
    public Department addDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public Optional<Department> updateDepartment(Department department, Integer departmentId) {
        if (departmentRepository.findById(departmentId).isPresent()) {
            Department updatedDepartment = new Department();
            updatedDepartment.setDepartmentName(department.getDepartmentName());
            updatedDepartment.setDepartmentAddress(department.getDepartmentAddress());
            updatedDepartment.setDepartmentCode(department.getDepartmentCode());
            return Optional.of(departmentRepository.save(updatedDepartment));

        } else {
            return Optional.empty();
        }
    }

    @Override
    public void deleteDepartment(Integer departmentId) {
        departmentRepository.deleteById(departmentId);

    }

}
