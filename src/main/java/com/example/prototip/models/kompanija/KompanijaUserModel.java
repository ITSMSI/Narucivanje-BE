package com.example.prototip.models.kompanija;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class KompanijaUserModel {
    private Long id;
    private String naziv;
    private String adresa;
}
