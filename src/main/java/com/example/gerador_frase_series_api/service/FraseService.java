package com.example.gerador_frase_series_api.service;

import com.example.gerador_frase_series_api.model.Frase;
import com.example.gerador_frase_series_api.repository.FraseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FraseService {
    @Autowired
    FraseRepository fraseRepository;

    public Frase buscarFraseAleatoria(){
        return fraseRepository.buscarFraseAleatoria();
    }
}
