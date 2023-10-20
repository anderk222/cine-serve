package anderk222.cine.repository;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import anderk222.cine.entity.SalaCine;

public interface SalaCineRepository extends JpaRepository<SalaCine, Long> {

    Optional<SalaCine> findByNombre(String nombre);

    int countByPeliculaSalaFechaFin(LocalDate date);
    int countByPeliculaSalaIdAndPeliculaSalaFechaFinLessThan(long id,LocalDate date);

}