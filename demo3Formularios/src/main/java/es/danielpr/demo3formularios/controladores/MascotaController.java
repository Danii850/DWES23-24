package es.danielpr.demo3formularios.controladores;

import es.danielpr.demo3formularios.entidades.Mascota;
import es.danielpr.demo3formularios.servicios.MascotaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

// Para hacer logging
@Slf4j
//Si no queremos usar @Autowired usamos Lombok para inyectar
@RequiredArgsConstructor
@Controller
public class MascotaController {

    //@Autowired
    private final MascotaService servicio;

    @GetMapping({"/", "mascota/list"})
    public String listado(Model model) {
        model.addAttribute("listaMascotas", servicio.findAll());
        return "list";
    }

    @GetMapping("mascota/new")
    public String nuevaMascota(Model model) {
        log.info("estoy en nuevaMascota");
        model.addAttribute("mascotaDto", new Mascota());
        return "form";
    }

    @PostMapping("mascota/new/submit")
    public String nuevaMascotaSubmit(@ModelAttribute("mascotaDto") Mascota nuevaMascota) {
        servicio.add(nuevaMascota);
        return "redirect:/mascota/list";
    }

    @GetMapping("/mascota/edit/{id}")
    public String editarMascotaForm(@PathVariable long id, Model model) {

        Mascota mascota = servicio.findById(id);
        if (mascota != null) {
            model.addAttribute("mascotaDto", mascota);
            return "form";
        } else {
            return "redirect:/mascota/new";
        }
    }

    @PostMapping("/mascota/edit/submit")
    public String editarMascotaSubmit(@ModelAttribute("mascotaDto") Mascota mascota) {
        servicio.edit(mascota);
        return "redirect:/mascota/list";
    }
}