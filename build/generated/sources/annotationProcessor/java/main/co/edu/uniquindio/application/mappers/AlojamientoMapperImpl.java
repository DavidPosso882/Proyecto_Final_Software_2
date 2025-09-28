package co.edu.uniquindio.application.mappers;

import co.edu.uniquindio.application.dtos.alojamiento.AlojamientoDTO;
import co.edu.uniquindio.application.dtos.alojamiento.CreacionAlojamientoDTO;
import co.edu.uniquindio.application.dtos.alojamiento.DireccionDTO;
import co.edu.uniquindio.application.dtos.alojamiento.EdicionAlojamientoDTO;
import co.edu.uniquindio.application.dtos.alojamiento.ItemAlojamientoDTO;
import co.edu.uniquindio.application.dtos.alojamiento.LocalizacionDTO;
import co.edu.uniquindio.application.models.entitys.Alojamiento;
import co.edu.uniquindio.application.models.enums.Estado;
import co.edu.uniquindio.application.models.enums.Servicio;
import co.edu.uniquindio.application.models.vo.Direccion;
import co.edu.uniquindio.application.models.vo.Localizacion;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-09-27T18:42:29-0500",
    comments = "version: 1.6.3, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.14.jar, environment: Java 21.0.8 (Eclipse Adoptium)"
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
        alojamiento.direccion( direccionDTOToDireccion( dto.direccion() ) );
        alojamiento.maxHuespedes( dto.maxHuespedes() );
        alojamiento.precioPorNoche( dto.precioPorNoche() );
        List<String> list = dto.imagenes();
        if ( list != null ) {
            alojamiento.imagenes( new ArrayList<String>( list ) );
        }
        List<Servicio> list1 = dto.servicios();
        if ( list1 != null ) {
            alojamiento.servicios( new LinkedHashSet<Servicio>( list1 ) );
        }

        alojamiento.creadoEn( java.time.LocalDateTime.now() );
        alojamiento.estado( Estado.ACTIVO );

        return alojamiento.build();
    }

    @Override
    public ItemAlojamientoDTO toItemDTO(Alojamiento alojamiento) {
        if ( alojamiento == null ) {
            return null;
        }

        DireccionDTO ubicacion = null;
        Float precioNoche = null;
        Integer capacidad = null;
        Long id = null;
        String titulo = null;

        ubicacion = direccionToDireccionDTO( alojamiento.getDireccion() );
        precioNoche = alojamiento.getPrecioPorNoche();
        capacidad = alojamiento.getMaxHuespedes();
        id = alojamiento.getId();
        titulo = alojamiento.getTitulo();

        String imagenPrincipal = alojamiento.getImagenes() != null && !alojamiento.getImagenes().isEmpty() ? alojamiento.getImagenes().get(0) : null;
        Float promedioCalificaciones = null;

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
        direccion = direccionToDireccionDTO1( alojamiento.getDireccion() );
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

        Integer imagenPrincipal = alojamiento.getImagenes() != null && !alojamiento.getImagenes().isEmpty() ? 0 : null;

        AlojamientoDTO alojamientoDTO = new AlojamientoDTO( titulo, descripcion, direccion, precioPorNoche, maxHuespedes, servicios, imagenes, imagenPrincipal );

        return alojamientoDTO;
    }

    @Override
    public void updateAlojamientoFromDto(EdicionAlojamientoDTO edicionAlojamientoDTO, Alojamiento alojamiento) {
        if ( edicionAlojamientoDTO == null ) {
            return;
        }

        if ( edicionAlojamientoDTO.precioNoche() != null ) {
            alojamiento.setPrecioPorNoche( edicionAlojamientoDTO.precioNoche() );
        }
        if ( edicionAlojamientoDTO.capacidad() != null ) {
            alojamiento.setMaxHuespedes( edicionAlojamientoDTO.capacidad() );
        }
        if ( edicionAlojamientoDTO.ubicacion() != null ) {
            if ( alojamiento.getDireccion() == null ) {
                alojamiento.setDireccion( new Direccion() );
            }
            direccionDTOToDireccion1( edicionAlojamientoDTO.ubicacion(), alojamiento.getDireccion() );
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

    protected Localizacion localizacionDTOToLocalizacion(LocalizacionDTO localizacionDTO) {
        if ( localizacionDTO == null ) {
            return null;
        }

        Localizacion localizacion = new Localizacion();

        if ( localizacionDTO.latitud() != null ) {
            localizacion.setLatitud( localizacionDTO.latitud().floatValue() );
        }
        if ( localizacionDTO.longitud() != null ) {
            localizacion.setLongitud( localizacionDTO.longitud().floatValue() );
        }

        return localizacion;
    }

    protected Direccion direccionDTOToDireccion(DireccionDTO direccionDTO) {
        if ( direccionDTO == null ) {
            return null;
        }

        Direccion direccion = new Direccion();

        direccion.setCiudad( direccionDTO.ciudad() );
        direccion.setDireccion( direccionDTO.direccion() );
        direccion.setUbicacion( localizacionDTOToLocalizacion( direccionDTO.ubicacion() ) );

        return direccion;
    }

    protected LocalizacionDTO localizacionToLocalizacionDTO(Localizacion localizacion) {
        if ( localizacion == null ) {
            return null;
        }

        Double latitud = null;
        Double longitud = null;

        latitud = (double) localizacion.getLatitud();
        longitud = (double) localizacion.getLongitud();

        LocalizacionDTO localizacionDTO = new LocalizacionDTO( latitud, longitud );

        return localizacionDTO;
    }

    protected DireccionDTO direccionToDireccionDTO(Direccion direccion) {
        if ( direccion == null ) {
            return null;
        }

        LocalizacionDTO ubicacion = null;
        String ciudad = null;
        String direccion1 = null;

        ubicacion = localizacionToLocalizacionDTO( direccion.getUbicacion() );
        ciudad = direccion.getCiudad();
        direccion1 = direccion.getDireccion();

        DireccionDTO direccionDTO = new DireccionDTO( ciudad, direccion1, ubicacion );

        return direccionDTO;
    }

    protected LocalizacionDTO localizacionToLocalizacionDTO1(Localizacion localizacion) {
        if ( localizacion == null ) {
            return null;
        }

        Double latitud = null;
        Double longitud = null;

        latitud = (double) localizacion.getLatitud();
        longitud = (double) localizacion.getLongitud();

        LocalizacionDTO localizacionDTO = new LocalizacionDTO( latitud, longitud );

        return localizacionDTO;
    }

    protected DireccionDTO direccionToDireccionDTO1(Direccion direccion) {
        if ( direccion == null ) {
            return null;
        }

        String ciudad = null;
        String direccion1 = null;
        LocalizacionDTO ubicacion = null;

        ciudad = direccion.getCiudad();
        direccion1 = direccion.getDireccion();
        ubicacion = localizacionToLocalizacionDTO1( direccion.getUbicacion() );

        DireccionDTO direccionDTO = new DireccionDTO( ciudad, direccion1, ubicacion );

        return direccionDTO;
    }

    protected void localizacionDTOToLocalizacion1(LocalizacionDTO localizacionDTO, Localizacion mappingTarget) {
        if ( localizacionDTO == null ) {
            return;
        }

        if ( localizacionDTO.latitud() != null ) {
            mappingTarget.setLatitud( localizacionDTO.latitud().floatValue() );
        }
        if ( localizacionDTO.longitud() != null ) {
            mappingTarget.setLongitud( localizacionDTO.longitud().floatValue() );
        }
    }

    protected void direccionDTOToDireccion1(DireccionDTO direccionDTO, Direccion mappingTarget) {
        if ( direccionDTO == null ) {
            return;
        }

        mappingTarget.setCiudad( direccionDTO.ciudad() );
        mappingTarget.setDireccion( direccionDTO.direccion() );
        if ( direccionDTO.ubicacion() != null ) {
            if ( mappingTarget.getUbicacion() == null ) {
                mappingTarget.setUbicacion( new Localizacion() );
            }
            localizacionDTOToLocalizacion1( direccionDTO.ubicacion(), mappingTarget.getUbicacion() );
        }
        else {
            mappingTarget.setUbicacion( null );
        }
    }
}
