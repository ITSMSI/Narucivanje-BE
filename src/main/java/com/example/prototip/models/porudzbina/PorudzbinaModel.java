package com.example.prototip.models.porudzbina;

import com.example.prototip.models.obrok.ObrokPorudzbinaModel;
import com.example.prototip.models.user.UserLastModByModel;
import com.example.prototip.models.user.UserModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PorudzbinaModel {
    private Long id;
    private Date datum;
    private Boolean status;
    private LocalDateTime lastModDt;
    private String komentar;
    private ObrokPorudzbinaModel obrok;
    private UserModel user;
    private UserLastModByModel lastModBy;
}
