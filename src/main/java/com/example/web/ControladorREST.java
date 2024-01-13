package com.example.web;


import com.example.domain.Individuo;
import com.example.servicio.IndividuoServicio;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

        return "Indice";
    }
        @GetMapping("/anexar")
    public String agregar(Model otro_modelo)
    {
        otro_modelo.addAttribute("individuo", new Individuo());

        return "cambiar";
    }
    @PostMapping("/salvar")
    public String salvar(Individuo indiviDuo){
        IndividuoServicio.salvar(indiviDuo);
        return "redirec:/";
    } 
}
