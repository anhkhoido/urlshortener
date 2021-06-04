package com.anhkhoido.shortener.urlshortener.service;

import com.anhkhoido.shortener.urlshortener.businessRule.ShortUrlMaker;
import com.anhkhoido.shortener.urlshortener.dao.OriginalAddress.OriginalAddressServiceImpl;
import com.anhkhoido.shortener.urlshortener.dao.ShortUrl.ShortUrlServiceImpl;
import com.anhkhoido.shortener.urlshortener.model.OriginalAddress;
import com.anhkhoido.shortener.urlshortener.model.ShortUrl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
public class ShortUrlServiceImplTest {

    private final String SEARCH_ENGINE = "https://duckduckgo.com";

    @Autowired
    private OriginalAddressServiceImpl originalAddressService;

    @Autowired
    private ShortUrlServiceImpl shortUrlService;

    @Test
    @DisplayName("Test should pass if original URL and its truncated version are different")
    public void test_shortUrlMaker() {
        OriginalAddress originalAddress = originalAddressService.save(getOriginalAddress(SEARCH_ENGINE));
        ShortUrl shortUrl = shortUrlService.save(getShortUrl(originalAddress));
        Assertions.assertNotSame(originalAddress.getAddress(), shortUrl.getTruncatedUrl());
    }

    @Test
    @DisplayName("Test should pass if short url only has ten characters after double slashes")
    public void test_lengthOfShortUrl() {
        OriginalAddress originalAddress = originalAddressService.save(getOriginalAddress(SEARCH_ENGINE));
        ShortUrl shortUrl = shortUrlService.save(getShortUrl(originalAddress));
        String truncatedUrl = shortUrl
                .getTruncatedUrl()
                .substring(shortUrl.getTruncatedUrl().indexOf("/") + 2, shortUrl.getTruncatedUrl().length());
        Assertions.assertTrue(truncatedUrl.length() == 10);

    }

    private OriginalAddress getOriginalAddress(String address) {
        return OriginalAddress.builder()
                .address(address)
                .build();
    }

    private ShortUrl getShortUrl(OriginalAddress originalAddress) {
        String truncatedUrl = ShortUrlMaker.generateTruncatedUrl(originalAddress.getAddress());
        return ShortUrl.builder()
                .originalAddress(originalAddress)
                .truncatedUrl(truncatedUrl)
                .build();
    }

}
