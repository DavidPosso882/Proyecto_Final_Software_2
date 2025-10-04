package co.edu.uniquindio.application.dtos.usuario;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CreacionAnfitrionDTO(
    @NotBlank String descripcion,
    @NotNull String anosExperiencia,
    @NotNull String tiempoRespuesta,
    String serviciosEspeciales,
    String informacionBancaria,
    String documentoLegal
) {
}
