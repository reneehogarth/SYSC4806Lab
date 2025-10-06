package com.example;

import org.springframework.data.repository.CrudRepository;

import com.example.AddressBook;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "addressbooks", path = "addressbooks")
public interface AddressBookRepository extends CrudRepository<AddressBook, Long> { }