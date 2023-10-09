package es.danielpr.demo4formularios2.servicios;

import es.danielpr.demo4formularios2.entidades.Mascota;
import es.danielpr.demo4formularios2.entidades.TipoMascota;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Slf4j
@Service
public class MascotaService {
    private List<Mascota> repositorio = new ArrayList<>();

    public List<Mascota> findAll() {
        return repositorio;
    }

    public Mascota add(Mascota m) {
        repositorio.add(m);
        return m;
    }

    public Mascota findById(Long id) {
        Mascota mascota = repositorio.stream()
                .filter(m -> id.equals(m.getId()))
                .findAny()
                .orElse(null);
        return mascota;
    }

    public Mascota edit(Mascota m) {
        log.info("Editando mascota {}", m);
        Mascota mascota = findById(m.getId());
        log.info("Mascota encontrada {}", mascota);

        if (mascota != null) {
            repositorio.set(repositorio.indexOf(mascota), m);
        } else {
            repositorio.add(m);
        }

        return m;

    }

    public void delete(Mascota m) {
        repositorio.remove(m);
    }


    @PostConstruct
    public void init() {
        repositorio.addAll(
            Arrays.asList(
                Mascota.builder()
                        .id(1L)
                        .numChip(12345L)
                        .nombre("boston")
                        .fechaNacimiento(LocalDate.of(2020, 1, 10))
                        .tipo(TipoMascota.GATO)
                        .vacunada(true)
                        .build(),

                new Mascota (2L, "morty",
                    LocalDate.of(2017, 12, 1),
                 12346L,
                    TipoMascota.PERRO,false
                ),
                new Mascota (3L, "rick",
                        LocalDate.of(2014, 3, 8),
                        12347L,
                        TipoMascota.PERRO, false
                )
            ));

    }



}
