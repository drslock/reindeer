package com.spe.reindeer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.List;
import java.util.Arrays;

@SpringBootApplication
public class ReindeerApplication {

	String[] nameArray = new String[]{"Dasher", "Dancer", "Prancer", "Vixen", "Comet", "Cupid", "Donner", "Blitzen"};
	List<String> validNames = Arrays.asList(nameArray);

	public static void main(String[] args) {
		SpringApplication.run(ReindeerApplication.class, args);
	}

	public boolean isValidName(String name)
	{
		return validNames.contains(name);
	}
}
