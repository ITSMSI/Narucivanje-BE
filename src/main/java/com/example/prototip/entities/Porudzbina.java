package com.example.prototip.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "porudzbina")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Porudzbina {

    @Id
    @GeneratedValue
    @UuidGenerator(style = UuidGenerator.Style.TIME)
    @Column(name = "id")
    private UUID id;

    @Column(name = "datum", nullable = false)
    @NotNull
    private LocalDate datum;

    @Column(name = "komentar", nullable = false)
    @NotBlank
    private String komentar;

    @Column(name = "kolicina")
    private Integer kolicina;

    @Column(name = "napomena", columnDefinition = "TEXT")
    private String napomena;

    @Column(name = "status")
    @NotNull
    @Builder.Default
    private Boolean status = true;

    @Column(name = "lastmoddt")
    @Builder.Default
    private LocalDateTime lastmoddt = LocalDateTime.now();

    @Column(name = "created_dt", nullable = false, updatable = false)
    @Builder.Default
    private LocalDateTime createdDt = LocalDateTime.now();

    @ManyToOne
    @JoinColumn(name = "obrok", nullable = false)
    private Obrok obrok;

    @ManyToOne
    @JoinColumn(name = "korisnik", nullable = false)
    private User korisnik;

    @ManyToOne
    @JoinColumn(name = "lokacija_id")
    private Lokacija lokacijaId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "meni")
    private Meni meni;

    @OneToOne
    @JoinColumn(name = "lastmodby", referencedColumnName = "id")
    private User lastModBy;

    @Column(name = "last_mod_by_porudzbina")
    private UUID lastModByPorudzbina;
}