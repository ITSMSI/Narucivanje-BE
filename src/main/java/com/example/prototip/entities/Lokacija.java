// src/main/java/com/example/prototip/entities/Lokacija.java
package com.example.prototip.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Entity
@Table(name = "lokacija")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Lokacija {

    @Id
    @GeneratedValue
    @UuidGenerator(style = UuidGenerator.Style.TIME)
    @Column(name = "id")
    private UUID id;

    @Column(name = "adresa")
    private String adresa;

    @Column(name = "grad")
    private String grad;

    @Column(name = "postkod")
    private String postKod;

    @Column(name = "status")
    @Builder.Default
    private Boolean status = true;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "kompanija")
    @JsonIgnore
    private Kompanija kompanija;

    @Column(name = "lastmoddt")
    private java.time.LocalDateTime lastModDt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "lastmodby")
    @JsonIgnore
    private User lastModBy;

    @Column(name = "last_mod_by_lokacija")
    private UUID lastModByLokacija;
}