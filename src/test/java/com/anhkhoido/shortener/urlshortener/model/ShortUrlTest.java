package com.anhkhoido.shortener.urlshortener.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ShortUrlTest {

    private final String SEARCH_ENGINE = "https://duckduckgo.com";

    @Test
    @DisplayName("Test should pass if the build of ShortUrl is good")
    public void test_buildOfShortUrl() {
        OriginalAddress originalAddress = OriginalAddress.builder()
                .id(1)
                .address(SEARCH_ENGINE)
                .build();

        ShortUrl shortUrl = ShortUrl.builder()
                .id(1)
                .originalAddress(originalAddress)
                .truncatedUrl("https://a4c1ef32ij")
                .build();
        Assertions.assertNotNull(shortUrl);
    }

}
