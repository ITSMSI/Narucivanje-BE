// src/main/java/com/example/prototip/services/kompanija/KompanijaService.java
package com.example.prototip.services.kompanija;

import com.example.prototip.entities.Kompanija;
import com.example.prototip.models.kompanija.CreateKompanijaModel;
import com.example.prototip.models.kompanija.KompanijaModel;
import com.example.prototip.repositories.IKompanijaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class KompanijaService implements IKompanijaService {

    private final IKompanijaRepository iKompanijaRepository;

    public KompanijaModel getKompanijaById(UUID id) {
        return iKompanijaRepository.findById(id)
                .map(entity -> {
                    KompanijaModel model = new KompanijaModel();
                    model.setId(entity.getId());
                    model.setNaziv(entity.getNaziv());
                    model.setAdresa(entity.getAdresa());
                    model.setPib(entity.getPib());
                    model.setMbr(entity.getMbr());
                    model.setStatus(entity.getStatus());
                    return model;
                })
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
        KompanijaModel result = new KompanijaModel();
        result.setId(saved.getId());
        result.setNaziv(saved.getNaziv());
        result.setAdresa(saved.getAdresa());
        result.setPib(saved.getPib());
        result.setMbr(saved.getMbr());
        result.setStatus(saved.getStatus());
        return result;
    }

    @Override
    public KompanijaModel CreateKompanija(CreateKompanijaModel createKompanijaModel) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'CreateKompanija'");
    }
}