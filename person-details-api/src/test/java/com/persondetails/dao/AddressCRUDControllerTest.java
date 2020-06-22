package com.persondetails.dao;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
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
import com.persondetails.domain.Person;
import com.persondetails.repository.AddressRepository;
import com.persondetails.repository.PersonRepositiry;

import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;

public class AddressCRUDControllerTest {

	@Mock
	private AddressRepository addressRepository;

	@Mock
	private PersonRepositiry personRepository;

	@InjectMocks
	private AddressCRUDController addressCRUDController;

	@BeforeEach
	public void setUp() {
		initMocks(this);
	}

	@Test
	public void testAddAddress() {

		Address address = new Address();

		address.setId(1L);
		address.setStreet("lingampally");
		address.setCity("hyd");
		address.setState("telangana");
		address.setPostalcode(500019);

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

		given(addressRepository.save(address)).willReturn(address);
		when(personRepository.findById(1L)).thenReturn(Optional.of(person));

		Address addressNew = addressCRUDController.addAddress(1L, address);

		assertThat(addressNew.getId()).isEqualTo(2L);
		assertThat(addressNew.getStreet()).isEqualTo("sitafalmandi");
		assertThat(addressNew.getCity()).isEqualTo("hyd");
		assertThat(addressNew.getState()).isEqualTo("telangana");
		assertThat(addressNew.getPostalcode()).isEqualTo(500009);
		assertThat(addressNew.getPerson()).isEqualTo(person);

		EqualsVerifier.forClass(AddressCRUDController.class).withRedefinedSuperclass()
				.suppress(Warning.STRICT_INHERITANCE).suppress(Warning.NONFINAL_FIELDS).verify();
	}

	@Test
	public void testUpdateAddress() {

		Address address = new Address();

		address.setId(3L);
		address.setStreet("madhapur");
		address.setCity("hyd");
		address.setState("telangana");
		address.setPostalcode(500051);

		given(addressRepository.save(address)).willReturn(address);
		when(addressRepository.findById(2L)).thenReturn(Optional.of(address));

		Address addressNew = addressCRUDController.updateAddress(1L, 2L, address);

		assertThat(addressNew.getId()).isEqualTo(3L);
		assertThat(addressNew.getStreet()).isEqualTo("madhapur");
		assertThat(addressNew.getCity()).isEqualTo("hyd");
		assertThat(addressNew.getState()).isEqualTo("telangana");
		assertThat(addressNew.getPostalcode()).isEqualTo(500051);

		
	}
}
