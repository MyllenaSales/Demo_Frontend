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

    private final String URL_LIVROS = "/livros"; 

    // Listar todos os livros
    public List<LivroDTO> listAllLivros() {
        return webClient.get().uri(URL_LIVROS + "/listall")  
                .retrieve()
                .bodyToFlux(LivroDTO.class)
                .collectList()
                .block();
    }

    // Excluir livro
    public boolean delete(Long id) {
        return webClient.delete().uri(URL_LIVROS + "/delete/" + id)
                .retrieve()
                .bodyToMono(Boolean.class)  
                .block();
    }

    // Buscar livro por ID
    public LivroDTO findById(Long id) {
        return webClient.get().uri(URL_LIVROS + "/findById/{id}", id)
                .retrieve()
                .bodyToMono(LivroDTO.class)
                .block();
    }

    // Buscar livro por ISBN
    public LivroDTO findByIsbn(String isbn) {
        return webClient.get().uri(URL_LIVROS + "/findByIsbn/{isbn}", isbn)
                .retrieve()
                .bodyToMono(LivroDTO.class)
                .block();
    }

    // Buscar livro por Título
    public LivroDTO findByTitulo(String titulo) {
        return webClient.get().uri(URL_LIVROS + "/findByTitulo/{titulo}", titulo)
                .retrieve()
                .bodyToMono(LivroDTO.class)
                .block();
    }
}
