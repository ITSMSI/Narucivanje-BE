package com.example.prototip.models.lokacija;

import com.example.prototip.models.kompanija.KompanijaLokacijaModel;
import com.example.prototip.models.user.UserLastModByModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LokacijaModel {
    private Long id;
    private String adresa;
    private Integer postkod;
    private String grad;
    private Boolean status;
    private LocalDateTime lastModDt;
    private KompanijaLokacijaModel kompanija;
    private UserLastModByModel lastModBy;
}
