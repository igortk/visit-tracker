CREATE INDEX idx_visit_doctor_patient ON visits (doctor_id, patient_id);
CREATE INDEX idx_visit_patient_id ON visits (patient_id);
CREATE INDEX idx_visit_patient_doctor_start ON visits (patient_id, doctor_id, start_date_time);
CREATE INDEX idx_visit_doctor_id ON visits (doctor_id);