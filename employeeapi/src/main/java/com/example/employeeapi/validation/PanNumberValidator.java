package com.example.employeeapi.validation;
 
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
 
public class PanNumberValidator implements ConstraintValidator<ValidPanNumber, String> {
 
    private static final String PAN_REGEX = "^[A-Z]{5}[0-9]{4}[A-Z]{1}$";
 
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null || value.isEmpty()) {
            return false;
        }
        return value.matches(PAN_REGEX);
    }
}