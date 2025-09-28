package co.edu.uniquindio.application.mappers;

import co.edu.uniquindio.application.models.entitys.ContrasenaCodigoReinicio;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-09-27T12:08:37-0500",
    comments = "version: 1.6.3, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.14.jar, environment: Java 21.0.8 (Eclipse Adoptium)"
)
@Component
public class ContrasenaCodigoReinicioMapperImpl implements ContrasenaCodigoReinicioMapper {

    @Override
    public ContrasenaCodigoReinicio toEntity(String codigo) {
        if ( codigo == null ) {
            return null;
        }

        ContrasenaCodigoReinicio.ContrasenaCodigoReinicioBuilder contrasenaCodigoReinicio = ContrasenaCodigoReinicio.builder();

        contrasenaCodigoReinicio.codigo( codigo );

        return contrasenaCodigoReinicio.build();
    }

    @Override
    public void updateFromCodigo(String codigo, ContrasenaCodigoReinicio entity) {
        if ( codigo == null ) {
            return;
        }

        entity.setCodigo( codigo );
    }
}
