package br.edu.ifba.demo.frontend.service;

import br.edu.ifba.demo.frontend.dto.LivroDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.List;

@Service
public class LivroService {

    private final String BASE_URL = "http://localhost:8081/livros"; // Backend URL
    private final RestTemplate restTemplate = new RestTemplate();

    public List<LivroDTO> listAll() {
        return List.of(restTemplate.getForObject(BASE_URL + "/listAll", LivroDTO[].class));
    }

    public LivroDTO getById(Long id) {
        return restTemplate.getForObject(BASE_URL + "/findById/" + id, LivroDTO.class);
    }

    public LivroDTO getByIsbn(String isbn) {
        return restTemplate.getForObject(BASE_URL + "/findByIsbn/" + isbn, LivroDTO.class);
    }

    public LivroDTO getByTitulo(String titulo) {
        return restTemplate.getForObject(BASE_URL + "/findByTitulo/" + titulo, LivroDTO.class);
    }

    public LivroDTO save(LivroDTO livro) {
        return restTemplate.postForObject(BASE_URL, livro, LivroDTO.class);
    }

    public void update(Long id, LivroDTO livro) {
        restTemplate.put(BASE_URL + "/update/" + id, livro);
    }

    public void delete(Long id) {
        restTemplate.delete(BASE_URL + "/delete/" + id);
    }
}