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
import anderk222.cine.entity.PeliculaSala;
import anderk222.cine.service.PeliculaSalaService;
import anderk222.cine.validation.JsonValid;

import static anderk222.cine.validation.SchemaLocations.ID;


@RestController
@RequestMapping("/api/cine/peliculaSala")
@CrossOrigin("*")
public class PeliculaSalaController {

    @Autowired
    PeliculaSalaService service;

    @GetMapping()
    public Response findAll() {

        return Response.body(service.findAll());

    }

    @PostMapping("/find")
    public Response find(@RequestBody @JsonValid(ID) Identificator data) {

        return Response.body(service.find(data.getId()));
    }


    @PostMapping()
    public Response save(@RequestBody PeliculaSala pelicula) {

        return Response.body(service.save(pelicula));

    }

    @PostMapping("/update")
    public Response update(@RequestBody PeliculaSala pelicula) {


        return Response.body(service.save(pelicula));

    }

    @PostMapping("/delete")
    public Response delete(@RequestBody @JsonValid(ID) long id) {

        return Response.body(service.delete(id));
    }

}
