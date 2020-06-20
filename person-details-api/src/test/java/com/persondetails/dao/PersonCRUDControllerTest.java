package com.persondetails.dao;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.persondetails.domain.Address;
import com.persondetails.domain.AddressTest;
import com.persondetails.domain.Person;
import com.persondetails.repository.PersonRepositiry;

import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;

public class PersonCRUDControllerTest {

	@Mock
	private PersonRepositiry personRepository;

	@InjectMocks
	private PersonCRUDController personCRUDController;

	@BeforeEach
	public void setUp() {
		initMocks(this);
	}

	@Test
	public void testCreateOrSavePerson() {
		Person person = new Person();
		Address address = new Address();
		List<Address> list = new ArrayList<>();

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

		EqualsVerifier.forClass(PersonCRUDController.class).withRedefinedSuperclass()
				.suppress(Warning.STRICT_INHERITANCE).suppress(Warning.NONFINAL_FIELDS).verify();
	}

	@Test
	public void testUpdatePerson() {
		Person person = new Person();
		person.setFirstName("Deepak");
		person.setLastName("Mahala");

		given(personRepository.save(person)).willReturn(person);
		when(personRepository.findById(1L)).thenReturn(Optional.of(person));

		Person personDet = personCRUDController.updatePerson(person, 1L);

		assertThat(personDet.getFirstName()).isEqualTo("Deepak");
		assertThat(personDet.getLastName()).isEqualTo("Mahala");

		EqualsVerifier.forClass(PersonCRUDController.class).withRedefinedSuperclass()
				.suppress(Warning.STRICT_INHERITANCE).suppress(Warning.NONFINAL_FIELDS).verify();
	}

	@Test
	public void testDeletePerson() {
		doNothing().when(personRepository).deleteById(1L);
		personCRUDController.deletePerson(1L);

		EqualsVerifier.forClass(PersonCRUDController.class).withRedefinedSuperclass()
				.suppress(Warning.STRICT_INHERITANCE).suppress(Warning.NONFINAL_FIELDS).verify();
		;
	}

	@Test
	public void testGetPersonById() {
		Person person = new Person();
		person.setId(1L);
		person.setFirstName("Srikant");
		person.setLastName("Acharya");

		when(personRepository.findById(1L)).thenReturn(Optional.of(person));

		Person personById = personCRUDController.getPersonById(1L);

		assertThat(personById.getId()).isEqualTo(1L);
		assertThat(personById.getFirstName()).isEqualTo("Srikant");
		assertThat(personById.getLastName()).isEqualTo("Acharya");

		EqualsVerifier.forClass(PersonCRUDController.class).withRedefinedSuperclass()
				.suppress(Warning.STRICT_INHERITANCE).suppress(Warning.NONFINAL_FIELDS).verify();
	}

	@Test
	public void testGetPersonAll() {

		Person person = new Person();
		person.setId(1L);
		person.setFirstName("Srikant");
		person.setLastName("Acharya");

		ArrayList<Person> list = new ArrayList<Person>();
		list.add(person);

		Person person2 = new Person();
		person2.setId(2L);
		person2.setFirstName("Deepak");
		person2.setLastName("Mahala");

		list.add(person2);

		when(personRepository.findAll()).thenReturn(list);
		ArrayList<Person> listNew = (ArrayList<Person>) personRepository.findAll();

		assertThat(list).isEqualTo(listNew);

		EqualsVerifier.forClass(PersonCRUDController.class).withRedefinedSuperclass()
				.suppress(Warning.STRICT_INHERITANCE).suppress(Warning.NONFINAL_FIELDS).verify();
	}
}
