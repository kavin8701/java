package com.example.employeeapi.model;
 
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
 
import java.time.LocalDate;
import java.time.LocalDateTime;
 
@Data
@Entity
@Table(name = "employees")
public class Employee {
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
 
    @Column(nullable = false)
    private String name;
 
    @Column(nullable = false)
    private int age;
 
    @Column(nullable = false)
    private LocalDate dob;
 
    @Column(length = 10, nullable = false)
    private String mobileNumber;
 
    @Column(nullable = false)
    private String department;
 
    @Column(unique = true, nullable = false)
    private String email;
    
    private String panNumber;
 
    @Column(nullable = false)
    private String createdBy;
 
    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;
 
    @Column
    private String lastModifiedBy;  
 
    @UpdateTimestamp
    @Column
    private LocalDateTime updatedAt;
    
    @Version
    @Column(nullable = false)
    private Long version;
}
