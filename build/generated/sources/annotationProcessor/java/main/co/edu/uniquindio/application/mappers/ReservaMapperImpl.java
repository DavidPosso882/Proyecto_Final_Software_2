package co.edu.uniquindio.application.mappers;

import co.edu.uniquindio.application.dtos.alojamiento.AlojamientoDTO;
import co.edu.uniquindio.application.dtos.alojamiento.DireccionDTO;
import co.edu.uniquindio.application.dtos.alojamiento.ItemAlojamientoDTO;
import co.edu.uniquindio.application.dtos.alojamiento.LocalizacionDTO;
import co.edu.uniquindio.application.dtos.reserva.CreacionReservaDTO;
import co.edu.uniquindio.application.dtos.reserva.ItemReservaDTO;
import co.edu.uniquindio.application.dtos.reserva.ReservaDTO;
import co.edu.uniquindio.application.dtos.usuario.UsuarioDTO;
import co.edu.uniquindio.application.models.entitys.Alojamiento;
import co.edu.uniquindio.application.models.entitys.Reserva;
import co.edu.uniquindio.application.models.enums.ReservaEstado;
import co.edu.uniquindio.application.models.enums.Servicio;
import co.edu.uniquindio.application.models.vo.Direccion;
import java.time.LocalDate;
import java.util.ArrayList;
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
public class ReservaMapperImpl implements ReservaMapper {

    @Override
    public Reserva toEntity(CreacionReservaDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Reserva.ReservaBuilder reserva = Reserva.builder();

        reserva.fechaEntrada( dto.fechaEntrada() );
        reserva.fechaSalida( dto.fechaSalida() );

        return reserva.build();
    }

    @Override
    public ItemReservaDTO toItemDTO(Reserva entity) {
        if ( entity == null ) {
            return null;
        }

        Long id = null;
        ItemAlojamientoDTO alojamiento = null;
        LocalDate fechaEntrada = null;
        LocalDate fechaSalida = null;
        ReservaEstado estado = null;

        id = entity.getId();
        alojamiento = alojamientoToItemAlojamientoDTO( entity.getAlojamiento() );
        fechaEntrada = entity.getFechaEntrada();
        fechaSalida = entity.getFechaSalida();
        estado = entity.getEstado();

        ItemReservaDTO itemReservaDTO = new ItemReservaDTO( id, alojamiento, fechaEntrada, fechaSalida, estado );

        return itemReservaDTO;
    }

    @Override
    public ReservaDTO toDTO(Reserva entity) {
        if ( entity == null ) {
            return null;
        }

        Long id = null;
        AlojamientoDTO alojamiento = null;
        LocalDate fechaEntrada = null;
        LocalDate fechaSalida = null;
        ReservaEstado estado = null;

        id = entity.getId();
        alojamiento = alojamientoToAlojamientoDTO( entity.getAlojamiento() );
        fechaEntrada = entity.getFechaEntrada();
        fechaSalida = entity.getFechaSalida();
        estado = entity.getEstado();

        UsuarioDTO usuario = null;
        Integer numeroHuespedes = null;

        ReservaDTO reservaDTO = new ReservaDTO( id, alojamiento, usuario, fechaEntrada, fechaSalida, numeroHuespedes, estado );

        return reservaDTO;
    }

    @Override
    public void updateFromDto(CreacionReservaDTO dto, Reserva entity) {
        if ( dto == null ) {
            return;
        }

        entity.setFechaEntrada( dto.fechaEntrada() );
        entity.setFechaSalida( dto.fechaSalida() );
    }

    protected ItemAlojamientoDTO alojamientoToItemAlojamientoDTO(Alojamiento alojamiento) {
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

    protected AlojamientoDTO alojamientoToAlojamientoDTO(Alojamiento alojamiento) {
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
}
