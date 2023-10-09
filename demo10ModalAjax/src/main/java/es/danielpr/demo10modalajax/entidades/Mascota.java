package es.danielpr.demo10modalajax.entidades;

import jakarta.validation.constraints.*;
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
    @Min(value=1, message = "{mascota.id.mayorquecero}")
    private Long id;
    @NotEmpty
    private String nombre;
    @Past
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private LocalDate fechaNacimiento;
    private Long numChip;
    @NotNull( message = "el tipo debe ir rellenado")
    private TipoMascota tipo;
    private boolean vacunada;

}
