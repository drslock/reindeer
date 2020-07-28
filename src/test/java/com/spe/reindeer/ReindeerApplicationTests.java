package com.spe.reindeer;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class ReindeerApplicationTests {

	@Autowired
	ReindeerApplication app;

	@Test
	void contextLoads() {
		assertTrue(app.isValidName("Donner"), "Check 'Donner' is valid");
		assertTrue(app.isValidName("Rudolph"), "Check 'Rudolph' is valid");
	}

}
