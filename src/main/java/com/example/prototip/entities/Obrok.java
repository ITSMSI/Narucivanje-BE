package com.example.prototip.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "obrok")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Obrok {

    @Id
    @GeneratedValue
    @UuidGenerator(style = UuidGenerator.Style.TIME)
    @Column(name = "id")
    private UUID id;

    @Column(name = "naziv", nullable = false)
    @NotBlank
    private String naziv;

    @Column(name = "opis")
    private String opis;

    @Column(name = "slika", columnDefinition = "bytea")
    private byte[] slika;

    @Column(name = "status", nullable = false)
    @NotNull
    @Builder.Default
    private Boolean status = true;

    @Column(name = "lastmoddt")
    // Fixed: Add @Builder.Default for Lombok warning (line ~41)
    @Builder.Default
    private LocalDateTime lastModDt = LocalDateTime.now();

    @OneToOne
    @JoinColumn(name = "lastmodby", referencedColumnName = "id")
    private User lastModBy;

    @Column(name = "last_mod_by_obrok")
    private UUID lastModByObrok;
}