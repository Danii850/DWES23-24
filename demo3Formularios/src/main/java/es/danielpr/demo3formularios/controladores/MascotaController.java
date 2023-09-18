package es.danielpr.demo3formularios.controladores;

import es.danielpr.demo3formularios.entidades.Mascota;
import es.danielpr.demo3formularios.servicios.MascotaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

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
        model.addAttribute("mascotaDto", new Mascota());
        return "form";
    }

    @PostMapping("mascota/new/submit")
    public String nuevaMascotaSubmit(@ModelAttribute("mascotaDto") Mascota nuevaMascota) {
        servicio.add(nuevaMascota);
        return "redirect:/mascota/list";
    }
}
