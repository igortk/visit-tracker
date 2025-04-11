package com.example.visit.tracker.test.repository;

import com.example.visit.tracker.persistence.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorRepositoryTestData extends JpaRepository<Doctor, Integer> {
}
