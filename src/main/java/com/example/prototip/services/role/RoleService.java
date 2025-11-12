// src/main/java/com/example/prototip/services/role/RoleService.java
package com.example.prototip.services.role;

import com.example.prototip.entities.Role;
import com.example.prototip.models.role.RoleModel;
import com.example.prototip.repositories.IRoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RoleService {

    private final IRoleRepository iRoleRepository;

    public List<RoleModel> getAllRole() {
        return iRoleRepository.findAll()
                .stream()
                .map(this::toModel)
                .collect(Collectors.toList());
    }

    public RoleModel getRoleById(UUID id) {
        return iRoleRepository.findById(id)
                .map(this::toModel)
                .orElseThrow(() -> new RuntimeException("Role not found"));
    }

    public RoleModel createRole(RoleModel model) {
        Role entity = new Role();
        entity.setNaziv(model.getNaziv());
        entity.setAdmin(model.getAdmin());
        entity.setEndUser(model.getEndUser());
        entity.setMeni(model.getMeni());
        entity.setObrok(model.getObrok());
        entity.setPregled(model.getPregled());
        entity.setStatus(model.getStatus() != null ? model.getStatus() : true);

        Role saved = iRoleRepository.save(entity);
        return toModel(saved);
    }

    private RoleModel toModel(Role entity) {
        RoleModel model = new RoleModel();
        model.setId(entity.getId());
        model.setNaziv(entity.getNaziv());
        model.setAdmin(entity.getAdmin());
        model.setEndUser(entity.getEndUser());
        model.setMeni(entity.getMeni());
        model.setObrok(entity.getObrok());
        model.setPregled(entity.getPregled());
        model.setStatus(entity.getStatus());
        return model;
    }
}