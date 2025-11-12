package com.example.prototip.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;  // ← ADD THIS
import lombok.*;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;


@Entity
@Table(name = "users")
@Data @Builder @NoArgsConstructor @AllArgsConstructor
public class User {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.UUID)  // or use @UuidGenerator
    private UUID id;

    @Column(name = "ime", nullable = false)
    @NotBlank
    private String ime;

    @Column(name = "prezime", nullable = false)
    @NotBlank
    private String prezime;

    @Column(name = "email", nullable = false, unique = true)
    @NotBlank @Email
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "telefon")
    private String telefon;

    @Column(name = "status")
    @NotNull
    @Builder.Default
    private Boolean status = true;

    @Column(name = "lastmoddt")
    @Builder.Default
    private LocalDateTime lastModDt = LocalDateTime.now();

    @ManyToOne
    @JoinColumn(name = "kompanija", nullable = false)
    private Kompanija kompanija;

    @ManyToOne
    @JoinColumn(name = "lokacija", nullable = false)
    private Lokacija lokacija;

    @ManyToOne
    @JoinColumn(name = "role", nullable = false)
    private Role role;

    @OneToMany(mappedBy = "user")
    private Set<Porudzbina> porudzbina;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "lastmodby", referencedColumnName = "id")
    private User lastModBy;
}