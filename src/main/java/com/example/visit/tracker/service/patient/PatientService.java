package com.example.visit.tracker.service.patient;

import com.example.visit.tracker.dto.DoctorPatientCount;
import com.example.visit.tracker.dto.api.response.DoctorResponse;
import com.example.visit.tracker.dto.api.response.PatientResponse;
import com.example.visit.tracker.dto.api.response.VisitResponse;
import com.example.visit.tracker.persistence.entity.Patient;
import com.example.visit.tracker.persistence.repository.PatientRepository;
import com.example.visit.tracker.persistence.repository.VisitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class PatientService {
    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private VisitRepository visitRepository;

    public List<PatientResponse> getPatients(Integer page, Integer size, String search, List<Integer> doctorIds) {
        var patients = patientRepository.getPatients(page, size, search, doctorIds);

        var patientIds = patients.stream().map(Patient::getId).toList();

        var lastVisits = visitRepository.findLastVisitsForPatients(patientIds);
        var doctorIdsFromVisits = lastVisits.stream()
                .map(v -> v.getDoctor().getId())
                .distinct()
                .toList();

        var doctorPatientCounts = visitRepository.countUniquePatientsByDoctors(doctorIdsFromVisits);

        var visitsMap = lastVisits.stream()
                .collect(Collectors.groupingBy(v -> v.getPatient().getId()));

        var doctorPatientsMap = doctorPatientCounts.stream()
                .collect(Collectors.toMap(DoctorPatientCount::getDoctorId, DoctorPatientCount::getCount));

        return patients.stream().map(patient -> {
            var visitData = visitsMap.getOrDefault(patient.getId(), Collections.emptyList()).stream()
                    .map(visit -> {
                        var doctor = DoctorResponse.builder()
                                .firstName(visit.getDoctor().getFirstName())
                                .lastName(visit.getDoctor().getLastName())
                                .totalPatients(doctorPatientsMap.getOrDefault(visit.getDoctor().getId(), 0L))
                                .build();

                        return VisitResponse.builder()
                                .start(visit.getStart())
                                .end(visit.getEnd())
                                .doctor(doctor)
                                .build();
                    })
                    .toList();

            return PatientResponse.builder()
                    .firstName(patient.getFirstName())
                    .lastName(patient.getLastName())
                    .visits(visitData)
                    .build();
        }).toList();
    }
}

