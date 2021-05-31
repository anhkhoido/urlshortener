package com.anhkhoido.shortener.urlshortener.dao.OriginalAddress;

import com.anhkhoido.shortener.urlshortener.model.OriginalAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OriginalAddressServiceImpl implements OriginalAddressRepository {

    private OriginalAddressRepository originalAddressRepository;

    @Autowired
    public OriginalAddressServiceImpl(OriginalAddressRepository originalAddressRepository) {
        this.originalAddressRepository = originalAddressRepository;
    }

    @Override
    public OriginalAddress save(OriginalAddress originalAddress) {
        return originalAddressRepository.save(originalAddress);
    }

    @Override
    public <S extends OriginalAddress> Iterable<S> saveAll(Iterable<S> iterable) {
        return originalAddressRepository.saveAll(iterable);
    }

    @Override
    public Optional<OriginalAddress> findById(Integer integer) {
        return originalAddressRepository.findById(integer);
    }

    @Override
    public boolean existsById(Integer integer) {
        return originalAddressRepository.existsById(integer);
    }

    @Override
    public Iterable<OriginalAddress> findAll() {
        return originalAddressRepository.findAll();
    }

    @Override
    public Iterable<OriginalAddress> findAllById(Iterable<Integer> iterable) {
        return originalAddressRepository.findAllById(iterable);
    }

    @Override
    public long count() {
        return originalAddressRepository.count();
    }

    @Override
    public void deleteById(Integer integer) {
        originalAddressRepository.deleteById(integer);
    }

    @Override
    public void delete(OriginalAddress originalAddress) {
        originalAddressRepository.delete(originalAddress);
    }

    @Override
    public void deleteAll(Iterable<? extends OriginalAddress> iterable) {
        originalAddressRepository.deleteAll(iterable);
    }

    @Override
    public void deleteAll() {
        originalAddressRepository.deleteAll();
    }
}
