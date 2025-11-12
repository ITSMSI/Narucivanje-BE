// src/main/java/com/example/prototip/models/obrok/ObrokModel.java
package com.example.prototip.models.obrok;

import lombok.Data;
import java.util.UUID;

@Data
public class ObrokModel {
    private UUID id;
    private String naziv;
    private String opis;
    private Double cena;         // <-- matches entity
    private Boolean status;
}