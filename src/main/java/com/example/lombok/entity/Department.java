package com.example.lombok.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "department")
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer departmentId;

    private String departmentName;
    private String departmentAddress;
    private String departmentCode;

}