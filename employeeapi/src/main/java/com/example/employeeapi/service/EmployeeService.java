package com.example.employeeapi.service;
 
import com.example.employeeapi.dto.EmployeeRequest;
import com.example.employeeapi.dto.EmployeeResponse;
import com.example.employeeapi.dto.EmployeeFilter;
import com.example.employeeapi.model.Employee;
import com.example.employeeapi.repository.EmployeeRepository;
import com.example.employeeapi.specification.EmployeeSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
 
@Service
public class EmployeeService {
 
    @Autowired
    private EmployeeRepository repository;
 
    @Autowired
    private EmployeeSpecification employeeSpecification;
 
    // Create an employee
    public EmployeeResponse createEmployee(EmployeeRequest request) {
        Employee employee = new Employee();
        employee.setName(request.getName());
        employee.setAge(request.getAge());
        employee.setDob(request.getDob());
        employee.setMobileNumber(request.getMobileNumber());
        employee.setDepartment(request.getDepartment());
        employee.setEmail(request.getEmail());
        employee.setPanNumber(request.getPanNumber());
        employee.setCreatedBy(request.getCreatedBy());
        employee.setLastModifiedBy(request.getLastModifiedBy());
 
        Employee savedEmployee = repository.save(employee);
        return mapToResponse(savedEmployee);
    }
 
    // Get employees with filtering, pagination, and sorting
    public Page<EmployeeResponse> getEmployees(EmployeeFilter filter, int page, int size, String sortDirection) {
        Pageable pageable = PageRequest.of(
                page,
                size,
"asc".equalsIgnoreCase(sortDirection) ? Sort.by("updatedAt").ascending() : Sort.by("updatedAt").descending()
        );
        Specification<Employee> spec = employeeSpecification.getEmployees(filter);
        return repository.findAll(spec, pageable).map(this::mapToResponse);
    }
    
    // Clone an employee
    public EmployeeResponse cloneEmployee(Long id) {
        Employee existingEmployee = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found"));
 
        Employee clonedEmployee = new Employee();
        clonedEmployee.setName(existingEmployee.getName());
        clonedEmployee.setAge(existingEmployee.getAge());
        clonedEmployee.setDob(existingEmployee.getDob());
        clonedEmployee.setMobileNumber(existingEmployee.getMobileNumber());
        clonedEmployee.setDepartment(existingEmployee.getDepartment());
        clonedEmployee.setEmail(existingEmployee.getEmail() + "_clone");  // Unique email
        clonedEmployee.setCreatedBy("Cloned");
        clonedEmployee.setLastModifiedBy("Cloned from ID: " + existingEmployee.getId());
 
        Employee savedClonedEmployee = repository.save(clonedEmployee);
        return mapToResponse(savedClonedEmployee);
    }
 
    // Update an employee
    public EmployeeResponse updateEmployee(Long id, EmployeeRequest request) {
        Employee existingEmployee = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found"));
 
        if (!existingEmployee.getEmail().equals(request.getEmail())
                && repository.existsByEmail(request.getEmail())) {
            throw new RuntimeException("Email already exists");
        }
 
        if (!existingEmployee.getMobileNumber().equals(request.getMobileNumber())
                && repository.existsByMobileNumber(request.getMobileNumber())) {
            throw new RuntimeException("Mobile number already exists");
        }
 
        // Update fields
        existingEmployee.setName(request.getName());
        existingEmployee.setAge(request.getAge());
        existingEmployee.setDob(request.getDob());
        existingEmployee.setMobileNumber(request.getMobileNumber());
        existingEmployee.setDepartment(request.getDepartment());
        existingEmployee.setEmail(request.getEmail());
        existingEmployee.setPanNumber(request.getPanNumber());
        existingEmployee.setLastModifiedBy(request.getLastModifiedBy());
        
        existingEmployee.setVersion(existingEmployee.getVersion() + 1);
 
        Employee updatedEmployee = repository.save(existingEmployee);
        return mapToResponse(updatedEmployee);
    }
 
    // Delete an employee by ID
    public void deleteEmployeeById(Long id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Employee not found");
        }
        repository.deleteById(id);
    }
 
    // Delete all employees
    public void deleteAllEmployees() {
        repository.deleteAll();
    }
 
    // Map Employee entity to EmployeeResponse DTO
    private EmployeeResponse mapToResponse(Employee employee) {
        return new EmployeeResponse(
                employee.getId(),
                employee.getName(),
                employee.getAge(),
                employee.getDob(),
                employee.getMobileNumber(),
                employee.getDepartment(),
                employee.getEmail(),
                employee.getCreatedBy(),
                employee.getLastModifiedBy(),
                employee.getCreatedAt(),
                employee.getUpdatedAt(),
                employee.getVersion()
        );
    }
}