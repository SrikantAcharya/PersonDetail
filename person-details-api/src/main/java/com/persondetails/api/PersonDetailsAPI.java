package com.persondetails.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages ="com.persondetails.repository")
@ComponentScan({"com.persondetails.dao"})
@EntityScan("com.persondetails.domain")
public class PersonDetailsAPI {

	public static void main(String[] args) {
		SpringApplication.run(PersonDetailsAPI.class, args);
	}

}
