package br.edu.ifba.demo.frontend.service;

import br.edu.ifba.demo.frontend.dto.GeneroDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.List;

@Service
public class GeneroService {

    private final String BASE_URL = "http://localhost:8081/generos"; // Backend URL
    private final RestTemplate restTemplate = new RestTemplate();

    // List all genres
    public List<GeneroDTO> listAll() {
        return List.of(restTemplate.getForObject(BASE_URL + "/listAll", GeneroDTO[].class));
    }
}