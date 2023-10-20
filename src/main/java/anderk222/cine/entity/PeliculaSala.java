package anderk222.cine.entity;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.annotations.SQLDelete;

import com.google.gson.annotations.Expose;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Entity
@Data
@SQLDelete(sql = "UPDATE pelicula_sala SET deleted='true'")
public class PeliculaSala {

    @Expose
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    @Expose
    @Column(columnDefinition = "DATE")
    private LocalDate fechaPublicacion = LocalDate.now();

    @Expose
    @Column(columnDefinition = "DATE")
    private LocalDate fechaFin;

    // @OneToOne(fetch = FetchType.LAZY)
    // @JoinColumn(name = "id_pelicula", referencedColumnName = "id")
    // private Set<Pelicula> pelicula = new HashSet<>();

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "peliculaSala")
    private SalaCine sala;

    private boolean deleted = false;

}
