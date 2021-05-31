package com.anhkhoido.shortener.urlshortener.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "short_url")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ShortUrl {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "truncatedUrl", unique = true)
    private String truncatedUrl;

    @OneToOne
    @JoinColumn(name = "fk_original_adress", referencedColumnName = "id")
    private OriginalAddress originalAddress;

}
