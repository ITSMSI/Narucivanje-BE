// src/main/java/com/example/prototip/services/lokacija/LokacijaService.java
package com.example.prototip.services.lokacija;

import com.example.prototip.entities.Lokacija;
import com.example.prototip.models.lokacija.LokacijaModel;
import com.example.prototip.repositories.ILokacijaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LokacijaService {

    private final ILokacijaRepository iLokacijaRepository;

    public List<LokacijaModel> getAllLokacija() {
        return iLokacijaRepository.findAll()
                .stream()
                .map(this::toModel)
                .collect(Collectors.toList());
    }

    public LokacijaModel getLokacijaById(UUID id) {
        return iLokacijaRepository.findById(id)
                .map(this::toModel)
                .orElseThrow(() -> new RuntimeException("Lokacija not found"));
    }

    public LokacijaModel createLokacija(LokacijaModel model) {
        Lokacija entity = new Lokacija();
        entity.setAdresa(model.getAdresa());
        entity.setGrad(model.getGrad());
        entity.setPostKod(model.getPostKod());
        entity.setStatus(model.getStatus() != null ? model.getStatus() : true);

        Lokacija saved = iLokacijaRepository.save(entity);
        return toModel(saved);
    }

    private LokacijaModel toModel(Lokacija entity) {
        LokacijaModel model = new LokacijaModel();
        model.setId(entity.getId());
        model.setAdresa(entity.getAdresa());
        model.setGrad(entity.getGrad());
        model.setPostKod(entity.getPostKod());
        model.setStatus(entity.getStatus());
        return model;
    }
}