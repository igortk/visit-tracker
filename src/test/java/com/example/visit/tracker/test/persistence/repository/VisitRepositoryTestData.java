package com.example.visit.tracker.test.persistence.repository;

import com.example.visit.tracker.persistence.entity.Visit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VisitRepositoryTestData extends JpaRepository<Visit, Integer> {
}
