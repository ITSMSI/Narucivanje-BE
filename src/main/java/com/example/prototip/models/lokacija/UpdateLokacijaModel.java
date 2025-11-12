package com.example.prototip.models.lokacija;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UpdateLokacijaModel {
    private String adresa;
    private Integer postkod;
    private String grad;
}
