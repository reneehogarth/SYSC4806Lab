package com.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Lab3Application {

    private static final Logger log = LoggerFactory.getLogger(Lab3Application.class);

    public static void main(String[] args) {
        SpringApplication.run(Lab3Application.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(AddressBookRepository abRepo, BuddyInfoRepository budRepo) {
        return args -> {
            AddressBook addressBook = new AddressBook();

            BuddyInfo kate = new BuddyInfo();
            kate.setName("Kate");
            kate.setPhoneNumber("0123456789");

            BuddyInfo milena = new BuddyInfo();
            milena.setName("Milena");
            milena.setPhoneNumber("9876543210");

            BuddyInfo emily =  new BuddyInfo();
            emily.setName("Emily");
            milena.setPhoneNumber("1122334567");

            addressBook.addBuddy(kate);
            addressBook.addBuddy(milena);
            addressBook.addBuddy(emily);

            abRepo.save(addressBook);

            log.info("AddressBook has been saved: " + addressBook);

            log.info("AddressBooks in DB:");
            abRepo.findAll().forEach(book -> log.info(book.toString()));

            log.info("Buddies in DB:");
            budRepo.findAll().forEach(buddy -> log.info(buddy.toString()));

            AddressBook book1 = abRepo.findById(1L).orElseThrow();
            log.info("Address book with ID 1: " + book1);

            budRepo.findByName("Milena").forEach(b -> log.info("Found by name Milena: " + b));
        };
    }

}
