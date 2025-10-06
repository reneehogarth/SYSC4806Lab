package com.example.lab3;

import com.example.AddressBook;
import com.example.AddressBookRepository;
import com.example.BuddyInfo;
import com.example.BuddyInfoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

@SpringBootTest
class Lab3ApplicationTests {

    @Autowired
    private BuddyInfoRepository buddyInfoRepository;

    @Test
    void contextLoads() {
    }

    @Test
    void testSaveAndFindBuddy() {

        BuddyInfo kate = new BuddyInfo();
        kate.setName("Kate");
        kate.setPhoneNumber("0123456789");

        buddyInfoRepository.save(kate);

        Iterable<Object> results = buddyInfoRepository.findByName("Kate");
        
        assertThat(results).isNotEmpty();
    }

    @Autowired
    private AddressBookRepository addressBookRepository;

    @Test
    void testAddBuddyToAddressBook() {
        AddressBook book = new AddressBook();
        BuddyInfo milena = new BuddyInfo();
        milena.setName("Milena");
        milena.setPhoneNumber("9876543210");
        book.addBuddy(milena);

        AddressBook saved = addressBookRepository.save(book);

        assertThat(saved.getBuddies()).hasSize(1);
        assertThat(saved.getBuddies().get(0).getName()).isEqualTo("Milena");
        }
}
