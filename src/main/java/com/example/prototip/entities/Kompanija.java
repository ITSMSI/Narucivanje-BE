// src/main/java/com/example/prototip/entities/Kompanija.java
package com.example.prototip.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "kompanija")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Kompanija {

    @Id
    @GeneratedValue
    @UuidGenerator(style = UuidGenerator.Style.TIME)
    @Column(name = "id")
    private UUID id;

    @Column(name = "naziv", nullable = false)
    private String naziv;

    @Column(name = "adresa")
    private String adresa;

    @Column(name = "pib")
    private String pib;

    @Column(name = "mbr")
    private String mbr;

    @Column(name = "status")
    @Builder.Default
    private Boolean status = true;

    @Column(name = "createddt")
    private LocalDateTime createdDt;

    @Column(name = "createdon")
    private String createdOn;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "createdby")
    @JsonIgnore
    private User createdBy;

    @Column(name = "lastmoddt")
    private LocalDateTime lastModDt;

    @Column(name = "lastmodon")
    private String lastModOn;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "lastmodby")
    @JsonIgnore
    private User lastModBy;

    @Column(name = "last_mod_by_kompanija")
    private UUID lastModByKompanija;
}