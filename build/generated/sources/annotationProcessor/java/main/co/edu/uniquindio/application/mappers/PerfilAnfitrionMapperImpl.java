package co.edu.uniquindio.application.mappers;

import co.edu.uniquindio.application.dtos.usuario.AnfitrionPerfilDTO;
import co.edu.uniquindio.application.dtos.usuario.CreacionAnfitrionDTO;
import co.edu.uniquindio.application.models.entitys.PerfilAnfitrion;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-09-26T00:29:41-0500",
    comments = "version: 1.6.3, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.14.jar, environment: Java 21.0.8 (Ubuntu)"
)
@Component
public class PerfilAnfitrionMapperImpl implements PerfilAnfitrionMapper {

    @Override
    public PerfilAnfitrion toEntity(CreacionAnfitrionDTO dto) {
        if ( dto == null ) {
            return null;
        }

        PerfilAnfitrion perfilAnfitrion = new PerfilAnfitrion();

        if ( dto.id() != null ) {
            perfilAnfitrion.setId( Long.parseLong( dto.id() ) );
        }
        perfilAnfitrion.setSobreMi( dto.sobreMi() );

        return perfilAnfitrion;
    }

    @Override
    public AnfitrionPerfilDTO toDTO(PerfilAnfitrion entity) {
        if ( entity == null ) {
            return null;
        }

        String descripcion = null;
        List<String> documentos = null;

        AnfitrionPerfilDTO anfitrionPerfilDTO = new AnfitrionPerfilDTO( descripcion, documentos );

        return anfitrionPerfilDTO;
    }

    @Override
    public void updateFromDto(CreacionAnfitrionDTO dto, PerfilAnfitrion entity) {
        if ( dto == null ) {
            return;
        }

        if ( dto.id() != null ) {
            entity.setId( Long.parseLong( dto.id() ) );
        }
        else {
            entity.setId( null );
        }
        entity.setSobreMi( dto.sobreMi() );
    }
}
