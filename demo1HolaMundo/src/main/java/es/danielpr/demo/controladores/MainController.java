package es.danielpr.demo.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

  private String mensaje = "Mundo";

  @GetMapping("/")
  public String saludo(Model model) {
    model.addAttribute("mensaje", mensaje);

    return "saludo"; //vista
  }

  // /hola2?miNombre=kotlin
  @GetMapping("/hola")
  public String saludoConParam(
    @RequestParam(name = "miNombre", required = false, defaultValue = "")
    String nombre, Model model) {

    model.addAttribute("mensaje", nombre);

    return "saludo"; //vista
  }

}
