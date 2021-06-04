package com.anhkhoido.shortener.urlshortener.service;

import com.anhkhoido.shortener.urlshortener.dao.OriginalAddress.OriginalAddressService;
import com.anhkhoido.shortener.urlshortener.model.OriginalAddress;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;

@SpringBootTest
@Transactional
public class OriginalAddressServiceImplTest {
    private final String SEARCH_ENGINE = "https://duckduckgo.com";

    @Autowired
    private OriginalAddressService originalAddressService;

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
    public void test_deleteAllOriginalUrls() {
        OriginalAddress originalAddress = getOriginalAddress(SEARCH_ENGINE);
        OriginalAddress originalAddress002 = getOriginalAddress("https://time.is");
        originalAddressService.saveAll(Arrays.asList(originalAddress, originalAddress002));
        Assertions.assertTrue(originalAddressService.count() == 2);
        originalAddressService.deleteAll();
        Assertions.assertTrue(originalAddressService.count() == 0);
    }

    private OriginalAddress getOriginalAddress(String address) {
        return OriginalAddress.builder()
                .address(address)
                .build();
    }
}
