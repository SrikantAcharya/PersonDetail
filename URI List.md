# PersonDetail

// Add Person (id, firstName, lastName)
http://localhost:8080/add

// Edit Person (firstName, lastName)
http://localhost:8080/person/{id}

// Delete Person (id)
http://localhost:8080/person/{id}

// Count Number of Persons
http://localhost:8080/person-count

// List Persons
http://localhost:8080/person-list/{id}

// Add Addresses to person [multiple required]
http://localhost:8080/addAddressToPerson/{personId}/addresses

// Edit Address (street, city, state, potalCode)
http://localhost:8080/person/{personId}/address/{addressId}

// Delete Address (id)
http://localhost:8080/address/{id}
