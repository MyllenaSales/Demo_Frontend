package br.edu.ifba.demo.frontend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import br.edu.ifba.demo.frontend.service.LivroService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import br.edu.ifba.demo.frontend.dto.LivroDTO;

@Controller
public class LivroController {

       @Autowired
    private LivroService livroService;

    
    /* Listar livros */
     @GetMapping("/livros/listAll")
     public ModelAndView livros() {
        List<LivroDTO> li = livroService.listAll();
        ModelAndView mv = new ModelAndView();
        mv.addObject("listaLivros", li);
        mv.setViewName("livros");
        return mv;
    }
    
    /* buscar por titulo */
     @GetMapping("/livros/findByTitulo")
     public ModelAndView getByTitulo(@RequestParam("titulo") String titulo) {
        LivroDTO livro = livroService.getByTitulo(titulo);
        ModelAndView mv = new ModelAndView();
        mv.addObject("livro", livro);
        mv.setViewName("livroDetalhe");
        return mv;
    }

        /* buscar por isbn */
     @GetMapping("/livros/findByIsbn")
     public ModelAndView getByIsbn(@RequestParam("isbn") String isbn) {
            LivroDTO livro = livroService.getByIsbn(isbn);
            ModelAndView mv = new ModelAndView();
            mv.addObject("livro", livro);
            mv.setViewName("livroDetalhe");
            return mv;
        }

        /* Buscar livro por ID */
     @GetMapping("/livros/findById/{id}")
     public ModelAndView getById(@PathVariable("id") Long id) {
        LivroDTO livro = livroService.getById(id);
        ModelAndView mv = new ModelAndView();
        mv.addObject("livro", livro);
        mv.setViewName("livroDetalhe");
        return mv;
        }

        
        /* Excluir livro */
     @GetMapping("/livros/delete/{id}")
     public String delete(@PathVariable("id") Long id) {
        livroService.delete(id);
        return "redirect:/livros/listAll";
        }
}

