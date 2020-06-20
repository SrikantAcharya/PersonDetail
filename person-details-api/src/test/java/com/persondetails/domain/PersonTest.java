package com.persondetails.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import nl.jqno.equalsverifier.EqualsVerifier;

public class PersonTest {

	private Address address = new Address();

	@Test
	public void testPersonWithNullValues() {
		Person person = new Person();
		assertThat(person.getId()).isEqualTo(0L);
		assertThat(person.getFirstName()).isNull();
		assertThat(person.getLastName()).isNull();
		assertThat(person.getAddress()).isNull();

	}

	@Test
	public void testPersonWithValues() {
		Person person = new Person();
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

		assertThat(person.getId()).isEqualTo(1L);
		assertThat(person.getFirstName()).isEqualTo("Srikant");
		assertThat(person.getLastName()).isEqualTo("Acharya");
		assertThat(person.getAddress()).isEqualTo(list);

	}
}
