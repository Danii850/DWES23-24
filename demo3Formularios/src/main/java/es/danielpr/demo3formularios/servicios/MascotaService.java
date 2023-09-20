package es.danielpr.demo3formularios.servicios;

import es.danielpr.demo3formularios.entidades.Mascota;
import es.danielpr.demo3formularios.entidades.TipoMascota;
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

    public void delete(Mascota m) {
        repositorio.remove(m);
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
//        if (mascota != null) {
//            repositorio.remove(mascota);
//            repositorio.add(m);
//        } else {
//            repositorio.add(m);
//        }

        if (mascota != null) {
            repositorio.set(repositorio.indexOf(mascota), m);
        } else {
            repositorio.add(m);
        }
        return m;
    }

    @PostConstruct
    public void init() {
        repositorio.addAll(
                Arrays.asList(
                        new Mascota(1L, "Luci",
                                LocalDate.of(2021, 2, 14),
                                17342L,
                                TipoMascota.PERRO),
                        new Mascota(2L, "Ricky",
                                LocalDate.of(2020, 1, 12),
                                51244L,
                                TipoMascota.PERRO),
                        new Mascota(3L, "Morty",
                                LocalDate.of(2019, 3, 30),
                                48273L,
                                TipoMascota.PERRO)
                )
        );
    }
}
