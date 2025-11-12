// src/main/java/com/example/prototip/models/kompanija/CreateKompanijaModel.java
package com.example.prototip.models.kompanija;

import lombok.Data;

@Data
public class CreateKompanijaModel {
    private String naziv;
    private String adresa;
    private String pib;
    private String mbr;
}