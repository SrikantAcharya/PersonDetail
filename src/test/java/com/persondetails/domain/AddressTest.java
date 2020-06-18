package com.persondetails.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

public class AddressTest {

	private Person person=new Person();
	
	@Test
	public void testAddressWithNullValues() {
		Address address=new Address();
		
		assertThat(address.getId()).isEqualTo(0);
		assertThat(address.getStreet()).isNull();
		assertThat(address.getCity()).isNull();
		assertThat(address.getState()).isNull();
		assertThat(address.getPostalcode()).isEqualTo(0);
		assertThat(address.getPerson()).isNull();
	}
	@Test
	public void testAddressWithValues() {
		Address address=new Address();
        List<Address> list=new ArrayList<>();
		
		address.setId(1L);
		address.setStreet("lingampally");
		address.setCity("hyd");
		address.setState("telangana");
		address.setPostalcode(500019);
					
		person.setId(1L);
		person.setFirstName("Srikant");
		person.setLastName("Acharya");
		person.setAddress(list);
		
		address.setId(2L);
		address.setStreet("seetafalmandi");
		address.setCity("hyd");
		address.setState("telangana");
		address.setPostalcode(500009);
		address.setPerson(person);
			
		assertThat(address.getId()).isEqualTo(2L);
		assertThat(address.getStreet()).isEqualTo("seetafalmandi");
		assertThat(address.getCity()).isEqualTo("hyd");
		assertThat(address.getState()).isEqualTo("telangana");
		assertThat(address.getPostalcode()).isEqualTo(500009);
		assertThat(address.getPerson()).isEqualTo(person);
	}
}
