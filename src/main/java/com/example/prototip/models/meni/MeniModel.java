package com.example.prototip.models.meni;

import com.example.prototip.models.obrok.ObrokMeniModel;
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
public class MeniModel {
    private Long id;
    private Long datum;
    private Boolean status;
    private LocalDateTime lastModDt;
    private ObrokMeniModel obrok;
    private UserLastModByModel lastModBy;
}
