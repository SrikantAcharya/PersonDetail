package com.persondetails.dao;

import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.persondetails.domain.Address;
import com.persondetails.domain.Person;
import com.persondetails.exception.ResourceNotFoundException;
import com.persondetails.repository.AddressRepository;
import com.persondetails.repository.PersonRepositiry;

import lombok.Data;
import lombok.ToString;

@RestController
@Data
@ToString
public class AddressCRUDController {
	@Autowired
	private AddressRepository addressRepository;

	@Autowired
	private PersonRepositiry personRepository;

	// Add Addresses to person [multiple required]
	@PostMapping("/addAddressToPerson/{personId}/addresses")
	@ResponseBody
	public Address addAddress(@PathVariable(value = "personId") Long personId, @RequestBody Address address) {

		return personRepository.findById(personId).map(person -> {
			address.setPerson(person);
			return addressRepository.save(address);
		}).orElseThrow(() -> new ResourceNotFoundException("Person not found"));

	}

	// Edit Address (street, city, state, potalCode)
	@PutMapping("person/{personId}/address/{addressId}")
	@ResponseBody
	public Address updateAddress(@PathVariable(value = "personId") Long personId,
			@PathVariable(value = "addressId") Long addressId, @RequestBody Address newAddress) {

		return addressRepository.findById(addressId).map(address -> {
			address.setStreet(newAddress.getStreet());
			address.setCity(newAddress.getCity());
			address.setState(newAddress.getState());
			address.setPostalcode(newAddress.getPostalcode());
			return addressRepository.save(address);
		}).orElseThrow(() -> new ResourceNotFoundException("address id not found"));
	}

	// Delete Address (id)
	@DeleteMapping("/address/{id}")
	public String deleteAddress(@PathVariable Long id) {
		addressRepository.deleteById(id);
		return "Address deleted with id--"+id;
	}

}
