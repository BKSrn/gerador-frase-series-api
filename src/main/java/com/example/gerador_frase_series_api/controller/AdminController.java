package com.example.gerador_frase_series_api.controller;

import com.example.gerador_frase_series_api.model.Frase;
import com.example.gerador_frase_series_api.repository.FraseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private FraseRepository fraseRepository;

    @PostMapping("/popular-banco")
    public String popularBanco() {

        // Inserir frases
        fraseRepository.save(new Frase("Breaking Bad", "I am the one who knocks!", "Walter White", "https://images.unsplash.com/photo-1574267432644-f737ae2d8c5f?w=300"));
        fraseRepository.save(new Frase("Game of Thrones", "Winter is coming.", "Ned Stark", "https://images.unsplash.com/photo-1536440136628-849c177e76a1?w=300"));
        fraseRepository.save(new Frase("Friends", "We were on a break!", "Ross Geller", "https://images.unsplash.com/photo-1574267432644-f737ae2d8c5f?w=300"));
        fraseRepository.save(new Frase("The Office", "That is what she said.", "Michael Scott", "https://images.unsplash.com/photo-1497032628192-86f99bcd76bc?w=300"));
        fraseRepository.save(new Frase("Stranger Things", "Friends do not lie.", "Eleven", "https://images.unsplash.com/photo-1594908900066-3f47337549d8?w=300"));
        fraseRepository.save(new Frase("The Crown", "I will do my duty.", "Queen Elizabeth II", "https://images.unsplash.com/photo-1478720568477-152d9b164e26?w=300"));
        fraseRepository.save(new Frase("Peaky Blinders", "By order of the Peaky Blinders!", "Thomas Shelby", "https://images.unsplash.com/photo-1485846234645-a62644f84728?w=300"));

        return "Banco populado com sucesso! " + fraseRepository.count() + " frases inseridas.";
    }

    @GetMapping("/contar-frases")
    public String contarFrases() {
        return "Total de frases no banco: " + fraseRepository.count();
    }
}