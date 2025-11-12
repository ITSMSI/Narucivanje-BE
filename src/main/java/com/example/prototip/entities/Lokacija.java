package com.example.prototip.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;   // ← ADD THIS
import lombok.*;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "lokacija")
@Data @Builder @NoArgsConstructor @AllArgsConstructor
public class Lokacija {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "adresa", nullable = false)
    @NotBlank
    private String adresa;

    @Column(name = "postkod")
    @NotNull
    private Integer postkod;

    @Column(name = "grad", nullable = false)
    @NotBlank
    private String grad;

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

    @OneToMany(mappedBy = "lokacija")
    private Set<User> users;

    @OneToOne
    @JoinColumn(name = "lastmodby", referencedColumnName = "id")
    private User lastModBy;
}