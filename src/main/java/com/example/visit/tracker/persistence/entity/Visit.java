package com.example.visit.tracker.persistence.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Builder
@Table(name = "visits")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Visit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;

    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;

    @Column(name = "start_date_time")
    private String start;

    @Column(name = "end_date_time")
    private String end;
}
