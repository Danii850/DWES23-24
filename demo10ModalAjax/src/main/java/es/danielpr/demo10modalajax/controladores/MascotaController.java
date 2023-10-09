package es.danielpr.demo10modalajax.controladores;

import es.danielpr.demo10modalajax.entidades.Mascota;
import es.danielpr.demo10modalajax.servicios.I18nService;
import es.danielpr.demo10modalajax.servicios.MascotaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

// Para hacer logging
@Slf4j
// Si no queremos usar @Autowired usamos Lombok para inject
@RequiredArgsConstructor
@Controller
public class MascotaController {

    //@Autowired
    private final MascotaService servicio;
    private final I18nService servicioInternacionalizacion;



    @GetMapping({"/", "mascota/list"})
    public String listado(Model model) {
        model.addAttribute("listaMascotas", servicio.findAll() );
        return "list";
    }

    @GetMapping("mascota/new")
    public String nuevaMascota(Model model) {
        log.info("estoy en nuevaMascota");

        model.addAttribute("mascotaDto", new Mascota());
        model.addAttribute("modoEdicion", false);
        return "form";
    }

    @PostMapping("mascota/new/submit")
    //@ModelAtribute equivaldría a esto
    //public String nuevaMascotaSubmit(Mascota nuevaMascota, Model model) {
    //    Mascota nuevaMascota = model.getAttribute("mascotaDto");
    public String nuevaMascotaSubmit(@Valid @ModelAttribute("mascotaDto") Mascota nuevaMascota,
                                     BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("modoEdicion", false);
            return "form";
        } else if (servicio.findById(nuevaMascota.getId()) != null) {
            model.addAttribute("modoEdicion", false);
            bindingResult.rejectValue("id", "id.existente", "ya existe este id");
            return "form";
        } else {
            servicio.add(nuevaMascota);
            return "redirect:/mascota/list";
        }
    }

    @GetMapping("/mascota/edit/{id}")
    public String editarMascotaForm(@PathVariable long id, Model model) {

        Mascota mascota = servicio.findById(id);
        if (mascota != null) {
            model.addAttribute("mascotaDto", mascota);
            model.addAttribute("modoEdicion", true);
            return "form";
        } else {
            return "redirect:/mascota/new";
        }
    }

    @PostMapping("/mascota/edit/submit")
    public String editarMascotaSubmit(@Valid @ModelAttribute("mascotaDto") Mascota mascota,
                                      BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("modoEdicion", true);
            return "form";
        } else {
            servicio.edit(mascota);
            return "redirect:/mascota/list";
        }
    }

  @GetMapping("/mascota/delete/{id}")
  public String borrarMascota(@PathVariable("id") Long id, Model model) {

    Mascota mascota = servicio.findById(id);
    if (mascota != null)
      servicio.delete(mascota);

    return "redirect:/mascota/list";
  }

  /*@GetMapping("mascota/delete/show/{id}")
    public String showModalBorrarMascota(@PathVariable("id") Long id, Model model) {

        Mascota mascota = servicio.findById(id);
        String deleteMessage = "";
        if(mascota != null) {
            deleteMessage = servicioInternacionalizacion.getMessage("mascota.borrar.mensaje"),
                new Object[]{mascota.getNombre()} );
            //deleteMessage = "¿Confirma el borrado de la mascota " + mascota.getId() + " ?";

        } else {
            return "redirect:/mascota/?error=true";
        }
        model.addAttribute("delete_url", "/mascota/delete/" + id);
        model.addAttribute("delete_title",
            servicioInternacionalizacion.getMessage("mascota.borrar.titulo");
        return "fragmentos/delete-modal::modal-borrar";

    }*/
}
