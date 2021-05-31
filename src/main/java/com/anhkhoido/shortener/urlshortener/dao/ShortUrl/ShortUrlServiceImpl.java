package com.anhkhoido.shortener.urlshortener.dao.ShortUrl;

import com.anhkhoido.shortener.urlshortener.model.ShortUrl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ShortUrlServiceImpl implements ShortUrlRepository {

    private ShortUrlRepository shortUrlRepository;

    @Autowired
    public ShortUrlServiceImpl(ShortUrlRepository shortUrlRepository) {
        this.shortUrlRepository = shortUrlRepository;
    }

    @Override
    public ShortUrl save(ShortUrl shortUrl) {
        return shortUrlRepository.save(shortUrl);
    }

    @Override
    public <S extends ShortUrl> Iterable<S> saveAll(Iterable<S> iterable) {
        return shortUrlRepository.saveAll(iterable);
    }

    @Override
    public Optional<ShortUrl> findById(Integer integer) {
        return shortUrlRepository.findById(integer);
    }

    @Override
    public boolean existsById(Integer integer) {
        return shortUrlRepository.existsById(integer);
    }

    @Override
    public Iterable<ShortUrl> findAll() {
        return shortUrlRepository.findAll();
    }

    @Override
    public Iterable<ShortUrl> findAllById(Iterable<Integer> iterable) {
        return shortUrlRepository.findAllById(iterable);
    }

    @Override
    public long count() {
        return shortUrlRepository.count();
    }

    @Override
    public void deleteById(Integer integer) {
        shortUrlRepository.deleteById(integer);
    }

    @Override
    public void delete(ShortUrl shortUrl) {
        shortUrlRepository.delete(shortUrl);
    }

    @Override
    public void deleteAll(Iterable<? extends ShortUrl> iterable) {
        shortUrlRepository.deleteAll(iterable);
    }

    @Override
    public void deleteAll() {
        shortUrlRepository.deleteAll();
    }

    @Override
    public void deleteByOriginalAddress_Id(@Param("id") Integer id) {
        shortUrlRepository.deleteByOriginalAddress_Id(id);
    }
}
