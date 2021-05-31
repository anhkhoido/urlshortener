package com.anhkhoido.shortener.urlshortener.controller;

import com.anhkhoido.shortener.urlshortener.dao.ShortUrl.ShortUrlRepository;
import com.anhkhoido.shortener.urlshortener.model.ShortUrl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/urlshortener/shortUrls")
public class ShortUrlController extends AbstractController {

    private ShortUrlRepository shortUrlRepository;

    public ShortUrlController(ShortUrlRepository shortUrlRepository) {
        this.shortUrlRepository = shortUrlRepository;
    }

    @Override
    public ShortUrl findById(Integer id) {
        return shortUrlRepository.findById(id).get();
    }

    @Override
    public Iterable findAll() {
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
