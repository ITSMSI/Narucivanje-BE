// src/main/java/com/example/prototip/services/obrok/ObrokService.java
package com.example.prototip.services.obrok;

import com.example.prototip.entities.Obrok;
import com.example.prototip.models.obrok.ObrokModel;
import com.example.prototip.repositories.IObrokRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ObrokService {

    private final IObrokRepository iObrokRepository;

    public List<ObrokModel> getAllObrok() {
        return iObrokRepository.findAll()
                .stream()
                .map(this::toModel)
                .collect(Collectors.toList());
    }

    public ObrokModel getObrokById(UUID id) {
        return iObrokRepository.findById(id)
                .map(this::toModel)
                .orElseThrow(() -> new RuntimeException("Obrok not found"));
    }

    public ObrokModel createObrok(ObrokModel model) {
        Obrok entity = new Obrok();
        entity.setNaziv(model.getNaziv());
        entity.setOpis(model.getOpis());
        entity.setCena(model.getCena());
        entity.setStatus(model.getStatus() != null ? model.getStatus() : true);

        Obrok saved = iObrokRepository.save(entity);
        return toModel(saved);
    }

    private ObrokModel toModel(Obrok entity) {
        ObrokModel model = new ObrokModel();
        model.setId(entity.getId());
        model.setNaziv(entity.getNaziv());
        model.setOpis(entity.getOpis());
        model.setCena(entity.getCena());
        model.setStatus(entity.getStatus());
        return model;
    }
}