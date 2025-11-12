// src/main/java/com/example/prototip/models/role/RoleModel.java
package com.example.prototip.models.role;

import lombok.Data;
import java.util.UUID;

@Data
public class RoleModel {
    private UUID id;
    private String naziv;
    private Boolean admin;
    private Boolean endUser;     // <-- matches entity
    private Boolean meni;
    private Boolean obrok;
    private Boolean pregled;
    private Boolean status;
}