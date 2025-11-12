package com.example.prototip.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDateTime;
import java.util.Set;
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
    @NotBlank
    private String naziv;

    @Column(name = "adresa", nullable = false)
    @NotBlank
    private String adresa;

    @Column(name = "pib")
    private String pib;

    @Column(name = "mbr")
    private String mbr;

    @Column(name = "status", nullable = false)
    @NotNull
    @Builder.Default
    private Boolean status = true;

    @Column(name = "lastmoddt")
    @Builder.Default
    private LocalDateTime lastmoddt = LocalDateTime.now();

    @Column(name = "createdby")
    private UUID createdby;

    @Column(name = "createddt")
    private LocalDateTime createddt;

    @Column(name = "createdon")
    private LocalDateTime createdon;

    @Column(name = "lastmodon")
    private LocalDateTime lastmodon;

    @OneToMany(mappedBy = "kompanija")
    private Set<User> users;

    @OneToMany(mappedBy = "kompanija")
    private Set<Lokacija> lokacija;

    @OneToOne
    @JoinColumn(name = "lastmodby", referencedColumnName = "id")
    private User lastModBy;

    @Column(name = "last_mod_by_kompanija")
    private UUID lastModByKompanija;
}