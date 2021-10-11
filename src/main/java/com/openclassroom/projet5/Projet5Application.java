package com.openclassroom.projet5;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.openclassroom.projet5.model.JsonSource;
import com.openclassroom.projet5.service.PersonService;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.Resource;

@SpringBootApplication
public class Projet5Application {

	public static void main(String[] args) {
		SpringApplication.run(Projet5Application.class, args);
	}

	@Value("classpath:json/data.json")
	private Resource jsonSource;
	@Bean
	CommandLineRunner runner(PersonService personService){
		return args -> {
			ObjectMapper mapper = new ObjectMapper();

			mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false);
			//JSON file to Java object
			JsonSource obj = mapper.readValue(jsonSource.getFile(), JsonSource.class);
			personService.save(obj.getPersons());

	};

}
}
