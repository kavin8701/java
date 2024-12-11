package com.example.employeeapi.specification;
 
import com.example.employeeapi.dto.EmployeeFilter;
import com.example.employeeapi.model.Employee;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import jakarta.persistence.criteria.Predicate;
 
import java.util.ArrayList;
import java.util.List;
 
@Component
public class EmployeeSpecification {
 
    public Specification<Employee> getEmployees(EmployeeFilter filter) {
        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();
 
            if (filter.getName() != null && !filter.getName().isEmpty()) {
                predicates.add(criteriaBuilder.like(criteriaBuilder.lower(root.get("name")), "%" + filter.getName().toLowerCase() + "%"));
            }
            if (filter.getAge() != null) {
                predicates.add(criteriaBuilder.equal(root.get("age"), filter.getAge()));
            }
            if (filter.getEmail() != null && !filter.getEmail().isEmpty()) {
                predicates.add(criteriaBuilder.like(criteriaBuilder.lower(root.get("email")), "%" + filter.getEmail().toLowerCase() + "%"));
            }
            if (filter.getMobileNumber() != null && !filter.getMobileNumber().isEmpty()) {
                predicates.add(criteriaBuilder.like(criteriaBuilder.lower(root.get("mobileNumber")), "%" + filter.getMobileNumber().toLowerCase() + "%"));
            }
            if (filter.getDepartment() != null && !filter.getDepartment().isEmpty()) {
                predicates.add(criteriaBuilder.like(criteriaBuilder.lower(root.get("department")), "%" + filter.getDepartment().toLowerCase() + "%"));
            }
            if (filter.getCreatedBy() != null && !filter.getCreatedBy().isEmpty()) {
                predicates.add(criteriaBuilder.like(criteriaBuilder.lower(root.get("createdBy")), "%" + filter.getCreatedBy().toLowerCase() + "%"));
            }
            if (filter.getLastModifiedBy() != null && !filter.getLastModifiedBy().isEmpty()) {
                predicates.add(criteriaBuilder.like(criteriaBuilder.lower(root.get("lastModifiedBy")), "%" + filter.getLastModifiedBy().toLowerCase() + "%"));
            }
 
            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }
}
