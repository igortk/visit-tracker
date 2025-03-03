package com.example.visit.tracker.dto.api.response;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class VisitResponse {
    private String start;
    private String end;
    private DoctorResponse doctor;
}
