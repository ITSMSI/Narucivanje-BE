// src/main/java/com/example/prototip/services/kompanija/IKompanijaService.java
package com.example.prototip.services.kompanija;

import com.example.prototip.models.kompanija.CreateKompanijaModel;
import com.example.prototip.models.kompanija.KompanijaModel;

public interface IKompanijaService {
    KompanijaModel CreateKompanija(CreateKompanijaModel createKompanijaModel);
}