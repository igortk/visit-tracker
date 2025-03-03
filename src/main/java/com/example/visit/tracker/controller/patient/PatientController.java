package com.example.visit.tracker.controller.patient;

import com.example.visit.tracker.dto.api.request.PatientSearchRequest;
import com.example.visit.tracker.dto.api.response.ApiResponse;
import com.example.visit.tracker.service.patient.PatientService;
import jakarta.validation.Valid;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import static com.example.visit.tracker.util.StringUtils.splitStringToListInts;

@Log4j2
@RestController
@RequestMapping("/patients")
@Validated
public class PatientController {
    @Autowired
    private PatientService patientService;

    @GetMapping
    public ResponseEntity<?> getPatients(@Valid PatientSearchRequest request) {
        var allPatients = patientService.getPatients(
                request.getPage(),
                request.getSize(),
                request.getSearch(),
                splitStringToListInts(request.getDoctorIds(), ",")
        );

        return ResponseEntity.ok(ApiResponse.builder().data(allPatients).count(allPatients.size()).build());
    }
}


