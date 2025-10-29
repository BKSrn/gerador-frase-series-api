package com.example.gerador_frase_series_api.controller;

import com.example.gerador_frase_series_api.model.Frase;
import com.example.gerador_frase_series_api.service.FraseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FraseController {
    @Autowired
    FraseService fraseService;

    @GetMapping("/series/frases")
    public Frase buscarFrase(){
        return fraseService.buscarFraseAleatoria();
    }
}
