package co.edu.uniquindio.application.mappers;

import co.edu.uniquindio.application.dtos.alojamiento.AlojamientoDTO;
import co.edu.uniquindio.application.dtos.alojamiento.DireccionDTO;
import co.edu.uniquindio.application.dtos.alojamiento.ItemAlojamientoDTO;
import co.edu.uniquindio.application.dtos.reserva.CreacionReservaDTO;
import co.edu.uniquindio.application.dtos.reserva.ItemReservaDTO;
import co.edu.uniquindio.application.dtos.reserva.ReservaDTO;
import co.edu.uniquindio.application.dtos.usuario.UsuarioDTO;
import co.edu.uniquindio.application.models.entitys.Alojamiento;
import co.edu.uniquindio.application.models.entitys.Reserva;
import co.edu.uniquindio.application.models.enums.ReservaEstado;
import java.time.LocalDate;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-09-27T19:12:08-0500",
    comments = "version: 1.6.3, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.14.jar, environment: Java 21.0.8 (Ubuntu)"
)
@Component
public class ReservaMapperImpl extends ReservaMapper {

    @Override
    public Reserva toEntity(CreacionReservaDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Reserva.ReservaBuilder reserva = Reserva.builder();

        reserva.cantidadHuespedes( dto.numeroHuespedes() );
        reserva.fechaEntrada( dto.fechaEntrada() );
        reserva.fechaSalida( dto.fechaSalida() );

        reserva.creadoEn( java.time.LocalDateTime.now() );
        reserva.estado( ReservaEstado.PENDIENTE );
        reserva.alojamiento( alojamientoRepositorio.findById(dto.alojamientoId()).orElse(null) );
        reserva.huesped( usuarioRepositorio.findById(dto.usuarioId()).orElse(null) );

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

        Integer numeroHuespedes = null;
        Long id = null;
        LocalDate fechaEntrada = null;
        LocalDate fechaSalida = null;
        ReservaEstado estado = null;

        numeroHuespedes = entity.getCantidadHuespedes();
        id = entity.getId();
        fechaEntrada = entity.getFechaEntrada();
        fechaSalida = entity.getFechaSalida();
        estado = entity.getEstado();

        UsuarioDTO usuario = entity.getHuesped() != null ? usuarioMapper.toUserDTO(entity.getHuesped()) : null;
        AlojamientoDTO alojamiento = entity.getAlojamiento() != null ? alojamientoMapper.toDTO(entity.getAlojamiento()) : null;

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
}
