package es.danielpr.practica1.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    @GetMapping("/")
    public String portada(Model model) {
        model.addAttribute("bienvenida", "Bienvenido a Pepephone");
        model.addAttribute("servicio", "Telefonía móvil e internet");

        return "index";
    }

    @GetMapping("/que")
    public String que(Model model) {
        model.addAttribute("empresa", "NUESTRA EMPRESA");
        return "que";
    }

    @GetMapping("/contacto")
    public String contacto(Model model) {
        model.addAttribute("contacto", "Contacta con nosotros");
        return "contacto";
    }
}
