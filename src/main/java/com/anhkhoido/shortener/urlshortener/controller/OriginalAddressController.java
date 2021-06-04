package com.anhkhoido.shortener.urlshortener.controller;

import com.anhkhoido.shortener.urlshortener.businessRule.ShortUrlMaker;
import com.anhkhoido.shortener.urlshortener.dao.OriginalAddress.OriginalAddressService;
import com.anhkhoido.shortener.urlshortener.dao.ShortUrl.ShortUrlService;
import com.anhkhoido.shortener.urlshortener.model.OriginalAddress;
import com.anhkhoido.shortener.urlshortener.model.ShortUrl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/urlshortener/originalAddresses")
public class OriginalAddressController extends AbstractController {

    @Autowired
    private OriginalAddressService originalAddressService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody OriginalAddress originalAddress) {
        originalAddressService.create(originalAddress);
    }

    @Override
    public OriginalAddress findById(Integer id) {
        return originalAddressService.findById(id).orElse(null);
    }

    @Override
    public Iterable<OriginalAddress> findAll() {
        return originalAddressService.findAll();
    }

    @Override
    public void deleteById(Integer id) {
        originalAddressService.deleteById(id);
    }

    @Override
    public void deleteAll() {
        originalAddressService.deleteAll();
    }

}
