package es.danielpr.demo5webjars.entidades;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Mascota {
    private Long id;
    private String nombre;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private LocalDate fechaNacimiento;
    private Long numChip;
    private TipoMascota tipo;
    private boolean vacunada;

}
