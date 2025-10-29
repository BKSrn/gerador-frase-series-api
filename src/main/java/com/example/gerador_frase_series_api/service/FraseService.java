package com.example.gerador_frase_series_api.service;

import com.example.gerador_frase_series_api.dto.FraseDTO;
import com.example.gerador_frase_series_api.model.Frase;
import com.example.gerador_frase_series_api.repository.FraseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FraseService {
    @Autowired
    FraseRepository fraseRepository;

    public FraseDTO buscarFraseAleatoria(){
        Frase frase = fraseRepository.buscarFraseAleatoria();

        return new FraseDTO(frase.getTitulo(), frase.getFrase(), frase.getPersonagem(), frase.getPoster());
    }

    public List<FraseDTO> buscarTodasFrases() {
        List<Frase> frases = fraseRepository.findAll();

        return frases.stream()
                .map(f -> new FraseDTO(f.getTitulo(), f.getFrase(), f.getPersonagem(), f.getPoster()))
                .collect(Collectors.toList());
    }
}
