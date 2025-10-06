package com.example;

import jakarta.persistence.*;

@Entity
public class BuddyInfo {

    private Long id;
    private String name;
    private String phoneNumber;
    private AddressBook addressBook;

    public BuddyInfo() {}

    @ManyToOne
    public AddressBook getAddressBook() {
        return addressBook;
    }

    public void setAddressBook(AddressBook addressBook) {
        this.addressBook = addressBook;
    }

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "BuddyInfo{" + "name=" + name + ", phoneNumber=" + phoneNumber + '}';
    }
}
