package com.example.visit.tracker.validator;

import com.example.visit.tracker.dto.api.request.VisitCreateRequest;
import com.example.visit.tracker.validator.annotation.ValidVisitRequest;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class VisitRequestValidator implements ConstraintValidator<ValidVisitRequest, VisitCreateRequest> {

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    @Override
    public boolean isValid(VisitCreateRequest request, ConstraintValidatorContext context) {
        if (request == null) {
            return false;
        }

        if (request.getStart() == null || request.getEnd() == null) {
            context.buildConstraintViolationWithTemplate("Start and End date must not be null")
                    .addPropertyNode("start")
                    .addConstraintViolation();
            return false;
        }

        try {
            var startDateTime = LocalDateTime.parse(request.getStart(), FORMATTER);
            var endDateTime = LocalDateTime.parse(request.getEnd(), FORMATTER);

            if (startDateTime.isAfter(endDateTime)) {
                context.buildConstraintViolationWithTemplate("Start date must be before End date")
                        .addPropertyNode("start")
                        .addConstraintViolation();
                return false;
            }

        } catch (DateTimeParseException e) {
            context.buildConstraintViolationWithTemplate("Invalid date format. Use 'yyyy-MM-dd HH:mm:ss'")
                    .addPropertyNode("start")
                    .addConstraintViolation();
            return false;
        }

        if (request.getPatientId() == null || request.getDoctorId() == null) {
            context.buildConstraintViolationWithTemplate("PatientId and DoctorId must not be null")
                    .addPropertyNode("patientId")
                    .addConstraintViolation();
            return false;
        }

        return true;
    }
}

