package com.example.prototip.models.obrok;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ObrokMeniModel {
    private Long id;
    private String naziv;
    private String opis;
    private byte[] slika;
}
