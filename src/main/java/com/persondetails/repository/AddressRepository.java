package com.persondetails.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.persondetails.domain.Address;

@Repository
public interface AddressRepository extends CrudRepository<Address, Long>{

}
