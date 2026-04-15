package com.IRCTC.RailConnect.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CoachValidator implements ConstraintValidator<ValidCoach, Integer> { // <Annotation, FieldType>
    @Override
    public boolean isValid(Integer integer, ConstraintValidatorContext constraintValidatorContext) {

        //custom validation logic
        System.out.println("@ValidCoach is checking...");
        if(integer == null) return false;

        return integer >= 100 && integer <= 200;
    }
}
