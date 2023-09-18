package es.danielpr.practica1.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
        String horario = "8:00 a 23:45";
        String pais = "España";
        model.addAttribute("contacto", "Contacta con nosotros");
        model.addAttribute("horario", "Nuestro horario es de " + horario);
        model.addAttribute("pais", "Nuestros Call Centers se encuentran en " + pais);
        model.addAttribute("telefono", "Llama al 1706");
        return "contacto";
    }
}
