package com.example.prototip.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "users")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue
    @UuidGenerator(style = UuidGenerator.Style.TIME)
    @Column(name = "id")
    private UUID id;

    @Column(name = "ime", nullable = false)
    @NotBlank
    private String ime;

    @Column(name = "prezime", nullable = false)
    @NotBlank
    private String prezime;

    @Column(name = "email", unique = true, nullable = false)
    @Email
    @NotBlank
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "telefon")
    private String telefon;

    @Column(name = "status", nullable = false)
    @NotNull
    @Builder.Default
    private Boolean status = true;

    @Column(name = "lastmoddt")
    @Builder.Default
    private LocalDateTime lastmoddt = LocalDateTime.now();

    @Column(name = "first_name", nullable = false)
    @NotBlank
    @Builder.Default
    private String firstName = "";

    @Column(name = "last_name", nullable = false)
    @NotBlank
    @Builder.Default
    private String lastName = "";

    @ManyToOne
    @JoinColumn(name = "kompanija", nullable = false)
    private Kompanija kompanija;

    @ManyToOne
    @JoinColumn(name = "lokacija", nullable = false)
    private Lokacija lokacija;

    @ManyToOne
    @JoinColumn(name = "role", nullable = false)
    private Role role;

    @OneToMany(mappedBy = "korisnik")
    private Set<Porudzbina> porudzbina;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "lastmodby", referencedColumnName = "id")
    private User lastModBy;

    @Column(name = "last_mod_by_user")
    private UUID lastModByUser;

    @ManyToOne
    @JoinColumn(name = "lokacija_id")
    private Lokacija lokacijaId;
}