package com.example.employeeapi.dto;
 
import lombok.Data;
 
@Data
public class EmployeeFilter {
    private String name;
    private Integer age;
    private String email;
    private String department;
    private String mobileNumber;
    private String createdBy;
    private String lastModifiedBy;
}
