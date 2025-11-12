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

    @Column(name = "naziv", nullable = false)
    @NotBlank
    private String naziv;

    @Column(name = "admin", nullable = false)
    @NotNull
    @Builder.Default
    private Boolean admin = false;

    @Column(name = "enduser", nullable = false)
    @NotNull
    @Builder.Default
    private Boolean enduser = true;

    @Column(name = "meni", nullable = false)
    @NotNull
    @Builder.Default
    private Boolean meni = false;

    @Column(name = "pregled", nullable = false)
    @NotNull
    @Builder.Default
    private Boolean pregled = false;

    @Column(name = "kompanija")
    private Boolean kompanija;

    @Column(name = "obrok", nullable = false)
    @NotNull
    @Builder.Default
    private Boolean obrok = false;

    @Column(name = "status", nullable = false)
    @NotNull
    @Builder.Default
    private Boolean status = true;

    @Column(name = "lastmoddt")
    @Builder.Default
    private LocalDateTime lastmoddt = LocalDateTime.now();

    @OneToMany(mappedBy = "role")
    private Set<User> users;

    @OneToOne
    @JoinColumn(name = "lastmodby", referencedColumnName = "id")
    private User lastModBy;

    @Column(name = "last_mod_by_role")
    private UUID lastModByRole;
}