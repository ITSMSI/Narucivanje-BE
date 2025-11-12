// src/main/java/com/example/prototip/entities/User.java
package com.example.prototip.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

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

    @Column(name = "email", unique = true, nullable = false)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "ime")
    private String ime;

    @Column(name = "prezime")
    private String prezime;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "telefon")
    private String telefon;

    @Column(name = "status")
    @Builder.Default
    private Boolean status = true;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "kompanija")
    @JsonIgnore
    private Kompanija kompanija;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "lokacija_id")
    @JsonIgnore
    private Lokacija lokacija;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "role")
    @JsonIgnore
    private Role role;

    @Column(name = "lastmoddt")
    private java.time.LocalDateTime lastModDt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "lastmodby")
    @JsonIgnore
    private User lastModBy;

    @Column(name = "last_mod_by_user")
    private UUID lastModByUser;
}