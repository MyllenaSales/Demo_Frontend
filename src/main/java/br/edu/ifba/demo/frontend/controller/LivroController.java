package br.edu.ifba.demo.frontend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import br.edu.ifba.demo.frontend.dto.LivroDTO;
import br.edu.ifba.demo.frontend.service.LivroService;

import java.util.List;

@Controller
@RequestMapping("/livros")
public class LivroController {

    @Autowired
    private LivroService livroService;

    // Renderizar a página inicial
    @GetMapping("/")
    public String index() {
        return "livros"; // O arquivo HTML "livros.html" será renderizado
    }

    // Listar todos os livros
    @GetMapping("/listall")
    @ResponseBody
    public List<LivroDTO> listarLivros() {
        return livroService.listAllLivros();
    }

    // Cadastrar um novo livro
    @PostMapping("/cadastrar")
    @ResponseBody
    public LivroDTO cadastrarLivro(@RequestBody LivroDTO livroDTO) {
        return livroService.salvar(livroDTO);
    }

    // Excluir um livro pelo ID
    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public String excluirLivro(@PathVariable Long id) {
        livroService.delete(id);
        return "Livro excluído com sucesso!";
    }

    // Buscar um livro por ID
    @GetMapping("/findById/{id}")
    @ResponseBody
    public LivroDTO buscarLivroPorId(@PathVariable Long id) {
        return livroService.findById(id);
    }

    // Buscar um livro por ISBN
    @GetMapping("/findByIsbn/{isbn}")
    @ResponseBody
    public LivroDTO buscarLivroPorIsbn(@PathVariable String isbn) {
        return livroService.findByIsbn(isbn);
    }

    // Buscar um livro por Título
    @GetMapping("/findByTitulo/{titulo}")
    @ResponseBody
    public List<LivroDTO> buscarLivroPorTitulo(@PathVariable String titulo) {
        return livroService.findByTitulo(titulo);
    }
}
