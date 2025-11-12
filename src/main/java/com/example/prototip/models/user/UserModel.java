package com.example.prototip.models.user;

import com.example.prototip.models.kompanija.KompanijaUserModel;
import com.example.prototip.models.lokacija.LokacijaUserModel;
import com.example.prototip.models.role.RoleUserModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserModel {
    private Long id;
    private String ime;
    private String prezime;
    private String email;
    private String password;
    private String telefon;
    private Boolean status;
    private LocalDateTime lastModDt=LocalDateTime.now();
    private KompanijaUserModel kompanija;
    private LokacijaUserModel lokacija;
    private RoleUserModel role;
    private UserLastModByModel lastModBy;

}
