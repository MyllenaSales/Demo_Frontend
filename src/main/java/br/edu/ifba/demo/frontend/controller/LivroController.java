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

    // Página inicial, listando todos os livros
    @GetMapping("/livros")
    public ModelAndView listarLivros() {
        var livros = livroService.listAllLivros();  // Corrigido para buscar livros diretamente
        ModelAndView mv = new ModelAndView();
        mv.addObject("livros", livros);  // Envia os livros para a view
        mv.setViewName("livros");  // Define a página de exibição
        return mv;
    }

    // Excluir livro pelo ID
    @GetMapping("/livro/delete/{id}")
    public ModelAndView excluirLivro(@PathVariable Long id) {
        boolean sucesso = livroService.delete(id);  // Chama o serviço para excluir o livro
        ModelAndView mv = new ModelAndView();
        mv.addObject("sucesso", sucesso ? "Livro excluído com sucesso!" : "Erro ao excluir livro");
        mv.setViewName("livros");  // Retorna à lista de livros após a exclusão
        return mv;
    }

    // Buscar livro por ID
    @GetMapping("/livro/{id}")
    public ModelAndView consultarLivroPorId(@PathVariable Long id) {
        var livro = livroService.findById(id);  // Chama o serviço para buscar livro por ID
        ModelAndView mv = new ModelAndView();
        mv.addObject("livro", livro);  // Envia o livro encontrado para a view
        mv.setViewName("livros");
        return mv;
    }

    // Buscar livro por ISBN
    @GetMapping("/livro/isbn/{isbn}")
    public ModelAndView consultarLivroPorIsbn(@PathVariable String isbn) {
        var livro = livroService.findByIsbn(isbn);  // Chama o serviço para buscar livro por ISBN
        ModelAndView mv = new ModelAndView();
        mv.addObject("livro", livro);
        mv.setViewName("livros");
        return mv;
    }

    // Buscar livro por Título
    @GetMapping("/livro/titulo/{titulo}")
    public ModelAndView consultarLivroPorTitulo(@PathVariable String titulo) {
        var livro = livroService.findByTitulo(titulo);  // Chama o serviço para buscar livro por Título
        ModelAndView mv = new ModelAndView();
        mv.addObject("livro", livro);
        mv.setViewName("livros");
        return mv;
    }
}
