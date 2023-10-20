package anderk222.cine.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import anderk222.cine.dto.Identificator;
import anderk222.cine.dto.Response;
import anderk222.cine.entity.Pelicula;
import anderk222.cine.service.PeliculaService;
import anderk222.cine.validation.JsonValid;

import static anderk222.cine.validation.SchemaLocations.ID;

import java.time.LocalDate;
import java.util.Map;

@RestController
@RequestMapping("/api/cine/pelicula")
@CrossOrigin("*")
public class PeliculaController {

    @Autowired
    PeliculaService service;

    @GetMapping()
    public Response findAll() {

        return Response.body(service.findAll());

    }

    @PostMapping("/find")
    public Response find(@RequestBody @JsonValid(ID) Identificator data) {

        return Response.body(service.find(data.getId()));
    }

    @PostMapping("/findByName")
    public Response findByName(@RequestBody Map<String, String> data) {

        return Response.body(service.findByName(data.get("nombre")));

    }

    @PostMapping("/findByFechaPublicacion")
    public Response findByFechaPublicacion(@RequestBody Map<String, LocalDate> data) {

        return Response.body(service.findByFechaPublicacion(data.get("date")));

    }

    @PostMapping("/findBySala")
    public Response findBySala(@RequestBody Map<String, String> data) {

        return Response.body(service.findBySala(data.get("nombre")));

    }

    @PostMapping()
    public Response save(@RequestBody Pelicula pelicula) {

        return Response.body(service.save(pelicula));

    }

    @PostMapping("/update")
    public Response update(@RequestBody Pelicula pelicula) {

        return Response.body(service.save(pelicula));

    }

    @PostMapping("/delete")
    public Response delete(@RequestBody @JsonValid(ID) Identificator data) {

        return Response.body(service.delete(data.getId()));
    }

}
