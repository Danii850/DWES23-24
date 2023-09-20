package es.danielpr.demo3formularios.entidades;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Mascota {

    private Long id;
    private String nombre;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private LocalDate fechaNac;
    private Long numChip;
    private TipoMascota tipo;
}