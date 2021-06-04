package com.anhkhoido.shortener.urlshortener.dao.ShortUrl;

import com.anhkhoido.shortener.urlshortener.model.ShortUrl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ShortUrlServiceImpl implements ShortUrlService {

    private ShortUrlRepository shortUrlRepository;

    @Autowired
    public ShortUrlServiceImpl(ShortUrlRepository shortUrlRepository) {
        this.shortUrlRepository = shortUrlRepository;
    }


    @Override
    public void create(ShortUrl shortUrl) {
        shortUrlRepository.save(shortUrl);
    }

    @Override
    public ShortUrl save(ShortUrl shortUrl) {
        return shortUrlRepository.save(shortUrl);
    }

    @Override
    public Iterable<ShortUrl> saveAll(Iterable<ShortUrl> shortUrls) {
        return shortUrlRepository.saveAll(shortUrls);
    }

    @Override
    public Optional<ShortUrl> findById(Integer id) {
        return shortUrlRepository.findById(id);
    }

    @Override
    public Iterable<ShortUrl> findAll() {
        return shortUrlRepository.findAll();
    }

    @Override
    public Iterable<ShortUrl> findAllById(Iterable<Integer> ids) {
        return shortUrlRepository.findAllById(ids);
    }

    @Override
    public boolean existsById(Integer id) {
        return shortUrlRepository.existsById(id);
    }

    @Override
    public void deleteById(Integer id) {
        shortUrlRepository.deleteById(id);
    }

    @Override
    public void deleteAll() {
        shortUrlRepository.deleteAll();
    }

    @Override
    public long count() {
        return shortUrlRepository.count();
    }
}
