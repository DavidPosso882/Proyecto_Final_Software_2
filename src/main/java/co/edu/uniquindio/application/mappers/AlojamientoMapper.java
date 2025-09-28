package co.edu.uniquindio.application.mappers;

import co.edu.uniquindio.application.dtos.alojamiento.AlojamientoDTO;
import co.edu.uniquindio.application.dtos.alojamiento.CreacionAlojamientoDTO;
import co.edu.uniquindio.application.dtos.alojamiento.EdicionAlojamientoDTO;
import co.edu.uniquindio.application.dtos.alojamiento.ItemAlojamientoDTO;
import co.edu.uniquindio.application.models.entitys.Alojamiento;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper (componentModel = MappingConstants.ComponentModel.SPRING)
public interface AlojamientoMapper {

    @Mapping(target = "creadoEn", expression = "java(java.time.LocalDateTime.now())")
    @Mapping(target = "estado", constant = "ACTIVO")
    Alojamiento toEntity(CreacionAlojamientoDTO dto);

    @Mapping(target = "imagenPrincipal", expression = "java(alojamiento.getImagenes() != null && !alojamiento.getImagenes().isEmpty() ? alojamiento.getImagenes().get(0) : null)")
    @Mapping(target = "precioNoche", source = "precioPorNoche")
    @Mapping(target = "ubicacion.ciudad", source = "direccion.ciudad")
    @Mapping(target = "ubicacion.direccion", source = "direccion.direccion")
    @Mapping(target = "ubicacion.ubicacion.latitud", source = "direccion.ubicacion.latitud")
    @Mapping(target = "ubicacion.ubicacion.longitud", source = "direccion.ubicacion.longitud")
    @Mapping(target = "promedioCalificaciones", expression = "java(null)") // Calcular promedio de calificaciones
    @Mapping(target = "capacidad", source = "maxHuespedes")
    ItemAlojamientoDTO toItemDTO(Alojamiento alojamiento);

    @Mapping(target = "imagenPrincipal", expression = "java(alojamiento.getImagenes() != null && !alojamiento.getImagenes().isEmpty() ? 0 : null)")
    AlojamientoDTO toDTO(Alojamiento alojamiento);

    @Mapping(target = "precioPorNoche", source = "precioNoche", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "maxHuespedes", source = "capacidad", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "direccion", source = "ubicacion", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateAlojamientoFromDto(EdicionAlojamientoDTO edicionAlojamientoDTO, @MappingTarget Alojamiento alojamiento);
}
