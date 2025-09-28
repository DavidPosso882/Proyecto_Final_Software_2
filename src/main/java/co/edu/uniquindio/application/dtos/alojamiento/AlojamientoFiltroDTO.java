package co.edu.uniquindio.application.dtos.alojamiento;

import java.util.List;

public record AlojamientoFiltroDTO(
    String ciudad,
    String fechaEntrada,
    String fechaSalida,
    Float precioMin,
    Float precioMax,
    List<String> servicios,
    Integer capacidad
) {
}
