package com.example.visit.tracker.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DoctorPatientCount {
    private Integer doctorId;
    private Long count;
}
