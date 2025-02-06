package br.edu.ifba.demo.frontend.controller;

import br.edu.ifba.demo.frontend.dto.GeneroDTO;
import br.edu.ifba.demo.frontend.service.GeneroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/generos")
public class GeneroController {

    @Autowired
    private GeneroService generoService;

    // List all genres
    @GetMapping("/listAll")
    public String listAll(Model model) {
        List<GeneroDTO> listaGeneros = generoService.listAll();
        model.addAttribute("listaGeneros", listaGeneros);
        return "generos"; // Returns the generos.html template
    }


}