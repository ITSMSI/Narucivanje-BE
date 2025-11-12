package com.example.prototip.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "OBROK")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Obrok {
    @Column(name = "ID")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long obrok;

    @Column(name = "NAZIV")
    @NotBlank
    private String naziv;

    @Column(name = "OPIS")
    private String opis;

    @Column(name = "STATUS")
    @NotBlank
    private Boolean status;

    @Column(name = "SLIKA", columnDefinition = "VARBINARY")
    private byte[] slika;

    @Column(name = "LASTMODDT")
    @NotBlank
    private LocalDateTime lastModDt = LocalDateTime.now();

    @OneToMany(mappedBy = "obrok")
    private Set<Meni> meni;

    @OneToMany(mappedBy = "obrok")
    private Set<Porudzbina> porudzbina;

    @OneToOne
    @JoinColumn(name = "LASTMODBY", referencedColumnName = "ID")
    private User lastModBy;

}
