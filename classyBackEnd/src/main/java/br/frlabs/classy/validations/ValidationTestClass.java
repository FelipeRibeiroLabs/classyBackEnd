package br.frlabs.classy.validations;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Objects;

public class ValidationTestClass implements ConstraintValidator< TestValidation ,String> {

    @Override
    public void initialize(TestValidation constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        return !Objects.equals(value, "test") && !Objects.equals(value, "TEST");
    }
}
