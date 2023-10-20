package anderk222.cine.entity;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import com.google.gson.annotations.Expose;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Entity
@Data
@SQLDelete(sql="UPDATE sala_cine SET deleted='true'")
@Where(clause="deleted=false")
public class SalaCine {

    @Expose
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Expose
    @Column(nullable = false, length = 100, unique = true)
    private String nombre;
    
    @Expose
    @Column(nullable = false)
    @Enumerated(EnumType.ORDINAL)
    private EstadoSala estado = EstadoSala.CASI_VACIA;


    @Expose
    @OneToOne()
    @JoinColumn(name = "id", referencedColumnName = "id_sala")
    private PeliculaSala peliculaSala;

    @Expose
    private boolean deleted = false;
    
}
