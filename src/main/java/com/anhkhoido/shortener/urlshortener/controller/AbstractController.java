package com.anhkhoido.shortener.urlshortener.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public abstract class AbstractController<T> {

    @GetMapping(path = "/{id}")
    public abstract T findById(@PathVariable(value = "id") Integer id);
    
    @GetMapping(path = "/findAll")
    public abstract Iterable<T> findAll();

    @DeleteMapping(path = "/{id}")
    public abstract void deleteById(@PathVariable(value = "id") Integer id);

    @DeleteMapping(path = "/deleteAll")
    public abstract void deleteAll();
}
