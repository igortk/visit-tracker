package com.example.visit.tracker.controller.visit;

import com.example.visit.tracker.dto.api.request.VisitCreateRequest;
import com.example.visit.tracker.service.db.DatabaseProvider;
import jakarta.validation.Valid;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/visit")
public class VisitController {
    @Autowired
    @Qualifier("MySqlProvider")
    private DatabaseProvider provider;

    @SneakyThrows
    @PostMapping("/create")
    public ResponseEntity<?> createVisit(@Valid @RequestBody VisitCreateRequest body) {
        provider.addVisit(body);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
