package com.example.visit.tracker.dto.api.request;

import com.example.visit.tracker.validator.annotation.ValidVisitRequest;
import lombok.Getter;

@Getter
@ValidVisitRequest
public class VisitCreateRequest {
    private String start;
    private String end;
    private Integer patientId;
    private Integer doctorId;
}
