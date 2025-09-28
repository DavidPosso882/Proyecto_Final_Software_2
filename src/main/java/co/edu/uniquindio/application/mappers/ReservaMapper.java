package co.edu.uniquindio.application.mappers;

import co.edu.uniquindio.application.dtos.reserva.CreacionReservaDTO;
import co.edu.uniquindio.application.dtos.reserva.ItemReservaDTO;
import co.edu.uniquindio.application.dtos.reserva.ReservaDTO;
import co.edu.uniquindio.application.models.entitys.Alojamiento;
import co.edu.uniquindio.application.models.entitys.Reserva;
import co.edu.uniquindio.application.models.entitys.Usuario;
import co.edu.uniquindio.application.repositories.AlojamientoRepositorio;
import co.edu.uniquindio.application.repositories.UsuarioRepositorio;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public abstract class ReservaMapper {

    @Autowired
    protected AlojamientoRepositorio alojamientoRepositorio;

    @Autowired
    protected UsuarioRepositorio usuarioRepositorio;

    @Autowired
    protected AlojamientoMapper alojamientoMapper;

    @Autowired
    protected UsuarioMapper usuarioMapper;

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "creadoEn", expression = "java(java.time.LocalDateTime.now())")
    @Mapping(target = "estado", constant = "PENDIENTE")
    @Mapping(target = "cantidadHuespedes", source = "numeroHuespedes")
    @Mapping(target = "alojamiento", expression = "java(alojamientoRepositorio.findById(dto.alojamientoId()).orElse(null))")
    @Mapping(target = "huesped", expression = "java(usuarioRepositorio.findById(dto.usuarioId()).orElse(null))")
    public abstract Reserva toEntity(CreacionReservaDTO dto);

    public abstract ItemReservaDTO toItemDTO(Reserva entity);

    @Mapping(target = "numeroHuespedes", source = "cantidadHuespedes")
    @Mapping(target = "usuario", expression = "java(entity.getHuesped() != null ? usuarioMapper.toUserDTO(entity.getHuesped()) : null)")
    @Mapping(target = "alojamiento", expression = "java(entity.getAlojamiento() != null ? alojamientoMapper.toDTO(entity.getAlojamiento()) : null)")
    public abstract ReservaDTO toDTO(Reserva entity);

    public abstract void updateFromDto(CreacionReservaDTO dto, @MappingTarget Reserva entity);

}
