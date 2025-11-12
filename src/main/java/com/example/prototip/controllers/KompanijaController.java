package com.example.prototip.controllers;

import com.example.prototip.models.kompanija.CreateKompanijaModel;
import com.example.prototip.services.kompanija.IKompanijaService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/kompanija")
public class KompanijaController {
    private IKompanijaService iKompanijaService;

    public KompanijaController(IKompanijaService iKompanijaService) {
        this.iKompanijaService = iKompanijaService;
    }
    @PostMapping("create")
    public ResponseEntity<?> CreateKompanija(@RequestBody @Valid CreateKompanijaModel model, BindingResult result){
        if(result.hasErrors()){
            return new ResponseEntity<>(result.getAllErrors(),HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(iKompanijaService.CreateKompanija(model),HttpStatus.OK);

    }



}
