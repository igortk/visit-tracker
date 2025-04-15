CREATE TABLE public.visits (
  id SERIAL PRIMARY KEY,
  start_date_time VARCHAR(100) NOT NULL,
  end_date_time VARCHAR(100) NOT NULL,
  patient_id INT NOT NULL,
  doctor_id INT NOT NULL,
  CONSTRAINT unique_visit UNIQUE (doctor_id, start_date_time),
  CONSTRAINT fk_visits_doctor FOREIGN KEY (doctor_id) REFERENCES public.doctors(id),
  CONSTRAINT fk_visits_patient FOREIGN KEY (patient_id) REFERENCES public.patients(id)
)