package com.example.visit.tracker;

import com.example.visit.tracker.test.TestDataGenerator;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ApplicationTests {
	@Autowired
	private TestDataGenerator testDataGenerator;
	@Test
	@Disabled("only manual")
	void generateTestData() {
		testDataGenerator.generateTestData();
	}

}
