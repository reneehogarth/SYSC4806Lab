package com.example;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class AddressBook {

    private Long id;
    private List<BuddyInfo> buddies;

    public AddressBook() {
        this.buddies = new ArrayList<>();
    }

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @OneToMany (mappedBy = "addressBook", cascade = CascadeType.ALL, orphanRemoval = true)
    public List<BuddyInfo> getBuddies() {
        return buddies;
    }

    public void setBuddies(List<BuddyInfo> buddies) {
        this.buddies = buddies;
    }

    public void addBuddy(BuddyInfo buddy) {
        buddies.add(buddy);
        buddy.setAddressBook(this);
    }

    public void removeBuddy(BuddyInfo buddy) {
        buddies.remove(buddy);
        buddy.setAddressBook(null);
    }
}