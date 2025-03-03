package com.example.visit.tracker.persistence.specification;

import com.example.visit.tracker.persistence.entity.Patient;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

public class PatientSpecification {

    public static Specification<Patient> hasNameLike(String search) {
        return (root, query, criteriaBuilder) -> {
            if (search == null || search.isEmpty()) {
                return null;
            }
            return criteriaBuilder.like(root.get("firstName"), "%" + search + "%");
        };
    }

    public static Specification<Patient> hasDoctorIds(List<Integer> doctorIds) {
        return (root, query, criteriaBuilder) -> {
            if (doctorIds == null || doctorIds.isEmpty()) {
                return null;
            }
            var visitJoin = root.join("visits");
            return visitJoin.get("doctor").get("id").in(doctorIds);
        };
    }
}
