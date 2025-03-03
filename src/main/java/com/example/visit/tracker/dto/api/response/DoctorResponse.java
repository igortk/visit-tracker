package com.example.visit.tracker.dto.api.response;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class DoctorResponse {
    private String firstName;
    private String lastName;
    private Long totalPatients;
}
