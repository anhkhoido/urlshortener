package com.anhkhoido.shortener.urlshortener.controller;

import com.anhkhoido.shortener.urlshortener.dao.OriginalAddress.OriginalAddressService;
import com.anhkhoido.shortener.urlshortener.dao.OriginalAddress.OriginalAddressServiceImpl;
import com.anhkhoido.shortener.urlshortener.model.OriginalAddress;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(OriginalAddressController.class)
public class OriginalAddressControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private OriginalAddressService originalAddressService;

    @Autowired
    private OriginalAddressServiceImpl originalAddressServiceImpl;

    @Test
    @DisplayName("Test should pass if the controller can a list")
    public void test_findAllOriginalAddresses() throws Exception {
        List<OriginalAddress> originalAddresses = new ArrayList<>();
        Mockito.when(originalAddressService.findAll()).thenReturn(originalAddresses);
        mockMvc.perform(get("/api/urlshortener/originalAddresses/findAll"))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("Test should pass if the controller can find an original address by ID")
    public void test_findOriginalAddressById() throws Exception {
        int anyInt = Mockito.anyInt();
        Mockito.when(originalAddressService.findById(anyInt)).thenReturn(Mockito.any(Optional.class));
        mockMvc.perform(get("/api/urlshortener/originalAddresses/" + anyInt)).andExpect(status().isOk());
    }

}
