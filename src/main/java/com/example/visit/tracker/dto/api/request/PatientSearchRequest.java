package com.example.visit.tracker.dto.api.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PatientSearchRequest {
    @Min(value = 1, message = "must be greater than 0")
    private Integer page = 1;
    @Min(value = 1, message = "must be greater than 0")
    private Integer size = 20;
    @Pattern(regexp = "^[a-zA-Z]*$", message = "can only contain letters")
    private String search;
    @Pattern(regexp = "([0-9]+,)*[0-9]+", message = "must be a comma-separated list of integers")
    private String doctorIds;
}
