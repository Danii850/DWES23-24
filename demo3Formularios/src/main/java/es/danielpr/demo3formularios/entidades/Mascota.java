package es.danielpr.demo3formularios.entidades;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Mascota {

    private String nombre;
    private LocalDate fechaNac;
    private Long numChip;
    private TipoMascota tipo;
}