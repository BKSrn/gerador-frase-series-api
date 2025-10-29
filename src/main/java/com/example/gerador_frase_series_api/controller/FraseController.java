package com.example.gerador_frase_series_api.controller;

import com.example.gerador_frase_series_api.dto.FraseDTO;
import com.example.gerador_frase_series_api.service.FraseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/series")
public class FraseController {
    @Autowired
    FraseService fraseService;

    @GetMapping
    public List<FraseDTO> buscarTodasFrases(){
        return fraseService.buscarTodasFrases();
    }

    @GetMapping("/frases")
    public FraseDTO buscarFrase(){
        return fraseService.buscarFraseAleatoria();
    }
}
