package es.danielpr.demo2parametros.entidades;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.time.LocalDate;

@Data
@AllArgsConstructor
public class Mascota {

    private String nombre;
    private LocalDate fechaNac;
    private Long numChip;
    private TipoMascota tipo;
}