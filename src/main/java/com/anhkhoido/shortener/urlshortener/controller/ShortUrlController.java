package com.anhkhoido.shortener.urlshortener.controller;

import com.anhkhoido.shortener.urlshortener.businessRule.ShortUrlMaker;
import com.anhkhoido.shortener.urlshortener.dao.ShortUrl.ShortUrlRepository;
import com.anhkhoido.shortener.urlshortener.model.ShortUrl;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/urlshortener/shortUrls")
public class ShortUrlController extends AbstractController {

    private ShortUrlRepository shortUrlRepository;

    public ShortUrlController(ShortUrlRepository shortUrlRepository) {
        this.shortUrlRepository = shortUrlRepository;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody ShortUrl shortUrl) {
        String truncatedUrl = ShortUrlMaker.generateTruncatedUrl(shortUrl.getTruncatedUrl());
        shortUrl.setTruncatedUrl(truncatedUrl);
        shortUrlRepository.save(shortUrl);
    }

    @Override
    public ShortUrl findById(Integer id) {
        return shortUrlRepository.findById(id).orElse(null);
    }

    @Override
    public Iterable<ShortUrl> findAll() {
        return shortUrlRepository.findAll();
    }

    @Override
    public void deleteById(Integer id) {
        shortUrlRepository.deleteById(id);
    }

    @Override
    public void deleteAll() {
        shortUrlRepository.deleteAll();
    }
}
