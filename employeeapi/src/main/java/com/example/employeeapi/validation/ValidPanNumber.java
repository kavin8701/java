package com.example.employeeapi.validation;
 
import jakarta.validation.Constraint;
import jakarta.validation.Payload;
 
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
 
// Custom annotation
@Constraint(validatedBy = PanNumberValidator.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidPanNumber {
    String message() default "Invalid PAN number. Format: 5 letters, 4 digits, 1 letter (e.g., ABCDE1234F)";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}