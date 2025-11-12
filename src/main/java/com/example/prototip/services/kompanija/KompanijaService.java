// src/main/java/com/example/prototip/services/kompanija/KompanijaService.java
package com.example.prototip.services.kompanija;

import com.example.prototip.mappers.KompanijaMapper;
import com.example.prototip.models.kompanija.CreateKompanijaModel;
import com.example.prototip.models.kompanija.KompanijaModel;
import com.example.prototip.repositories.IKompanijaRepository;
import com.example.prototip.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KompanijaService implements IKompanijaService {

    private final IKompanijaRepository iKompanijaRepository;
    private final UserRepository userRepository;

    @Autowired
    public KompanijaService(IKompanijaRepository iKompanijaRepository, UserRepository userRepository) {
        this.iKompanijaRepository = iKompanijaRepository;
        this.userRepository = userRepository;
    }

    @Override
    public KompanijaModel CreateKompanija(CreateKompanijaModel createKompanijaModel) {
        var entity = KompanijaMapper.mapCreateKompanijaModelToKompanija(createKompanijaModel);
        entity.setStatus(true);
        iKompanijaRepository.save(entity);
        return KompanijaMapper.mapKompanijaToKompanijaModel(entity);
    }
}