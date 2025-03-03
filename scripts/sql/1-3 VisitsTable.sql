CREATE TABLE `visits` (
  `id` int NOT NULL AUTO_INCREMENT,
  `start_date_time` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `end_date_time` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `patient_id` int NOT NULL,
  `doctor_id` int NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `unique_visit` (`doctor_id`,`start_date_time`),
  KEY `patient_id` (`patient_id`),
  CONSTRAINT `visits_ibfk_1` FOREIGN KEY (`doctor_id`) REFERENCES `doctors` (`id`),
  CONSTRAINT `visits_ibfk_2` FOREIGN KEY (`patient_id`) REFERENCES `patients` (`id`)
);