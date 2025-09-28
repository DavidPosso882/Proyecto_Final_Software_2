package co.edu.uniquindio.application.models.entitys;


import co.edu.uniquindio.application.models.enums.Estado;
import co.edu.uniquindio.application.models.enums.Servicio;
import co.edu.uniquindio.application.models.vo.Direccion;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Alojamiento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 150)
    private String titulo;

    @Column(nullable = false,  length = 2000)
    private String descripcion;

    @Embedded
    @AttributeOverrides({
        @AttributeOverride(name = "ciudad", column = @Column(name = "ciudad", nullable = false)),
        @AttributeOverride(name = "direccion", column = @Column(name = "direccion", nullable = false)),
        @AttributeOverride(name = "ubicacion.latitud", column = @Column(name = "latitud", nullable = false)),
        @AttributeOverride(name = "ubicacion.longitud", column = @Column(name = "longitud", nullable = false))
    })
    private Direccion direccion;

    @Column(nullable = false,  length = 3)
    private Integer maxHuespedes;

    @Column(nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime creadoEn;

    @Column(nullable = false,  length = 20)
    private Float precioPorNoche;

    @ElementCollection
    @CollectionTable(name = "alojamiento_imagenes",
                     joinColumns = @JoinColumn(name = "alojamiento_id"))
    @Column(name = "imagen_url", nullable = false)
    private List<String> imagenes;

    @Enumerated(EnumType.STRING)
    private Estado estado;

    @ElementCollection
    private Set<Servicio> servicios;

    @ManyToOne
    @JoinColumn(name = "anfitrion_id", nullable = false)
    @JsonIgnore
    private Usuario anfitrion;

    @OneToMany(mappedBy = "alojamiento")
    @JsonIgnore
    private List<Reserva> reservas;

    @OneToMany(mappedBy = "alojamiento")
    @JsonIgnore
    private List<Resena> resenas;

}
