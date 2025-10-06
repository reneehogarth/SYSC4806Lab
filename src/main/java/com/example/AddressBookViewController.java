package com.example;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/view/addressbooks")
public class AddressBookViewController {

    private final AddressBookRepository abRepo;

    public AddressBookViewController(AddressBookRepository abRepo) {
        this.abRepo = abRepo;
    }

    @GetMapping("/{id}")
    public String showAddressBook(@PathVariable long id, Model model) {
        AddressBook book = abRepo.findById(id).orElseThrow();
        model.addAttribute("addressbook", book);
        return "addressbook";
    }
}
