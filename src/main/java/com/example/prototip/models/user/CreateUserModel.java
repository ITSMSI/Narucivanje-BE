package com.example.prototip.models.user;

import com.example.prototip.models.kompanija.KompanijaUserModel;
import com.example.prototip.models.lokacija.LokacijaUserModel;
import com.example.prototip.models.role.RoleUserModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateUserModel {

    private String ime;
    private String prezime;
    private String email;
    private String password;
    private String telefon;
    private Boolean status;
    private KompanijaUserModel kompanija;
    private LokacijaUserModel lokacija;
    private RoleUserModel role;

}
