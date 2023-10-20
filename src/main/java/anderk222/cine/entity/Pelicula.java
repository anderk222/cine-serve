package anderk222.cine.entity;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import com.google.gson.annotations.Expose;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Entity
@Data
@SQLDelete(sql = "UPDATE pelicula SET deleted='true' WHERE id=?")
@Where(clause = "deleted=false")
public class Pelicula {
    
    @Expose
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    @Expose
    @Column(nullable = false, length = 200)
    private String nombre;
    
    @Expose
    @Column(nullable = false)
    private int  duracion;

    @OneToOne()
    @JoinColumn(name = "id", referencedColumnName = "id_pelicula")
    private PeliculaSala peliculaSala;

    private boolean deleted = false;
}
