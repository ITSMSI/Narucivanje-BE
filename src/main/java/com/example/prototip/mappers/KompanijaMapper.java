package com.example.prototip.mappers;

import com.example.prototip.entities.Kompanija;
import com.example.prototip.models.kompanija.CreateKompanijaModel;
import com.example.prototip.models.kompanija.KompanijaModel;
import com.example.prototip.models.kompanija.UpdateKompanijaModel;
import com.example.prototip.models.user.UserLastModByModel;

import java.util.ArrayList;
import java.util.List;

public class KompanijaMapper {

    public static KompanijaModel mapKompanijaToKompanijaModel(Kompanija kompanija){
        return KompanijaModel.builder()
                .id(kompanija.getKompanija())
                .naziv(kompanija.getNaziv())
                .adresa(kompanija.getAdresa())
                .pib(kompanija.getPib())
                .mbr(kompanija.getMbr())
                .status(kompanija.getStatus())
                .lastModDt(kompanija.getLastModDt())
                .lastModBy(UserLastModByModel.builder()
                        .id(kompanija.getLastModBy().getUser())
                        .ime(kompanija.getLastModBy().getIme())
                        .prezime(kompanija.getLastModBy().getPrezime())
                        .email(kompanija.getLastModBy().getEmail())
                        .build()
                )
                .build();
    }
    public static Kompanija mapKompanijaModelToKompanija(KompanijaModel kompanija){
        return Kompanija.builder()
                .kompanija(kompanija.getId())
                .naziv(kompanija.getNaziv())
                .adresa(kompanija.getAdresa())
                .pib(kompanija.getPib())
                .mbr(kompanija.getMbr())
                .status(kompanija.getStatus())
                .lastModDt(kompanija.getLastModDt())
                .build();
    }
    public static Kompanija mapCreateKompanijaModelToKompanija(CreateKompanijaModel kompanija){
        return Kompanija.builder()
                .naziv(kompanija.getNaziv())
                .adresa(kompanija.getAdresa())
                .pib(kompanija.getPib())
                .mbr(kompanija.getMbr())
                .build();
    }
    public static Kompanija mapUpdateKompanijaModelToKompanija(UpdateKompanijaModel kompanija){
        return Kompanija.builder()
                .naziv(kompanija.getNaziv())
                .adresa(kompanija.getAdresa())
                .pib(kompanija.getPib())
                .mbr(kompanija.getMbr())
                .build();
    }


    public static List<KompanijaModel> mapKompanijaListToKompanijaModelList(List<Kompanija> kompanijaList){
        List<KompanijaModel> kompanijaModelList = new ArrayList<>();
        for(Kompanija kompanija : kompanijaList){
            kompanijaModelList.add(mapKompanijaToKompanijaModel(kompanija));
        }
        return kompanijaModelList;
    }

}
