package es.danielpr.demo2parametros.controladores;


import es.danielpr.demo2parametros.entidades.Mascota;
import es.danielpr.demo2parametros.entidades.TipoMascota;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;

@Controller
public class MainController {

    @GetMapping({"/", "/welcome"})
    public String welcome(
            @RequestParam(name = "nombre", required = false, defaultValue = "Mundo") String nombre, Model model) {
        model.addAttribute("nombre", nombre);
        model.addAttribute("saludo", "Un saludo para todos los programadores del mundo");
        model.addAttribute("mensaje", "Sed bienvenidos todos aquellos...");
        return "index";
    }

    @GetMapping("/saludo/{name}")
    public String saludo(@PathVariable String name, Model model) {
        model.addAttribute("saludo", "Hola " + name);
        return "saludo";
    }

    @GetMapping("/mascota")
    public String verMascota(Model model) {
        Mascota mascota = new Mascota ("Luci",
                LocalDate.of(2021, 2, 14),
                1424412L,
                TipoMascota.PERRO);
        model.addAttribute("mascota", mascota);
        return "mascota";
    }
}
