package br.edu.ifba.demo.frontend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import br.edu.ifba.demo.frontend.dto.LivroDTO;

import java.util.List;

@Service
public class LivroService {

    @Autowired
    private WebClient webClient;

    private final String URL_BASE = "http://localhost:8080"; // URL base para o backend

    // Listar todos os livros
    public List<LivroDTO> listAllLivros() {
        return webClient.get()
                .uri(URL_BASE + "/livros/listall")
                .retrieve()
                .bodyToFlux(LivroDTO.class)
                .collectList()
                .block();
    }

    // Excluir livro
    public void delete(Long id) {
        webClient.delete()
                .uri(URL_BASE + "/livros/delete/" + id)
                .retrieve()
                .bodyToMono(Void.class)
                .block();
    }

    // Buscar livro por ID
    public LivroDTO findById(Long id) {
        return webClient.get()
                .uri(URL_BASE + "/livros/findById/{id}", id)
                .retrieve()
                .bodyToMono(LivroDTO.class)
                .block();
    }

    // Buscar livro por ISBN
    public LivroDTO findByIsbn(String isbn) {
        return webClient.get()
                .uri(URL_BASE + "/livros/findByIsbn/{isbn}", isbn)
                .retrieve()
                .bodyToMono(LivroDTO.class)
                .block();
    }

    // Buscar livro por Título
    public List<LivroDTO> findByTitulo(String titulo) {
        return webClient.get()
                .uri(URL_BASE + "/livros/findByTitulo/{titulo}", titulo)
                .retrieve()
                .bodyToFlux(LivroDTO.class)
                .collectList()
                .block();
    }

    // Salvar livro
    public LivroDTO salvar(LivroDTO livroDTO) {
        return webClient.post()
                .uri(URL_BASE + "/livros/cadastrar")
                .bodyValue(livroDTO)
                .retrieve()
                .bodyToMono(LivroDTO.class)
                .block();
    }
}
