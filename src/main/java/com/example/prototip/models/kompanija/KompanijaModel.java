package com.example.prototip.models.kompanija;

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
public class KompanijaModel {
    private Long id;
    private String naziv;
    private String adresa;
    private String pib;
    private String mbr;
    private Boolean status;
    private LocalDateTime lastModDt;
    private UserLastModByModel lastModBy;
}
