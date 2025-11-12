package com.example.prototip.models.kompanija;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UpdateKompanijaModel {
    private String naziv;
    private String adresa;
    private String pib;
    private String mbr;
}
