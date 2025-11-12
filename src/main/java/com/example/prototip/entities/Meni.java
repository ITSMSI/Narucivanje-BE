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
@Table(name = "meni")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Meni {

    @Id
    @GeneratedValue
    @UuidGenerator(style = UuidGenerator.Style.TIME)
    @Column(name = "id")
    private UUID id;

    @Column(name = "datum", nullable = false)
    @NotNull
    private LocalDate datum;

    @Column(name = "status", nullable = false)
    @NotNull
    @Builder.Default
    private Boolean status = true;

    @Column(name = "lastmoddt")
    // Fixed: Add @Builder.Default for Lombok warning (line ~37)
    @Builder.Default
    private LocalDateTime lastModDt = LocalDateTime.now();

    @OneToOne
    @JoinColumn(name = "lastmodby", referencedColumnName = "id")
    private User lastModBy;

    @Column(name = "last_mod_by_meni")
    private UUID lastModByMeni;
}