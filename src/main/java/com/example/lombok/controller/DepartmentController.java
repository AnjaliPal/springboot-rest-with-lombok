package com.example.lombok.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.lombok.entity.Department;

@RestController
@RequestMapping("/departments")
public interface DepartmentController {

    @GetMapping
    List<Department> getDepartmentList();

    @GetMapping("/{id}")
    ResponseEntity<Department> getDepartmentById(Integer departmentId);

    @PostMapping
    ResponseEntity<Department> addDepartment(@RequestBody Department department);

    @PutMapping("/{id}")
    ResponseEntity<Department> updateDepartment(@RequestBody Department updatedDepartment,
            @PathVariable("id") Integer departmentId);

    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteDepartment(@PathVariable("id") Integer departmentId);

}