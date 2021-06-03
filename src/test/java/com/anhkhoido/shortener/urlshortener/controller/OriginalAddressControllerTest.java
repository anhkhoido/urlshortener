package com.anhkhoido.shortener.urlshortener.controller;

import com.anhkhoido.shortener.urlshortener.dao.OriginalAddress.OriginalAddressServiceImpl;
import com.anhkhoido.shortener.urlshortener.dao.ShortUrl.ShortUrlServiceImpl;
import com.anhkhoido.shortener.urlshortener.model.OriginalAddress;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(OriginalAddressController.class)
public class OriginalAddressControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private OriginalAddressServiceImpl originalAddressService;

    @MockBean
    private ShortUrlServiceImpl shortUrlService;

    private final String SEARCH_ENGINE = "https://duckduckgo.com";

    @Test
    @DisplayName("Test should pass if the controller can list all original addresses")
    public void test_findAllOriginalAddresses() throws Exception {
        OriginalAddress originalAddress = getOriginalAddress(1, SEARCH_ENGINE);
        OriginalAddress originalAddress002 = getOriginalAddress(2, "https://time.is");
        List<OriginalAddress> listOriginalAddresses = Arrays.asList(originalAddress, originalAddress002);
        Mockito.when(originalAddressService.findAll()).thenReturn(listOriginalAddresses);
        mockMvc.perform(get("/api/urlshortener/originalAddresses/findAll"))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("Test should pass if the controller can find an original address by ID")
    public void test_findOriginalAddressById() throws Exception {
        OriginalAddress originalAddress = getOriginalAddress(1, SEARCH_ENGINE);
        int anyInt = Mockito.anyInt();
        Mockito.when(originalAddressService.findById(anyInt)).thenReturn(java.util.Optional.ofNullable(originalAddress));
        mockMvc.perform(get("/api/urlshortener/originalAddresses/" + anyInt)).andExpect(status().isOk());
    }

    private OriginalAddress getOriginalAddress(Integer id, String address) {
        return OriginalAddress.builder()
                .id(id)
                .address(address)
                .build();
    }

}
