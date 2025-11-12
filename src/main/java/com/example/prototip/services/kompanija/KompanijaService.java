// src/main/java/com/example/prototip/services/kompanija/KompanijaService.java
package com.example.prototip.services.kompanija;

import com.example.prototip.entities.Kompanija;
import com.example.prototip.models.kompanija.KompanijaModel;
import com.example.prototip.repositories.IKompanijaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class KompanijaService {

    private final IKompanijaRepository iKompanijaRepository;

    /*** NEW METHOD – returns all companies ***/
    public List<KompanijaModel> getAllKompanija() {
        return iKompanijaRepository.findAll()
                .stream()
                .map(this::toModel)
                .collect(Collectors.toList());
    }

    public KompanijaModel getKompanijaById(UUID id) {
        return iKompanijaRepository.findById(id)
                .map(this::toModel)
                .orElseThrow(() -> new RuntimeException("Kompanija not found"));
    }

    public KompanijaModel createKompanija(KompanijaModel model) {
        Kompanija entity = new Kompanija();
        entity.setNaziv(model.getNaziv());
        entity.setAdresa(model.getAdresa());
        entity.setPib(model.getPib());
        entity.setMbr(model.getMbr());
        entity.setStatus(model.getStatus() != null ? model.getStatus() : true);

        Kompanija saved = iKompanijaRepository.save(entity);
        return toModel(saved);
    }

    /*** Helper – avoids duplication ***/
    private KompanijaModel toModel(Kompanija entity) {
        KompanijaModel model = new KompanijaModel();
        model.setId(entity.getId());
        model.setNaziv(entity.getNaziv());
        model.setAdresa(entity.getAdresa());
        model.setPib(entity.getPib());
        model.setMbr(entity.getMbr());
        model.setStatus(entity.getStatus());
        return model;
    }
}