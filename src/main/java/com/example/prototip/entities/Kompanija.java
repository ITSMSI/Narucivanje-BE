package com.example.prototip.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;   // ← ADD THIS
import lombok.*;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;


@Entity
@Table(name = "kompanija")
@Data @Builder @NoArgsConstructor @AllArgsConstructor
public class Kompanija {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "naziv", nullable = false)
    @NotBlank
    private String naziv;

    @Column(name = "adresa", nullable = false)
    @NotBlank
    private String adresa;

    @Column(name = "pib")
    private String pib;

    @Column(name = "mbr")
    private String mbr;

    @Column(name = "status")
    @NotNull
    @Builder.Default
    private Boolean status = true;

    @Column(name = "lastmoddt")
    @Builder.Default
    private LocalDateTime lastModDt = LocalDateTime.now();

    @OneToMany(mappedBy = "kompanija")
    private Set<User> users;

    @OneToMany(mappedBy = "kompanija")
    private Set<Lokacija> lokacija;

    @OneToOne
    @JoinColumn(name = "lastmodby", referencedColumnName = "id")
    private User lastModBy;
}