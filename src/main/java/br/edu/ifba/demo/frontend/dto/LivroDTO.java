package br.edu.ifba.demo.frontend.dto;


public class LivroDTO {
    private Long id_livro;
    private String titulo;
    private String autor;
    private String editora;
    private Integer ano_publicacao;
    private GeneroDTO genero;
    private String isbn;
    private Integer num_paginas;
    private String sinopse;
    private String idioma;
    private Double preco;

    // Getters and Setters
    public Long getId_livro() { return id_livro; }
    public void setId_livro(Long id_livro) { this.id_livro = id_livro; }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public String getAutor() { return autor; }
    public void setAutor(String autor) { this.autor = autor; }

    public String getEditora() { return editora; }
    public void setEditora(String editora) { this.editora = editora; }

    public Integer getAno_publicacao() { return ano_publicacao; }
    public void setAno_publicacao(Integer ano_publicacao) { this.ano_publicacao = ano_publicacao; }

    public GeneroDTO getGenero() { return genero; }
    public void setGenero(GeneroDTO genero) { this.genero = genero; }

    public String getIsbn() { return isbn; }
    public void setIsbn(String isbn) { this.isbn = isbn; }

    public Integer getNum_paginas() { return num_paginas; }
    public void setNum_paginas(Integer num_paginas) { this.num_paginas = num_paginas; }

    public String getSinopse() { return sinopse; }
    public void setSinopse(String sinopse) { this.sinopse = sinopse; }

    public String getIdioma() { return idioma; }
    public void setIdioma(String idioma) { this.idioma = idioma; }

    public Double getPreco() { return preco; }
    public void setPreco(Double preco) { this.preco = preco; }
}