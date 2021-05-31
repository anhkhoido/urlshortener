package com.anhkhoido.shortener.urlshortener.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "original_address")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OriginalAddress implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "address", unique = true)
    private String address;
}
