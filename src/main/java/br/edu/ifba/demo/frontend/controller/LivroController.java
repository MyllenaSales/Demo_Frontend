package br.edu.ifba.demo.frontend.controller;

import br.edu.ifba.demo.frontend.dto.LivroDTO;
import br.edu.ifba.demo.frontend.service.GeneroService;
import br.edu.ifba.demo.frontend.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/livros")
public class LivroController {

    @Autowired
    private GeneroService generoService; 

    @Autowired
    private LivroService livroService;

    @GetMapping("/listAll")
    public String listAll(Model model) {
        List<LivroDTO> listaLivros = livroService.listAll();
        model.addAttribute("listaLivros", listaLivros);
        return "catalog"; 
    }

    @GetMapping("/register")
    public String showRegisterForm(Model model) {
        model.addAttribute("livroDTO", new LivroDTO());
        model.addAttribute("listaGeneros", generoService.listAll()); 
        return "register";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        LivroDTO livroDTO = livroService.getById(id);
        model.addAttribute("livroDTO", livroDTO);
        model.addAttribute("listaGeneros", generoService.listAll()); 
        return "edit";
    }
  
    @PostMapping("/save")
    public String save(@ModelAttribute LivroDTO livroDTO) {
        livroService.save(livroDTO);
        return "redirect:/livros/listAll"; 
    }

    @GetMapping("/view/{id}")
    public String view(@PathVariable Long id, Model model) {
        LivroDTO livroDTO = livroService.getById(id);
        model.addAttribute("livroDTO", livroDTO);
        return "view"; 
    }

    @PostMapping("/update/{id}")
    public String update(@PathVariable Long id, @ModelAttribute LivroDTO livroDTO) {
        livroService.update(id, livroDTO);
        return "redirect:/livros/listAll"; 
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        livroService.delete(id);
        return "redirect:/livros/listAll"; 
    }

    @GetMapping("/findById")
    public String findById(@RequestParam Long id, Model model) {
        LivroDTO livroDTO = livroService.getById(id);
        model.addAttribute("listaLivros", List.of(livroDTO));
        return "catalog"; 
    }

    @GetMapping("/findByIsbn")
    public String findByIsbn(@RequestParam String isbn, Model model) {
        LivroDTO livroDTO = livroService.getByIsbn(isbn);
        model.addAttribute("listaLivros", List.of(livroDTO));
        return "catalog"; 
    }

    @GetMapping("/findByTitulo")
    public String findByTitulo(@RequestParam String titulo, Model model) {
        LivroDTO livroDTO = livroService.getByTitulo(titulo);
        model.addAttribute("listaLivros", List.of(livroDTO));
        return "catalog"; 
    }
}