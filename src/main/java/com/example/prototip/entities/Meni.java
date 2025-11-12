package com.example.prototip.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.time.LocalDateTime;


@Entity
@Table(name = "MENI")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Meni {
    @Column(name = "ID")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long meni;

    @Column(name = "DATUM")
    @NotBlank
    private Date datum;


    @Column(name = "STATUS", columnDefinition = "BIT default 1")
    @NotBlank
    private Boolean status;

    @Column(name = "LASTMODDT")
    @NotBlank
    private LocalDateTime lastModDt = LocalDateTime.now();

    @ManyToOne
    @JoinColumn(name = "obrok", nullable=false)
    private Obrok obrok;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "LASTMODBY", referencedColumnName = "ID")
    private User lastModBy;

}
