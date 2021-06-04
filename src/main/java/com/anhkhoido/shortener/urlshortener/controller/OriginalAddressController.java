package com.anhkhoido.shortener.urlshortener.controller;

import com.anhkhoido.shortener.urlshortener.businessRule.ShortUrlMaker;
import com.anhkhoido.shortener.urlshortener.dao.OriginalAddress.OriginalAddressRepository;
import com.anhkhoido.shortener.urlshortener.dao.ShortUrl.ShortUrlRepository;
import com.anhkhoido.shortener.urlshortener.model.OriginalAddress;
import com.anhkhoido.shortener.urlshortener.model.ShortUrl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/urlshortener/originalAddresses")
public class OriginalAddressController extends AbstractController {

    private OriginalAddressRepository originalAddressRepository;
    private ShortUrlRepository shortUrlRepository;

    @Autowired
    public OriginalAddressController(OriginalAddressRepository originalAddressRepository, ShortUrlRepository shortUrlRepository) {
        this.originalAddressRepository = originalAddressRepository;
        this.shortUrlRepository = shortUrlRepository;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody OriginalAddress originalAddress) {
        originalAddressRepository.save(originalAddress);
        List<OriginalAddress> originalAddresses = (List<OriginalAddress>) originalAddressRepository.findAll();
        OriginalAddress mostRecent = originalAddresses.get(originalAddresses.size() - 1);
        ShortUrl shortUrl = generateShortUrl(mostRecent);
        shortUrlRepository.save(shortUrl);
    }

    @Override
    public OriginalAddress findById(Integer id) {
        return originalAddressRepository.findById(id).orElse(null);
    }

    @Override
    public Iterable<OriginalAddress> findAll() {
        return originalAddressRepository.findAll();
    }

    @Override
    public void deleteById(Integer id) {
        shortUrlRepository.deleteByOriginalAddress_Id(id);
        originalAddressRepository.deleteById(id);
    }

    @Override
    public void deleteAll() {
        shortUrlRepository.deleteAll();
        originalAddressRepository.deleteAll();
    }

    private ShortUrl generateShortUrl(OriginalAddress originalAddress) {
        String alteredUrl = ShortUrlMaker.generateTruncatedUrl(originalAddress.getAddress());
        return ShortUrl.builder()
                .truncatedUrl(alteredUrl)
                .originalAddress(originalAddress)
                .build();
    }

}
