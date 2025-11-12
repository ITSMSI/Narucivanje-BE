// src/main/java/com/example/prototip/mappers/KompanijaMapper.java
package com.example.prototip.mappers;

import com.example.prototip.entities.Kompanija;
import com.example.prototip.models.kompanija.CreateKompanijaModel;
import com.example.prototip.models.kompanija.KompanijaModel;
import org.springframework.stereotype.Component;

@Component
public class KompanijaMapper {

    public static Kompanija mapCreateKompanijaModelToKompanija(CreateKompanijaModel model) {
        Kompanija kompanija = new Kompanija();
        kompanija.setNaziv(model.getNaziv());
        kompanija.setAdresa(model.getAdresa());
        kompanija.setPib(model.getPib());
        kompanija.setMbr(model.getMbr());
        return kompanija;
    }

    public static KompanijaModel mapKompanijaToKompanijaModel(Kompanija entity) {
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