package anderk222.cine.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import anderk222.cine.entity.Pelicula;

public interface PeliculaRepository extends JpaRepository<Pelicula, Long> {

    List<Pelicula> countByPeliculaSalaFechaFin(LocalDate localDate);
    List<Pelicula> countByPeliculaSalaFechaPublicacion(LocalDate localDate);
    List<Pelicula> findByNombreContainingIgnoreCase(String value);
    List<Pelicula> findByPeliculaSalaSalaNombre(String sala);
    

    List<Pelicula> findByPeliculaSalaFechaPublicacion(LocalDate date);
}