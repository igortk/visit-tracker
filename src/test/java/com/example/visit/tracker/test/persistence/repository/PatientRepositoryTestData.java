package com.example.visit.tracker.test.persistence.repository;

import com.example.visit.tracker.persistence.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepositoryTestData extends JpaRepository<Patient, Integer> {
}
