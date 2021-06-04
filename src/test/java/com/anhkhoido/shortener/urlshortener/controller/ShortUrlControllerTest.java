package com.anhkhoido.shortener.urlshortener.controller;

import com.anhkhoido.shortener.urlshortener.dao.ShortUrl.ShortUrlServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Optional;

@WebMvcTest(ShortUrlController.class)
public class ShortUrlControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ShortUrlServiceImpl shortUrlService;

    @Test
    @DisplayName("Test should pass if controller finds short url by ID.")
    public void test_findShortUrlById() throws Exception {
        int anyInt = Mockito.anyInt();
        Mockito.when(shortUrlService.findById(anyInt)).thenReturn(Mockito.any(Optional.class));
        mockMvc.perform(MockMvcRequestBuilders.get("/api/urlshortener/shortUrls/" + anyInt))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

}
