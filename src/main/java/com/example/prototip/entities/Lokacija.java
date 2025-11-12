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

    @Column(name = "adresa", nullable = false)
    @NotBlank
    private String adresa;

    @Column(name = "grad", nullable = false)
    @NotBlank
    private String grad;

    @Column(name = "postkod")
    @NotNull
    private Integer postkod;

    @Column(name = "status", nullable = false)
    @NotNull
    @Builder.Default
    private Boolean status = true;

    @Column(name = "lastmoddt")
    @Builder.Default
    private LocalDateTime lastmoddt = LocalDateTime.now();

    @ManyToOne
    @JoinColumn(name = "kompanija", nullable = false)
    private Kompanija kompanija;

    @OneToMany(mappedBy = "lokacija")
    private Set<User> users;

    @OneToOne
    @JoinColumn(name = "lastmodby", referencedColumnName = "id")
    private User lastModBy;

    @Column(name = "last_mod_by_lokacija")
    private UUID lastModByLokacija;
}