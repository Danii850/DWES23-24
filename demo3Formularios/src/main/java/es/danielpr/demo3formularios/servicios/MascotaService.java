package es.danielpr.demo3formularios.servicios;

import es.danielpr.demo3formularios.entidades.Mascota;
import es.danielpr.demo3formularios.entidades.TipoMascota;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class MascotaService {

    private List<Mascota> repositorio = new ArrayList<>();

    public List<Mascota> findAll() {
        return repositorio;
    }

    public Mascota add(Mascota m){
        repositorio.add(m);
        return m;
    }

    @PostConstruct
    public void init() {
        repositorio.addAll(
                Arrays.asList(
                        new Mascota("Luci",
                                LocalDate.of(2021, 2, 14),
                                17342L,
                                TipoMascota.PERRO),
                        new Mascota("Ricky",
                                LocalDate.of(2020, 1, 12),
                                51244L,
                                TipoMascota.PERRO),
                        new Mascota("Morty",
                                LocalDate.of(2019, 3, 30),
                                48273L,
                                TipoMascota.PERRO)
                )
        );
    }
}
