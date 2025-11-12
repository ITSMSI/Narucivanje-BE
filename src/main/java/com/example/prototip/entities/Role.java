// src/main/java/com/example/prototip/entities/Role.java
package com.example.prototip.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Entity
@Table(name = "role")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Role {

    @Id
    @GeneratedValue
    @UuidGenerator(style = UuidGenerator.Style.TIME)
    @Column(name = "id")
    private UUID id;

    @Column(name = "naziv")
    private String naziv;

    @Column(name = "admin")
    private Boolean admin;

    @Column(name = "enduser")
    private Boolean endUser;

    @Column(name = "meni")
    private Boolean meni;

    @Column(name = "obrok")
    private Boolean obrok;

    @Column(name = "pregled")
    private Boolean pregled;

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
    @JoinColumn(name = "last_mod_by_role")
    @JsonIgnore
    private User lastModBy;
}