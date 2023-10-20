package anderk222.cine.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import anderk222.cine.entity.PeliculaSala;
import anderk222.cine.exception.ResourceNotFoundException;
import anderk222.cine.repository.PeliculaSalaRepository;

@Service
public class PeliculaSalaService {

    @Autowired
    PeliculaSalaRepository repository;

    public List<PeliculaSala> findAll() {

        return repository.findAll();

    }

    public PeliculaSala find(long id) {

        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(id, "id", "peliculaSala"));
    }



    public PeliculaSala save(PeliculaSala peliculaSala) {

        return repository.save(peliculaSala);

    }

    public PeliculaSala update(PeliculaSala peliculaSala) {

        this.find(peliculaSala.getId());

        return repository.save(peliculaSala);

    }

    public PeliculaSala delete(long id) {

        PeliculaSala peliculaSala = this.find(id);

        repository.deleteById(id);

        return peliculaSala;

    }

}
