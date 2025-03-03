package com.example.visit.tracker.validator.annotation;

import com.example.visit.tracker.validator.VisitRequestValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = VisitRequestValidator.class)
public @interface ValidVisitRequest {
    String message() default "Invalid VisitCreateRequest data";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
