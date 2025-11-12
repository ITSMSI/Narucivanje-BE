package com.example.prototip.models.role;

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
public class RoleModel {
    private Long id;
    private String naziv;
    private Boolean admin;
    private Boolean enduser;
    private Boolean obrok;
    private Boolean meni;
    private Boolean kompanija;
    private Boolean pregled;
    private Boolean status;
    private LocalDateTime lastModDt;
    private UserLastModByModel lastmodby;
}
