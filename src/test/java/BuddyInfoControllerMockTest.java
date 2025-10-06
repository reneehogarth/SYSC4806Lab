package com.example;

import com.example.BuddyInfo;
import com.example.BuddyInfoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.http.MediaType.APPLICATION_JSON;

@WebMvcTest(AddressBookController.class)
class BuddyInfoControllerMockTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BuddyInfoRepository buddyInfoRepository; // mock this instead of a service

    @Test
    void testGetBuddyById() throws Exception {
        BuddyInfo kate = new BuddyInfo();
        kate.setName("Kate");
        kate.setPhoneNumber("0123456789");
        when(buddyInfoRepository.findById(1L)).thenReturn(Optional.of(kate));

        mockMvc.perform(get("/buddies/1"))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(APPLICATION_JSON))
                .andExpect(jsonPath("$.name").value("Kate"))
                .andExpect(jsonPath("$.phoneNumber").value("0123456789"));
    }
}
