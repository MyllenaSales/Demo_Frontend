package br.edu.ifba.demo.frontend.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import br.edu.ifba.demo.frontend.dto.LivroDTO;
import br.edu.ifba.demo.frontend.service.LivroService;

@Controller
@RequestMapping("/livros")
public class LivroController {

    @Autowired
    private LivroService livroService;

    // List all books
    @GetMapping("/listAll")
    public String listAll(Model model) {
        List<LivroDTO> listaLivros = livroService.listAll();
        model.addAttribute("listaLivros", listaLivros);
        return "catalog"; // Returns the catalog.html template
    }

    // Show registration form
    @GetMapping("/register")
    public String showRegisterForm(Model model) {
        model.addAttribute("livroDTO", new LivroDTO());
        return "register"; // Returns the register.html template
    }

    // Save a new book
    @PostMapping("/save")
    public String save(@ModelAttribute LivroDTO livroDTO) {
        livroService.save(livroDTO);
        return "redirect:/livros/listAll"; // Redirects to the catalog page
    }

    // Show edit form
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        LivroDTO livroDTO = livroService.getById(id);
        model.addAttribute("livroDTO", livroDTO);
        return "edit"; // Returns the edit.html template
    }

    // Update an existing book
    @PostMapping("/update/{id}")
    public String update(@PathVariable Long id, @ModelAttribute LivroDTO livroDTO) {
        livroService.update(id, livroDTO);
        return "redirect:/livros/listAll"; // Redirects to the catalog page
    }

    // Delete a book
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        livroService.delete(id);
        return "redirect:/livros/listAll"; // Redirects to the catalog page
    }

    // Search by ID
    @GetMapping("/findById")
    public String findById(@RequestParam Long id, Model model) {
        LivroDTO livroDTO = livroService.getById(id);
        model.addAttribute("listaLivros", List.of(livroDTO));
        return "catalog"; // Returns the catalog.html template with search results
    }

    // Search by ISBN
    @GetMapping("/findByIsbn")
    public String findByIsbn(@RequestParam String isbn, Model model) {
        LivroDTO livroDTO = livroService.getByIsbn(isbn);
        model.addAttribute("listaLivros", List.of(livroDTO));
        return "catalog"; // Returns the catalog.html template with search results
    }

    // Search by title
    @GetMapping("/findByTitulo")
    public String findByTitulo(@RequestParam String titulo, Model model) {
        LivroDTO livroDTO = livroService.getByTitulo(titulo);
        model.addAttribute("listaLivros", List.of(livroDTO));
        return "catalog"; // Returns the catalog.html template with search results
    }
}