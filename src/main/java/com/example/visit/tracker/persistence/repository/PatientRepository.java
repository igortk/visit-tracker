package com.example.visit.tracker.persistence.repository;

import com.example.visit.tracker.persistence.entity.Patient;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.*;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PatientRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public List<Patient> getPatients(Integer page, Integer size, String search, List<Integer> doctorIds) {
        var criteriaBuilder = entityManager.getCriteriaBuilder();
        var query = criteriaBuilder.createQuery(Patient.class);
        var root = query.from(Patient.class);
        var predicates = new ArrayList<Predicate>();

        if (search != null && !search.isEmpty()) {
            predicates.add(criteriaBuilder.like(root.get("firstName"), "%" + search + "%"));
        }

        if (doctorIds != null && !doctorIds.isEmpty()) {
            var visitJoin = root.join("visits");
            predicates.add(visitJoin.get("doctor").get("id").in(doctorIds));
        }

        query.select(root).where(predicates.toArray(new Predicate[0]));

        query.orderBy(criteriaBuilder.desc(root.get("id")));

        return entityManager.createQuery(query)
                .setFirstResult((page - 1) * size)
                .setMaxResults(size)
                .getResultList();
    }
}
