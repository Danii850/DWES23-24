package es.danielpr.demo7internacional.entidades;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Past;
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
    private TipoMascota tipo;
    private boolean vacunada;

}
