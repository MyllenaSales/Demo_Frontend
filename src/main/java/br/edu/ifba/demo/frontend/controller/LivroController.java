package br.edu.ifba.demo.frontend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import br.edu.ifba.demo.frontend.service.LivroService;

@Controller
public class LivroController {

    @Autowired
    private LivroService livroService;

    
    @GetMapping("/livros")
    public ModelAndView listarLivros() {
        var livros = livroService.listAllLivros();  
        ModelAndView mv = new ModelAndView();
        mv.addObject("livros", livros);  
        mv.setViewName("livros");  
        return mv;
    }

    // Excluir livro pelo ID
    @GetMapping("/livro/delete/{id}")
    public ModelAndView excluirLivro(@PathVariable Long id) {
        boolean sucesso = livroService.delete(id);  
        ModelAndView mv = new ModelAndView();
        mv.addObject("sucesso", sucesso ? "Livro excluído." : "Erro ao excluir livro");
        mv.setViewName("livros");  
        return mv;
    }

    // Buscar livro por ID
    @GetMapping("/livro/{id}")
    public ModelAndView consultarLivroPorId(@PathVariable Long id) {
        var livro = livroService.findById(id); 
        ModelAndView mv = new ModelAndView();
        mv.addObject("livro", livro); 
        mv.setViewName("livros");
        return mv;
    }

    // Buscar livro por ISBN
    @GetMapping("/livro/isbn/{isbn}")
    public ModelAndView consultarLivroPorIsbn(@PathVariable String isbn) {
        var livro = livroService.findByIsbn(isbn);  
        ModelAndView mv = new ModelAndView();
        mv.addObject("livro", livro);
        mv.setViewName("livros");
        return mv;
    }

    // Buscar livro por Título
    @GetMapping("/livro/titulo/{titulo}")
    public ModelAndView consultarLivroPorTitulo(@PathVariable String titulo) {
        var livro = livroService.findByTitulo(titulo);  
        ModelAndView mv = new ModelAndView();
        mv.addObject("livro", livro);
        mv.setViewName("livros");
        return mv;
    }
}
