// src/main/java/com/example/prototip/models/kompanija/KompanijaModel.java
package com.example.prototip.models.kompanija;

import lombok.Data;
import java.util.UUID;

@Data
public class KompanijaModel {
    private UUID id;
    private String naziv;
    private String adresa;
    private String pib;
    private String mbr;
    private Boolean status;
}