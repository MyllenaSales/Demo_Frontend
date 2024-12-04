package br.edu.ifba.demo.frontend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import br.edu.ifba.demo.frontend.service.LivroService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable; 
import org.springframework.web.bind.annotation.PostMapping;
/*import org.springframework.web.bind.annotation.RequestMapping; */
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import br.edu.ifba.demo.frontend.dto.LivroDTO;

@Controller
public class LivroController {

       @Autowired
    private LivroService livroService;

    
    /* salvar livro */
    @PostMapping("/livros/save")
    public String save(@ModelAttribute LivroDTO livroDTO) {
        livroService.save(livroDTO); 
        return "redirect:/livros/listAll"; 
    }

    /* listar livros */
     @GetMapping("/livros/listAll")
     public ModelAndView livros() {
        List<LivroDTO> li = livroService.listAll();
        ModelAndView mv = new ModelAndView();
        mv.addObject("listaLivros", li);
        mv.setViewName("livros");
        return mv;
    }

    
    /* buscar por título */
     @GetMapping("/livros/findByTitulo/{titulo}")
     public ModelAndView getByTitulo(@RequestParam("titulo") String titulo) {
        LivroDTO livro1 = livroService.getByTitulo(titulo);
        ModelAndView mv = new ModelAndView();
       if (livro1 != null) {
            mv.addObject("listaLivros", List.of(livro1)); 
        } else {
           mv.addObject("errorMessage", "Livro não encontrado!");
        }
          mv.setViewName("livros");
          return mv;
    }

       /* buscar por isbn */
       @GetMapping("/livros/findByIsbn/{isbn}")
       public ModelAndView getByIsbn(@RequestParam("isbn") String isbn) {
           LivroDTO livro2 = livroService.getByIsbn(isbn);
           ModelAndView mv = new ModelAndView();
           if (livro2 != null) {
               mv.addObject("listaLivros", List.of(livro2));
           } else {
               mv.addObject("errorMessage", "Livro não encontrado!");
           }
           mv.setViewName("livros");
           return mv;
       }
       

        /* buscar por ID */
        @GetMapping("/livros/findById/{id}")
        public ModelAndView getById(@RequestParam("id") Long id) {
            LivroDTO livro = livroService.getById(id);
            ModelAndView mv = new ModelAndView();
            if (livro != null) {
                mv.addObject("listaLivros", List.of(livro)); 
            } else {
                mv.addObject("errorMessage", "Livro não encontrado!");
            }
            mv.setViewName("livros");
            return mv;
        }
        
        
        /* excluir livro */
        @GetMapping("/livros/delete/{id}")
        public ModelAndView delete(@PathVariable Long id) {
        livroService.delete(id); // Chama o serviço para excluir o livro
        ModelAndView mv = new ModelAndView();
        mv.addObject("delete", "Livro excluído com sucesso!");
        mv.setViewName("livros"); // Redireciona para a página de livros
        return mv;
    }
}

