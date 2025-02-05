package br.edu.ifba.demo.frontend.service;

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import br.edu.ifba.demo.frontend.dto.LivroDTO;

@Service
public class LivroService {

    private final String BASE_URL = "http://localhost:8081/livros"; // Backend URL

    private final RestTemplate restTemplate = new RestTemplate();

    // List all books
    public List<LivroDTO> listAll() {
        return List.of(restTemplate.getForObject(BASE_URL + "/listAll", LivroDTO[].class));
    }

    // Get book by ID
    public LivroDTO getById(Long id) {
        return restTemplate.getForObject(BASE_URL + "/findById/" + id, LivroDTO.class);
    }

    // Get book by ISBN
    public LivroDTO getByIsbn(String isbn) {
        return restTemplate.getForObject(BASE_URL + "/findByIsbn/" + isbn, LivroDTO.class);
    }

    // Get book by title
    public LivroDTO getByTitulo(String titulo) {
        return restTemplate.getForObject(BASE_URL + "/findByTitulo/" + titulo, LivroDTO.class);
    }

    // Save a new book
    public LivroDTO save(LivroDTO livro) {
        return restTemplate.postForObject(BASE_URL, livro, LivroDTO.class);
    }

    // Update an existing book
    public void update(Long id, LivroDTO livro) {
        restTemplate.put(BASE_URL + "/update/" + id, livro);
    }

    // Delete a book
    public void delete(Long id) {
        restTemplate.delete(BASE_URL + "/delete/" + id);
    }
}