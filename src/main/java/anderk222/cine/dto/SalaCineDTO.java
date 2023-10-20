package anderk222.cine.dto;

import com.google.gson.annotations.Expose;

import anderk222.cine.entity.EstadoSala;
import anderk222.cine.entity.PeliculaSala;
import anderk222.cine.entity.SalaCine;
import lombok.Data;

@Data
public class SalaCineDTO {

    @Expose
    private Long id;

    @Expose
    private String nombre;

    @Expose
    private EstadoSala estado = EstadoSala.CASI_VACIA;


    public SalaCineDTO(SalaCine sala){

        this.id = sala.getId();
        this.nombre = sala.getNombre();
        this.estado = sala.getEstado();
        
    }

    public SalaCineDTO estadoSala(int count){

        this.estado = (count < 3 ? EstadoSala.CASI_VACIA : count > 5 ? EstadoSala.OCUPADA : EstadoSala.CASI_LLENA);

        return this;

    }

}
