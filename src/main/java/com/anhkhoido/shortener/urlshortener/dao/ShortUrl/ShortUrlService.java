package com.anhkhoido.shortener.urlshortener.dao.ShortUrl;

import com.anhkhoido.shortener.urlshortener.model.OriginalAddress;
import com.anhkhoido.shortener.urlshortener.model.ShortUrl;

import java.util.Optional;

public interface ShortUrlService {
    void create(ShortUrl shortUrl);
    ShortUrl save(ShortUrl shortUrl);
    Iterable<ShortUrl> saveAll(Iterable<ShortUrl> shortUrls);
    Optional<ShortUrl> findById(Integer id);
    Iterable<ShortUrl> findAll();
    Iterable<ShortUrl> findAllById(Iterable<Integer> ids);
    boolean existsById(Integer id);
    void deleteById(Integer id);
    void deleteAll();
    long count();
}
