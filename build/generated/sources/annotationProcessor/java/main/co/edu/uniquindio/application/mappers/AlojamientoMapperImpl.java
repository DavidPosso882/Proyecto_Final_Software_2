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
    date = "2025-10-06T23:42:03-0500",
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

        alojamiento.estado( Estado.ACTIVO );
        alojamiento.creadoEn( java.time.LocalDateTime.now() );

        return alojamiento.build();
    }

    @Override
    public ItemAlojamientoDTO toItemDTO(Alojamiento alojamiento) {
        if ( alojamiento == null ) {
            return null;
        }

        Long id = null;
        String titulo = null;
        Double precioPorNoche = null;
        DireccionDTO direccion = null;
        Double promedioCalificaciones = null;

        id = alojamiento.getId();
        titulo = alojamiento.getTitulo();
        if ( alojamiento.getPrecioPorNoche() != null ) {
            precioPorNoche = alojamiento.getPrecioPorNoche().doubleValue();
        }
        direccion = direccionToDireccionDTO( alojamiento.getDireccion() );
        promedioCalificaciones = alojamiento.getPromedioCalificaciones();

        String imagenPrincipal = getImagenPrincipal(alojamiento.getImagenes());

        ItemAlojamientoDTO itemAlojamientoDTO = new ItemAlojamientoDTO( id, titulo, imagenPrincipal, precioPorNoche, direccion, promedioCalificaciones );

        return itemAlojamientoDTO;
    }

    @Override
    public AlojamientoDTO toDTO(Alojamiento alojamiento) {
        if ( alojamiento == null ) {
            return null;
        }

        Long id = null;
        String titulo = null;
        String descripcion = null;
        DireccionDTO direccion = null;
        Float precioPorNoche = null;
        Integer maxHuespedes = null;
        List<Servicio> servicios = null;
        List<String> imagenes = null;

        id = alojamiento.getId();
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

        String nombreAnfitrion = alojamiento.getAnfitrion().getNombre();

        AlojamientoDTO alojamientoDTO = new AlojamientoDTO( id, titulo, descripcion, direccion, precioPorNoche, maxHuespedes, servicios, imagenes, nombreAnfitrion );

        return alojamientoDTO;
    }

    @Override
    public void updateAlojamientoFromDto(EdicionAlojamientoDTO edicionAlojamientoDTO, Alojamiento alojamiento) {
        if ( edicionAlojamientoDTO == null ) {
            return;
        }

        alojamiento.setTitulo( edicionAlojamientoDTO.titulo() );
        alojamiento.setDescripcion( edicionAlojamientoDTO.descripcion() );
        if ( edicionAlojamientoDTO.direccion() != null ) {
            if ( alojamiento.getDireccion() == null ) {
                alojamiento.setDireccion( new Direccion() );
            }
            direccionDTOToDireccion1( edicionAlojamientoDTO.direccion(), alojamiento.getDireccion() );
        }
        else {
            alojamiento.setDireccion( null );
        }
        alojamiento.setMaxHuespedes( edicionAlojamientoDTO.maxHuespedes() );
        alojamiento.setPrecioPorNoche( edicionAlojamientoDTO.precioPorNoche() );
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
        direccion.setLocalizacion( localizacionDTOToLocalizacion( direccionDTO.localizacion() ) );

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

        String ciudad = null;
        String direccion1 = null;
        LocalizacionDTO localizacion = null;

        ciudad = direccion.getCiudad();
        direccion1 = direccion.getDireccion();
        localizacion = localizacionToLocalizacionDTO( direccion.getLocalizacion() );

        DireccionDTO direccionDTO = new DireccionDTO( ciudad, direccion1, localizacion );

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
        if ( direccionDTO.localizacion() != null ) {
            if ( mappingTarget.getLocalizacion() == null ) {
                mappingTarget.setLocalizacion( new Localizacion() );
            }
            localizacionDTOToLocalizacion1( direccionDTO.localizacion(), mappingTarget.getLocalizacion() );
        }
        else {
            mappingTarget.setLocalizacion( null );
        }
    }
}
