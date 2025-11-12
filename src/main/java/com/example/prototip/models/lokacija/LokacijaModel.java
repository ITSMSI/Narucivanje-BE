// src/main/java/com/example/prototip/models/lokacija/LokacijaModel.java
package com.example.prototip.models.lokacija;

import lombok.Data;
import java.util.UUID;

@Data
public class LokacijaModel {
    private UUID id;
    private String adresa;
    private String grad;
    private String postKod;      // <-- matches entity
    private Boolean status;
}