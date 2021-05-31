package com.anhkhoido.shortener.urlshortener.model;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class OriginalAddressTest {

    private final String SEARCH_ENGINE = "https://duckduckgo.com";

    @Test
    @DisplayName("Test should pass if the build of OriginalAddress is good")
    public void test_buildOriginalAddress() {
        OriginalAddress originalAddress = OriginalAddress.builder()
                .id(1)
                .address(SEARCH_ENGINE)
                .build();
        Assertions.assertNotNull(originalAddress);
        MatcherAssert.assertThat(originalAddress.getAddress(), Matchers.equalTo(SEARCH_ENGINE));
    }
}
