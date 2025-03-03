package com.example.visit.tracker;

import com.example.visit.tracker.test.persistence.TestDataGenerator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ApplicationTests {
	@Autowired
	private TestDataGenerator testDataGenerator;
	@Test
	void generateTestData() {
		testDataGenerator.generateTestData();
	}

}
