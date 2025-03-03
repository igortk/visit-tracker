package com.example.visit.tracker.service.db.mysql;

import com.example.visit.tracker.dto.api.request.VisitCreateRequest;
import com.example.visit.tracker.error.InvalidDatabaseWorkException;
import com.example.visit.tracker.service.db.DatabaseProvider;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

@Log4j2
@Service("MySqlProvider")
public class MySqlProvider implements DatabaseProvider {
    private final NamedParameterJdbcTemplate jdbcTemplate;

    @Autowired
    public MySqlProvider(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void addVisit(VisitCreateRequest body) throws InvalidDatabaseWorkException {
        var sql = """
                INSERT INTO visits
                (start_date_time, end_date_time, patient_id, doctor_id)
                VALUES(:startDateTime, :endDateTime, :patientId, :doctorId);
                """;
        var params = new MapSqlParameterSource()
                .addValue("startDateTime", body.getStart())
                .addValue("endDateTime", body.getEnd())
                .addValue("patientId", body.getPatientId())
                .addValue("doctorId", body.getDoctorId());
        try {
            jdbcTemplate.update(sql, params);
        } catch (Exception ex) {
            log.error(ex);
            throw new InvalidDatabaseWorkException("The appointment for this hour is already taken, or the doctor and/or patient are not in the database");
        }
    }
}

