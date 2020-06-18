package com.persondetails.dao;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.MockitoAnnotations.initMocks;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.persondetails.domain.Address;
import com.persondetails.domain.Person;
import com.persondetails.repository.PersonRepositiry;

public class PersonCRUDControllerTest {

	@Mock
	private PersonRepositiry personRepository;
	
	@InjectMocks
	private PersonCRUDController personCRUDController;
	
	@Test
	public void testCreateOrSavePerson() {
		initMocks(this);
		Person person=new Person();
		Address address=new Address();
		List<Address> list=new ArrayList<>();
		
		address.setId(1L);
		address.setStreet("lingampally");
		address.setCity("hyd");
		address.setState("telangana");
		address.setPostalcode(500019);
		
		list.add(address);
		
		address.setId(2L);
		address.setStreet("sitafalmandi");
		address.setCity("hyd");
		address.setState("telangana");
		address.setPostalcode(500009);
		
		list.add(address);
		
		person.setId(1L);
		person.setFirstName("Srikant");
		person.setLastName("Acharya");
		person.setAddress(list);
		
		given(personRepository.save(person)).willReturn(person);
		Person personDet = personCRUDController.createOrSavePerson(person);
		assertThat(personDet.getId()).isEqualTo(1L);
		assertThat(personDet.getFirstName()).isEqualTo("Srikant");
		assertThat(personDet.getLastName()).isEqualTo("Acharya");
		assertThat(personDet.getAddress()).isEqualTo(list);
	}
	@Test
	public void testUpdatePerson() {
		initMocks(this);
		Person person=new Person();
		person.setFirstName("Deepak");
		person.setLastName("Mahala");
		
		given(personRepository.save(person)).willReturn(person);
		Person personDet =personCRUDController.updatePerson(person, 1L);
		assertThat(personDet.getFirstName()).isEqualTo("Deepak");
		assertThat(personDet.getLastName()).isEqualTo("Mahala");
	}
	
}
