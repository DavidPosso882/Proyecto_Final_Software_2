package co.edu.uniquindio.application.mappers;

import co.edu.uniquindio.application.dtos.alojamiento.AlojamientoDTO;
import co.edu.uniquindio.application.dtos.alojamiento.CreacionAlojamientoDTO;
import co.edu.uniquindio.application.dtos.alojamiento.DireccionDTO;
import co.edu.uniquindio.application.dtos.alojamiento.EdicionAlojamientoDTO;
import co.edu.uniquindio.application.dtos.alojamiento.ItemAlojamientoDTO;
import co.edu.uniquindio.application.dtos.alojamiento.LocalizacionDTO;
import co.edu.uniquindio.application.models.entitys.Alojamiento;
import co.edu.uniquindio.application.models.enums.Servicio;
import co.edu.uniquindio.application.models.vo.Direccion;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-09-26T00:29:41-0500",
    comments = "version: 1.6.3, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.14.jar, environment: Java 21.0.8 (Ubuntu)"
)
@Component
public class AlojamientoMapperImpl implements AlojamientoMapper {

    @Override
    public Alojamiento toEntity(CreacionAlojamientoDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Alojamiento.AlojamientoBuilder alojamiento = Alojamiento.builder();

        alojamiento.titulo( dto.titulo() );
        alojamiento.descripcion( dto.descripcion() );
        List<String> list = dto.imagenes();
        if ( list != null ) {
            alojamiento.imagenes( new ArrayList<String>( list ) );
        }
        List<Servicio> list1 = dto.servicios();
        if ( list1 != null ) {
            alojamiento.servicios( new LinkedHashSet<Servicio>( list1 ) );
        }

        return alojamiento.build();
    }

    @Override
    public ItemAlojamientoDTO toItemDTO(Alojamiento alojamiento) {
        if ( alojamiento == null ) {
            return null;
        }

        Long id = null;
        String titulo = null;

        id = alojamiento.getId();
        titulo = alojamiento.getTitulo();

        String imagenPrincipal = null;
        Float precioNoche = null;
        DireccionDTO ubicacion = null;
        Float promedioCalificaciones = null;
        Integer capacidad = null;

        ItemAlojamientoDTO itemAlojamientoDTO = new ItemAlojamientoDTO( id, titulo, imagenPrincipal, precioNoche, ubicacion, promedioCalificaciones, capacidad );

        return itemAlojamientoDTO;
    }

    @Override
    public AlojamientoDTO toDTO(Alojamiento alojamiento) {
        if ( alojamiento == null ) {
            return null;
        }

        String titulo = null;
        String descripcion = null;
        DireccionDTO direccion = null;
        Float precioPorNoche = null;
        Integer maxHuespedes = null;
        List<Servicio> servicios = null;
        List<String> imagenes = null;

        titulo = alojamiento.getTitulo();
        descripcion = alojamiento.getDescripcion();
        direccion = direccionToDireccionDTO( alojamiento.getDireccion() );
        precioPorNoche = alojamiento.getPrecioPorNoche();
        maxHuespedes = alojamiento.getMaxHuespedes();
        Set<Servicio> set = alojamiento.getServicios();
        if ( set != null ) {
            servicios = new ArrayList<Servicio>( set );
        }
        List<String> list = alojamiento.getImagenes();
        if ( list != null ) {
            imagenes = new ArrayList<String>( list );
        }

        Integer imagenPrincipal = null;

        AlojamientoDTO alojamientoDTO = new AlojamientoDTO( titulo, descripcion, direccion, precioPorNoche, maxHuespedes, servicios, imagenes, imagenPrincipal );

        return alojamientoDTO;
    }

    @Override
    public void updateAlojamientoFromDto(EdicionAlojamientoDTO edicionAlojamientoDTO, Alojamiento alojamiento) {
        if ( edicionAlojamientoDTO == null ) {
            return;
        }

        alojamiento.setTitulo( edicionAlojamientoDTO.titulo() );
        alojamiento.setDescripcion( edicionAlojamientoDTO.descripcion() );
        if ( alojamiento.getImagenes() != null ) {
            List<String> list = edicionAlojamientoDTO.imagenes();
            if ( list != null ) {
                alojamiento.getImagenes().clear();
                alojamiento.getImagenes().addAll( list );
            }
            else {
                alojamiento.setImagenes( null );
            }
        }
        else {
            List<String> list = edicionAlojamientoDTO.imagenes();
            if ( list != null ) {
                alojamiento.setImagenes( new ArrayList<String>( list ) );
            }
        }
        if ( alojamiento.getServicios() != null ) {
            List<Servicio> list1 = edicionAlojamientoDTO.servicios();
            if ( list1 != null ) {
                alojamiento.getServicios().clear();
                alojamiento.getServicios().addAll( list1 );
            }
            else {
                alojamiento.setServicios( null );
            }
        }
        else {
            List<Servicio> list1 = edicionAlojamientoDTO.servicios();
            if ( list1 != null ) {
                alojamiento.setServicios( new LinkedHashSet<Servicio>( list1 ) );
            }
        }
    }

    protected DireccionDTO direccionToDireccionDTO(Direccion direccion) {
        if ( direccion == null ) {
            return null;
        }

        String ciudad = null;
        String direccion1 = null;

        ciudad = direccion.getCiudad();
        direccion1 = direccion.getDireccion();

        LocalizacionDTO coordenadas = null;

        DireccionDTO direccionDTO = new DireccionDTO( ciudad, direccion1, coordenadas );

        return direccionDTO;
    }
}
