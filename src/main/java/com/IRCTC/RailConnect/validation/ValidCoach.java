package com.IRCTC.RailConnect.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = CoachValidator.class)
public @interface ValidCoach {
    String message() default "Invalid number of coaches";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
