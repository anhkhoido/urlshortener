package com.anhkhoido.shortener.urlshortener.service;

import com.anhkhoido.shortener.urlshortener.dao.OriginalAddress.OriginalAddressRepository;
import com.anhkhoido.shortener.urlshortener.dao.OriginalAddress.OriginalAddressService;
import com.anhkhoido.shortener.urlshortener.model.OriginalAddress;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;

public class OriginalAddressServiceImplTest {
    private final String SEARCH_ENGINE = "https://duckduckgo.com";

    @InjectMocks
    private OriginalAddressService originalAddressService;

    @Mock
    private OriginalAddressRepository originalAddressRepository;

    @Test
    @DisplayName("Test should pass if there are no duplicate URLs")
    public void test_preventDuplicateUrls() {
        OriginalAddress originalAddress = getOriginalAddress(SEARCH_ENGINE);
        originalAddressService.save(originalAddress);
        originalAddressService.save(originalAddress);
        Assertions.assertTrue(originalAddressService.count() == 1);
    }

    @Test
    @DisplayName("Test should pass if service deletes all URLs")
    public void test_deleteOriginalUrl() {
        originalAddressService.deleteById(1);
        Mockito.verify(originalAddressRepository).deleteById(1);
    }

    private OriginalAddress getOriginalAddress(String address) {
        return OriginalAddress.builder()
                .address(address)
                .build();
    }
}
