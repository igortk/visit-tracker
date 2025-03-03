package com.example.visit.tracker.persistence.repository;

import com.example.visit.tracker.persistence.entity.Visit;
import com.example.visit.tracker.dto.DoctorPatientCount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VisitRepository extends JpaRepository<Visit, Integer> {
    @Query("""
                SELECT v FROM Visit v
                WHERE v.patient.id IN :patientIds
                AND v.start = (
                    SELECT MAX(v2.start) FROM Visit v2
                    WHERE v2.patient.id = v.patient.id
                    AND v2.doctor.id = v.doctor.id
                )
                ORDER BY v.patient.id, v.start DESC
            """)
    List<Visit> findLastVisitsForPatients(@Param("patientIds") List<Integer> patientIds);


    @Query("""
                SELECT new com.example.visit.tracker.dto.DoctorPatientCount(
                    v.doctor.id, COUNT(DISTINCT v.patient.id)
                )
                FROM Visit v
                WHERE v.doctor.id IN :doctorIds
                GROUP BY v.doctor.id
            """)
    List<DoctorPatientCount> countUniquePatientsByDoctors(@Param("doctorIds") List<Integer> doctorIds);
}
