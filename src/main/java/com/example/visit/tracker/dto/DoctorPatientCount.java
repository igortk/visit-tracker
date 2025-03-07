package com.example.visit.tracker.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DoctorPatientCount {
    private Integer doctorId;
    private Long count;
}
