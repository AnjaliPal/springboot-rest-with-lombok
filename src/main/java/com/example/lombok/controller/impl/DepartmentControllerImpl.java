package com.example.lombok.controller.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.lombok.controller.DepartmentController;
import com.example.lombok.entity.Department;
import com.example.lombok.service.DepartmentService;

public class DepartmentControllerImpl implements DepartmentController {

    @Autowired
    DepartmentService departmentService;

    @Override
    public List<Department> getDepartmentList() {
        return departmentService.getDepartmentList();
    }

    @Override
    public ResponseEntity<Department> getDepartmentById(Integer departmentId) {
        return departmentService.getDepartmentById(departmentId).map(department -> ResponseEntity.ok().body(department))
                .orElse(ResponseEntity.notFound().build());
    }

    @Override
    public ResponseEntity<Department> addDepartment(Department department) {
        return new ResponseEntity<>(departmentService.addDepartment(department), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Department> updateDepartment(Department department, Integer departmentId) {
        Optional<Department> updatedDepartment = departmentService.updateDepartment(department, departmentId);
        if (updatedDepartment.isPresent()) {
            return ResponseEntity.ok().body(updatedDepartment.get());
        } else {
            return ResponseEntity.notFound().build();
        }

    }

    @Override
    public ResponseEntity<Void> deleteDepartment(Integer departmentId) {
        if (departmentService.getDepartmentById(departmentId).isPresent()) {
            departmentService.deleteDepartment(departmentId);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();

    }

}
