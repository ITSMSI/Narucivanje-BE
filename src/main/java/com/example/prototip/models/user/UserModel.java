package com.example.prototip.models.user;

import lombok.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserModel {
    private UUID id;
    private String ime;
    private String prezime;
    private String email;
    private String password;
    private String telefon;
    private Boolean status;
    // Fixed: Add @Builder.Default for Lombok warning (line ~25)
    @Builder.Default
    private LocalDateTime lastModDt = LocalDateTime.now();
    private UUID kompanija;
    private UUID lokacija;
    private UUID role;
}