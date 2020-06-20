package com.persondetails.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.persondetails.dao.AddressCRUDController;
import com.persondetails.dao.PersonCRUDController;

import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;

public class AddressTest {

	@Test
	public void testAddressWithNullValues() {
		Address address = new Address();

		assertThat(address.getId()).isEqualTo(0);
		assertThat(address.getStreet()).isNull();
		assertThat(address.getCity()).isNull();
		assertThat(address.getState()).isNull();
		assertThat(address.getPostalcode()).isEqualTo(0);
		assertThat(address.getPerson()).isNull();

	}

	@Test
	public void testAddressWithValues() {
		Person person = new Person();
		Address address1 = new Address();
		Address address2 = new Address();
		List<Address> list = new ArrayList<>();

		address1.setId(1L);
		address1.setStreet("lingampally");
		address1.setCity("hyd");
		address1.setState("telangana");
		address1.setPostalcode(500019);

		list.add(address1);

		person.setId(1L);
		person.setFirstName("Srikant");
		person.setLastName("Acharya");
		person.setAddress(list);

		address2.setId(2L);
		address2.setStreet("seetafalmandi");
		address2.setCity("hyd");
		address2.setState("telangana");
		address2.setPostalcode(500009);
		address2.setPerson(person);

		list.add(address1);

		assertThat(address2.getId()).isEqualTo(2L);
		assertThat(address2.getStreet()).isEqualTo("seetafalmandi");
		assertThat(address2.getCity()).isEqualTo("hyd");
		assertThat(address2.getState()).isEqualTo("telangana");
		assertThat(address2.getPostalcode()).isEqualTo(500009);
		assertThat(address2.getPerson()).isEqualTo(person);

	}

}
