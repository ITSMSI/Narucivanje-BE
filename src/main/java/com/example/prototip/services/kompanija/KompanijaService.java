package com.example.prototip.services.kompanija;

import com.example.prototip.mappers.KompanijaMapper;
import com.example.prototip.models.kompanija.CreateKompanijaModel;
import com.example.prototip.models.kompanija.KompanijaModel;
import com.example.prototip.repositories.IKompanijaRepository;
import com.example.prototip.repositories.IUserRepository;
import org.springframework.stereotype.Service;

@Service
public class KompanijaService implements IKompanijaService {
    private IKompanijaRepository iKompanijaRepository;
    //private IUserRepository iUserRepository;

    public KompanijaService(IKompanijaRepository iKompanijaRepository, IUserRepository iUserRepository) {
        this.iKompanijaRepository = iKompanijaRepository;
      //  this.iUserRepository = iUserRepository;
    }

    @Override
    public KompanijaModel CreateKompanija(CreateKompanijaModel createKompanijaModel) {
        //var user=iUserRepository.findById(createKompanijaModel.getUserId());
        var entity= KompanijaMapper.mapCreateKompanijaModelToKompanija(createKompanijaModel);
        entity.setStatus(true);
        iKompanijaRepository.save(entity);
        return KompanijaMapper.mapKompanijaToKompanijaModel(entity);
    }
}
