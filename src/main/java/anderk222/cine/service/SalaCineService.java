package anderk222.cine.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import anderk222.cine.dto.SalaCineDTO;
import anderk222.cine.entity.EstadoSala;
import anderk222.cine.entity.SalaCine;
import anderk222.cine.exception.ResourceNotFoundException;
import anderk222.cine.repository.SalaCineRepository;

@Service
public class SalaCineService {

    @Autowired
    SalaCineRepository repository;

    public List<SalaCine> findAll() {

        return repository.findAll();

    }

    public SalaCine find(long id) {

        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(id, "id", "salaCine"));
    }

    public SalaCineDTO findByName(String nombre) {

        SalaCine salaCine = repository.findByNombre(nombre)
                .orElseThrow(() -> new ResourceNotFoundException(nombre, "nombre", "Sala cine"));

        int count = repository
                .countByPeliculaSalaIdAndPeliculaSalaFechaFinLessThan(salaCine.getId(), LocalDate.now());

        return new SalaCineDTO(salaCine).estadoSala(count);

    }

    public SalaCine save(SalaCine salaCine) {

        return repository.save(salaCine);

    }

    public SalaCine update(SalaCine salaCine) {

        this.find(salaCine.getId());

        return repository.save(salaCine);

    }

    public SalaCine delete(long id) {

        SalaCine salaCine = this.find(id);

        repository.deleteById(id);

        return salaCine;

    }

}
