package com.persondetails.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.persondetails.domain.Person;
@Repository
public interface PersonRepositiry extends CrudRepository<Person, Long> {
	
}
