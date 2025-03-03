package com.example.visit.tracker.test.persistence;

import com.example.visit.tracker.persistence.entity.Doctor;
import com.example.visit.tracker.persistence.entity.Patient;
import com.example.visit.tracker.persistence.entity.Visit;
import com.example.visit.tracker.test.persistence.repository.DoctorRepositoryTestData;
import com.example.visit.tracker.test.persistence.repository.PatientRepositoryTestData;
import com.example.visit.tracker.test.persistence.repository.VisitRepositoryTestData;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

@Service
@Log4j2
public class TestDataGenerator {
    @Autowired
    private PatientRepositoryTestData patientRepositoryTestData;
    @Autowired
    private DoctorRepositoryTestData doctorRepositoryTestData;
    @Autowired
    private VisitRepositoryTestData visitRepositoryTestData;
    private static final Random random = new Random();
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    @Transactional
    public void generateTestData() {
        for (int i = 0; i < 10000; i++) {
            patientRepositoryTestData.save(Patient.builder()
                    .firstName("FirstName" + i)
                    .lastName("LastName" + i)
                    .build()
            );
            log.info("Patient {}", i);
        }

        for (int i = 0; i < 3000; i++) {
            doctorRepositoryTestData.save(Doctor.builder()
                    .firstName("DoctorFirstName" + i)
                    .lastName("DoctorLastName" + i)
                    .build());
            log.info("Doctor {}", i);
        }

        for (int i = 0; i < 10000; i++) {
            var patient = patientRepositoryTestData.findById(random.nextInt(10000) + 1).orElseThrow();
            var doctor = doctorRepositoryTestData.findById(random.nextInt(3000) + 1).orElseThrow();

            var visitBuilder = Visit.builder().patient(patient).doctor(doctor).build();

            var start = LocalDateTime.now().minusDays(random.nextInt(3650));
            visitBuilder.setStart(start.format(formatter));

            var end = start.plusMinutes(random.nextInt(120) + 1);
            visitBuilder.setEnd(end.format(formatter));

            visitRepositoryTestData.save(visitBuilder);
            System.out.println("Visit " + i);
        }
    }
}
