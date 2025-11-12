package com.example.prototip.models.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserLastModByModel {
    private Long id;
    private String ime;
    private String prezime;
    private String email;
}
