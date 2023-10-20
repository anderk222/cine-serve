package anderk222.cine.service;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import anderk222.cine.entity.Pelicula;
import anderk222.cine.exception.ResourceNotFoundException;
import anderk222.cine.repository.PeliculaRepository;

@Service
public class PeliculaService {

    @Autowired
    PeliculaRepository repository;

    public List<Pelicula> findAll(){

        return repository.findAll();

    }

    //
    public Map<String, Object> findByFechaPublicacion(LocalDate date){

        Map<String, Object> res = new HashMap<>();

        List<Pelicula> peliculas = repository.findByPeliculaSalaFechaPublicacion(date);

        res.put("totalPublicaciones", peliculas.size());

        res.put("peliculas", peliculas);

        return res;

    }

    //
    public List<Pelicula> findBySala(String sala){

        return repository.findByPeliculaSalaSalaNombre(sala);

    }

    public Pelicula find(long id) {

        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(id, "id", "pelicula"));
    }

    public List<Pelicula> findByName(String nombre){

        return repository.findByNombreContainingIgnoreCase(nombre);

    }

    public Pelicula save(Pelicula pelicula) {

        return repository.save(pelicula);

    }

    public Pelicula update(Pelicula pelicula){

        this.find(pelicula.getId());

        return repository.save(pelicula);

    }

    public Pelicula delete(long id){


        Pelicula pelicula = this.find(id);

        repository.deleteById(id);

        return pelicula;

    }

}
