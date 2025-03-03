package com.example.visit.tracker.dto.api.response;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class PatientResponse {
    private String firstName;
    private String lastName;
    private List<VisitResponse> visits;
}
