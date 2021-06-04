package com.anhkhoido.shortener.urlshortener.dao.OriginalAddress;

import com.anhkhoido.shortener.urlshortener.model.OriginalAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OriginalAddressServiceImpl implements OriginalAddressService {

    private OriginalAddressRepository originalAddressRepository;

    @Autowired
    public OriginalAddressServiceImpl(OriginalAddressRepository originalAddressRepository) {
        this.originalAddressRepository = originalAddressRepository;
    }

    @Override
    public void create(OriginalAddress originalAddress) {
        originalAddressRepository.save(originalAddress);
    }

    @Override
    public OriginalAddress save(OriginalAddress originalAddress) {
        return originalAddressRepository.save(originalAddress);
    }

    @Override
    public Iterable<OriginalAddress> saveAll(Iterable<OriginalAddress> originalAddresses) {
        return originalAddressRepository.saveAll(originalAddresses);
    }

    @Override
    public Optional<OriginalAddress> findById(Integer id) {
        return originalAddressRepository.findById(id);
    }

    @Override
    public Iterable<OriginalAddress> findAll() {
        return originalAddressRepository.findAll();
    }

    @Override
    public Iterable<OriginalAddress> findAllById(Iterable<Integer> ids) {
        return originalAddressRepository.findAllById(ids);
    }

    @Override
    public boolean existsById(Integer id) {
        return originalAddressRepository.existsById(id);
    }

    @Override
    public void deleteById(Integer id) {
        originalAddressRepository.deleteById(id);
    }

    @Override
    public void deleteAll() {
        originalAddressRepository.deleteAll();
    }

    @Override
    public long count() {
        return originalAddressRepository.count();
    }
}
