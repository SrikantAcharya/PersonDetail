package com.persondetails.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;

public class AddressTest {

	Person person1 = new Person();
	Address address1 = new Address();
	Address address2 = new Address();
	@Test
	public void testAddressWithNullValues() {

		assertThat(address1.getId()).isEqualTo(0);
		assertThat(address1.getStreet()).isNull();
		assertThat(address1.getCity()).isNull();
		assertThat(address1.getState()).isNull();
		assertThat(address1.getPostalcode()).isEqualTo(0);
		assertThat(address1.getPerson()).isNull();

	}

	@Test
	public void testAddressWithValues() {
		
		List<Address> list = new ArrayList<>();	
		
		person1.setId(1L);
		person1.setFirstName("Srikant");
		person1.setLastName("Acharya");
		
		address1.setId(1L);
		address1.setStreet("lingampally");
		address1.setCity("hyd");
		address1.setState("telangana");
		address1.setPostalcode(500019);
		address1.setPerson(person1);
		
		address2.setId(2L);
		address2.setStreet("seetafalmandi");
		address2.setCity("hyd");
		address2.setState("telangana");
		address2.setPostalcode(500009);
		address2.setPerson(person1);
				
		assertThat(address2.getId()).isEqualTo(2L);
		assertThat(address2.getStreet()).isEqualTo("seetafalmandi");
		assertThat(address2.getCity()).isEqualTo("hyd");
		assertThat(address2.getState()).isEqualTo("telangana");
		assertThat(address2.getPostalcode()).isEqualTo(500009);
		assertThat(address2.getPerson()).isEqualTo(person1);
		
		EqualsVerifier.forClass(Address.class).withPrefabValues(Address.class, address1, address2)
		.suppress(Warning.STRICT_INHERITANCE, Warning.NONFINAL_FIELDS).verify();

	}

}
