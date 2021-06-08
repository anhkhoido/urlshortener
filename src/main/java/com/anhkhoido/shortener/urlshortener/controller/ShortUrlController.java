package com.anhkhoido.shortener.urlshortener.controller;

import com.anhkhoido.shortener.urlshortener.dao.ShortUrl.ShortUrlService;
import com.anhkhoido.shortener.urlshortener.model.ShortUrl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/urlshortener/shortUrls")
public class ShortUrlController extends AbstractController<ShortUrl> {

    private final ShortUrlService shortUrlService;

    @Autowired
    public ShortUrlController(ShortUrlService shortUrlService) {
        this.shortUrlService = shortUrlService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody ShortUrl shortUrl) {
        shortUrlService.save(shortUrl);
    }

    @Override
    public ShortUrl findById(Integer id) {
        return shortUrlService.findById(id).orElse(null);
    }

    @Override
    public Iterable<ShortUrl> findAll() {
        return shortUrlService.findAll();
    }

    @Override
    public void deleteById(Integer id) {
        shortUrlService.deleteById(id);
    }

    @Override
    public void deleteAll() {
        shortUrlService.deleteAll();
    }
}
