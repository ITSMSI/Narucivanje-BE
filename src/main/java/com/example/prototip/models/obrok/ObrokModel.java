package com.example.prototip.models.obrok;

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
public class ObrokModel {
    private Long id;
    private String naziv;
    private String opis;
    private Boolean status;
    private byte[] slika;
    private LocalDateTime lastModDt;
    private UserLastModByModel lastModBy;
}
