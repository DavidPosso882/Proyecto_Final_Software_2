package co.edu.uniquindio.application.mappers;

import co.edu.uniquindio.application.dtos.resena.CreacionResenaDTO;
import co.edu.uniquindio.application.dtos.resena.ItemResenaDTO;
import co.edu.uniquindio.application.dtos.usuario.UsuarioDTO;
import co.edu.uniquindio.application.models.entitys.Resena;
import co.edu.uniquindio.application.models.entitys.Usuario;
import co.edu.uniquindio.application.models.enums.Rol;
import java.time.LocalDate;
import java.time.LocalDateTime;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-09-26T00:29:41-0500",
    comments = "version: 1.6.3, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.14.jar, environment: Java 21.0.8 (Ubuntu)"
)
@Component
public class ResenaMapperImpl implements ResenaMapper {

    @Override
    public Resena toEntity(CreacionResenaDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Resena.ResenaBuilder resena = Resena.builder();

        resena.calificacion( dto.calificacion() );
        resena.comentario( dto.comentario() );

        return resena.build();
    }

    @Override
    public ItemResenaDTO toItemDTO(Resena entity) {
        if ( entity == null ) {
            return null;
        }

        Long id = null;
        int calificacion = 0;
        String comentario = null;
        LocalDateTime creadoEn = null;
        UsuarioDTO usuario = null;
        String respuesta = null;

        id = entity.getId();
        if ( entity.getCalificacion() != null ) {
            calificacion = entity.getCalificacion();
        }
        comentario = entity.getComentario();
        creadoEn = entity.getCreadoEn();
        usuario = usuarioToUsuarioDTO( entity.getUsuario() );
        respuesta = mapRespuestaToString( entity.getRespuesta() );

        ItemResenaDTO itemResenaDTO = new ItemResenaDTO( id, calificacion, comentario, creadoEn, usuario, respuesta );

        return itemResenaDTO;
    }

    @Override
    public void updateFromDto(CreacionResenaDTO dto, Resena entity) {
        if ( dto == null ) {
            return;
        }

        entity.setCalificacion( dto.calificacion() );
        entity.setComentario( dto.comentario() );
    }

    protected UsuarioDTO usuarioToUsuarioDTO(Usuario usuario) {
        if ( usuario == null ) {
            return null;
        }

        String id = null;
        String nombre = null;
        String email = null;
        String telefono = null;
        Rol rol = null;
        LocalDate fechaNacimiento = null;
        String foto = null;

        id = usuario.getId();
        nombre = usuario.getNombre();
        email = usuario.getEmail();
        telefono = usuario.getTelefono();
        rol = usuario.getRol();
        fechaNacimiento = usuario.getFechaNacimiento();
        foto = usuario.getFoto();

        UsuarioDTO usuarioDTO = new UsuarioDTO( id, nombre, email, telefono, rol, fechaNacimiento, foto );

        return usuarioDTO;
    }
}
