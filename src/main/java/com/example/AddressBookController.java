package com.example;

import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/addressbooks")
public class AddressBookController {

    private final AddressBookRepository abRepo;
    private final BuddyInfoRepository biRepo;

    public AddressBookController(AddressBookRepository abRepo, BuddyInfoRepository biRepo) {
        this.abRepo = abRepo;
        this.biRepo = biRepo;
    }

    @PostMapping
    public AddressBook createAddressBook() {
        AddressBook ab = new AddressBook();
        return abRepo.save(ab);
    }

    @GetMapping("/{id}")
    public AddressBook getAddressBook(@PathVariable Long id) {
        return abRepo.findById(id).orElseThrow();
    }

    @PostMapping("/{id}/buddies")
    public AddressBook addBudddy(@PathVariable Long id, @RequestBody BuddyInfo buddy) {
        AddressBook book = abRepo.findById(id).orElseThrow();
        book.addBuddy(buddy);
        biRepo.save(buddy);
        return abRepo.save(book);
    }

    @DeleteMapping("/{id}/buddies/{buddyId}")
    public AddressBook removeBuddy(@PathVariable Long id, @PathVariable Long buddyId) {
        AddressBook book = abRepo.findById(id).orElseThrow();
        BuddyInfo buddy = biRepo.findById(buddyId).orElseThrow();
        book.removeBuddy(buddy);
        biRepo.delete(buddy);
        return abRepo.save(book);
    }

}
