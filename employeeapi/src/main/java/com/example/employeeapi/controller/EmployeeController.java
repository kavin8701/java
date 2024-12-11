package com.example.employeeapi.controller;
 
import com.example.employeeapi.dto.EmployeeRequest;
import com.example.employeeapi.dto.EmployeeResponse;
import com.example.employeeapi.dto.EmployeeFilter;
import com.example.employeeapi.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
 
@RestController
@RequestMapping("/api/employees")
@Validated
public class EmployeeController {
 
    @Autowired
    private EmployeeService employeeService;
 
    // Create an employee
    @PostMapping("/add")
    public ResponseEntity<EmployeeResponse> createEmployee(@Valid @RequestBody EmployeeRequest request) {
        EmployeeResponse response = employeeService.createEmployee(request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
    
    @PostMapping("/{id}/clone")
    public ResponseEntity<EmployeeResponse> cloneEmployee(@PathVariable Long id) {
        EmployeeResponse clonedEmployee = employeeService.cloneEmployee(id);
        return new ResponseEntity<>(clonedEmployee, HttpStatus.CREATED);
    }
    // Update an employee
    @PutMapping("/{id}")
    public ResponseEntity<EmployeeResponse> updateEmployee(@PathVariable Long id, @Valid @RequestBody EmployeeRequest request) {
        EmployeeResponse response = employeeService.updateEmployee(id, request);
        return ResponseEntity.ok(response);
    }
 
    // Get all employees with pagination and sorting
    @GetMapping("/all")
    public Page<EmployeeResponse> getAllEmployees(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "desc") String sortDirection) {
        return employeeService.getEmployees(new EmployeeFilter(), page, size, sortDirection);
    }
 
    // Filter employees by criteria
    @GetMapping("/filter")
    public Page<EmployeeResponse> getFilteredEmployees(
            EmployeeFilter filter,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "desc") String sortDirection) {
        return employeeService.getEmployees(filter, page, size, sortDirection);
    }
 
    // Delete an employee by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEmployeeById(@PathVariable Long id) {
        employeeService.deleteEmployeeById(id);
        return ResponseEntity.ok("Employee deleted successfully");
    }
 
    // Delete all employees
    @DeleteMapping("/all")
    public ResponseEntity<String> deleteAllEmployees() {
        employeeService.deleteAllEmployees();
        return ResponseEntity.ok("All employees deleted successfully");
    }
}
