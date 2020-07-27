package com.spe.reindeer;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class ReindeerApplicationTests {

	@Autowired
	ReindeerApplication application;

	@Test
	void contextLoads() {
		assertThat(application.isValidName("Donner")).isTrue();
//		assertThat(application.isValidName("Rudolph")).isTrue();
	}

}
