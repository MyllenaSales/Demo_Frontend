package br.edu.ifba.demo.frontend.dto;

import lombok.Data;

@Data
public class LivroDTO {
    private Long id_livro;
    private String titulo;
    private String autor;
    private String isbn;
    private Double preco;
}
