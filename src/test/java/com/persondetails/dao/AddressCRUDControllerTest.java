package com.persondetails.dao;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.doReturn;
import static org.mockito.MockitoAnnotations.initMocks;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.persondetails.domain.Address;
import com.persondetails.domain.Person;
import com.persondetails.repository.AddressRepository;
import com.persondetails.repository.PersonRepositiry;

public class AddressCRUDControllerTest {

	@Mock
	private AddressRepository addressRepository;

	@Mock
	private PersonRepositiry personRepository;
	
	@InjectMocks
	private AddressCRUDController addressCRUDController;
	
	@Test
	public void testAddAddress() {
		initMocks(this);
		
		Address address=new Address();
		
		address.setId(1L);
		address.setStreet("lingampally");
		address.setCity("hyd");
		address.setState("telangana");
		address.setPostalcode(500019);
		
		Person person=new Person();
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
		
		address.setPerson(person);
		
		given(addressRepository.save(address)).willReturn(address);
		Address addressNew=addressCRUDController.addAddress(2L, address);
		assertThat(addressNew.getId()).isEqualTo(1L);
		assertThat(addressNew.getStreet()).isEqualTo("lingampally");
		assertThat(addressNew.getCity()).isEqualTo("hyd");
		assertThat(addressNew.getState()).isEqualTo("telangana");
		assertThat(addressNew.getPostalcode()).isEqualTo(500019);
		assertThat(addressNew.getPerson()).isEqualTo(person);
	}
	@Test
	public void testUpdateAddress() {
		initMocks(this);
        Address address=new Address();
		
		address.setId(3L);
		address.setStreet("madhapur");
		address.setCity("hyd");
		address.setState("telangana");
		address.setPostalcode(500051);
		
		given(addressRepository.save(address)).willReturn(address);
		Address addressNew=addressCRUDController.updateAddress(1L, 2L, address);
		
		assertThat(addressNew.getId()).isEqualTo(3L);
		assertThat(addressNew.getStreet()).isEqualTo("madhapur");
		assertThat(addressNew.getCity()).isEqualTo("hyd");
		assertThat(addressNew.getState()).isEqualTo("telangana");
		assertThat(addressNew.getPostalcode()).isEqualTo(500051);
	}
}
