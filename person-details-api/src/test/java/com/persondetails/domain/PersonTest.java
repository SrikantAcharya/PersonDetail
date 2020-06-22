package com.persondetails.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import lombok.RequiredArgsConstructor;
import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;

public class PersonTest {

	Address address1 = new Address();
	Address address2 = new Address();
	Person person1 = new Person();
	Person person2 = new Person();

	@Test
	public void testPersonWithNullValues() {
		assertThat(person1.getId()).isEqualTo(0L);
		assertThat(person1.getFirstName()).isNull();
		assertThat(person1.getLastName()).isNull();
		assertThat(person1.getAddress()).isNull();

	}

	@Test
	public void testPersonWithValues() {

		List<Address> list = new ArrayList<>();

		address1.setId(1L);
		address1.setStreet("lingampally");
		address1.setCity("hyd");
		address1.setState("telangana");
		address1.setPostalcode(500019);

		address2.setId(2L);
		address2.setStreet("sitafalmandi");
		address2.setCity("hyd");
		address2.setState("telangana");
		address2.setPostalcode(500009);

		list.add(address1);
		list.add(address2);

		person1.setId(1L);
		person1.setFirstName("Srikant");
		person1.setLastName("Acharya");
		person1.setAddress(list);

		person2.setId(2L);
		person2.setFirstName("Deepak");
		person2.setLastName("Sharma");
		person2.setAddress(list);

		assertThat(person1.getId()).isEqualTo(1L);
		assertThat(person1.getFirstName()).isEqualTo("Srikant");
		assertThat(person1.getLastName()).isEqualTo("Acharya");
		assertThat(person1.getAddress()).isEqualTo(list);

		EqualsVerifier.forClass(Person.class).withPrefabValues(Person.class, person1, person2)
				.suppress(Warning.STRICT_INHERITANCE, Warning.NONFINAL_FIELDS).verify();

	}
}
