package com.example.visit.tracker.service.db;

import com.example.visit.tracker.dto.api.request.VisitCreateRequest;
import com.example.visit.tracker.error.InvalidDatabaseWorkException;

public interface DatabaseProvider {
    void addVisit(VisitCreateRequest body) throws InvalidDatabaseWorkException;
}
