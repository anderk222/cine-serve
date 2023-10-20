package anderk222.cine.repository;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;

import anderk222.cine.entity.PeliculaSala;

public interface PeliculaSalaRepository extends JpaRepository<PeliculaSala, Long> {

    int countByFechaFin(LocalDate date);

}