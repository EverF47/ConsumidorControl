package com.example.web;


import com.example.domain.Individuo;
import com.example.servicio.IndividuoServicio;
import jakarta.validation.Valid;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
public class ControladorREST {

    @Autowired
    private IndividuoServicio IndividuoServicio;

    @GetMapping("/")
    public String comienzo(Model model) {
        List<Individuo> individuos = IndividuoServicio.listaIndividuos();
        log.info("estoy ejecutando el controlaador de MVC ");

        model.addAttribute("individuos", individuos);

        return "indice";
    }
        @GetMapping("/anexar")
    public String agregar(Model otro_modelo)
    {
        otro_modelo.addAttribute("individuo", new Individuo());

        return "cambiar";
    }
    @PostMapping("/salvar")
    public String salvar(@Valid Individuo individuo, Errors error){
        if(error.hasErrors())
            {
                return "cambiar";
            }
        
        IndividuoServicio.salvar(individuo);
        return "redirect:/";
    } 
    
    @GetMapping("/cambiar/{id_individuo}")
    public String cambiar(Individuo individuo,Model model)
    {
    individuo = IndividuoServicio.localizarIndividuo(individuo);
    model.addAttribute("individuo",individuo);
    return "cambiar";
    }
    
    @GetMapping("/borrar/{id_individuo}")
    public String borrar(Individuo individuo)
    {
    IndividuoServicio.borrar(individuo);
    return "redirect:/";
    }
}
