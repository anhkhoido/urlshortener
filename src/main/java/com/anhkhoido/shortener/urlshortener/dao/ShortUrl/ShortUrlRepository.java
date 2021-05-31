package com.anhkhoido.shortener.urlshortener.dao.ShortUrl;

import com.anhkhoido.shortener.urlshortener.model.ShortUrl;
import org.springframework.data.repository.CrudRepository;

public interface ShortUrlRepository extends CrudRepository<ShortUrl, Integer> {
    void deleteByOriginalAddress_Id(Integer id);
}
