package com.example.visit.tracker.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class DoctorPatientCount {
    private Integer doctorId;
    private Long count;
}
