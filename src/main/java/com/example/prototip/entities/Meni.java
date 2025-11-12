// src/main/java/com/example/prototip/entities/Meni.java
package com.example.prototip.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

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

    @Column(name = "naziv")
    private String naziv;

    @Column(name = "status")
    @Builder.Default
    private Boolean status = true;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "kompanija")
    @JsonIgnore
    private Kompanija kompanija;
}