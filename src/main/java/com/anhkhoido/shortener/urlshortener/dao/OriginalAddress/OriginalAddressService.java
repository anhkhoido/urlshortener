package com.anhkhoido.shortener.urlshortener.dao.OriginalAddress;

import com.anhkhoido.shortener.urlshortener.model.OriginalAddress;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface OriginalAddressService {
    void create(OriginalAddress originalAddress);
    OriginalAddress save(OriginalAddress originalAddress);
    Iterable<OriginalAddress> saveAll(Iterable<OriginalAddress> originalAddresses);
    Optional<OriginalAddress> findById(Integer id);
    Iterable<OriginalAddress> findAll();
    Iterable<OriginalAddress> findAllById(Iterable<Integer> ids);
    boolean existsById(Integer id);
    void deleteById(Integer id);
    void deleteAll();
    long count();
}
