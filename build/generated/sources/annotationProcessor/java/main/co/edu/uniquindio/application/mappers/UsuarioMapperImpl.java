package co.edu.uniquindio.application.mappers;

import co.edu.uniquindio.application.dtos.usuario.CreacionUsuarioDTO;
import co.edu.uniquindio.application.dtos.usuario.EdicionUsuarioDTO;
import co.edu.uniquindio.application.dtos.usuario.UsuarioDTO;
import co.edu.uniquindio.application.models.entitys.Usuario;
import co.edu.uniquindio.application.models.enums.Estado;
import co.edu.uniquindio.application.models.enums.Rol;
import java.time.LocalDate;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-09-26T00:29:41-0500",
    comments = "version: 1.6.3, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.14.jar, environment: Java 21.0.8 (Ubuntu)"
)
@Component
public class UsuarioMapperImpl implements UsuarioMapper {

    @Override
    public Usuario toEntity(CreacionUsuarioDTO userDTO) {
        if ( userDTO == null ) {
            return null;
        }

        Usuario.UsuarioBuilder usuario = Usuario.builder();

        usuario.nombre( userDTO.nombre() );
        usuario.email( userDTO.email() );
        usuario.contrasena( userDTO.contrasena() );
        usuario.telefono( userDTO.telefono() );
        usuario.fechaNacimiento( userDTO.fechaNacimiento() );
        usuario.foto( userDTO.foto() );

        usuario.id( java.util.UUID.randomUUID().toString() );
        usuario.estado( Estado.ACTIVO );
        usuario.creadoEn( java.time.LocalDateTime.now() );
        usuario.rol( Rol.Huesped );

        return usuario.build();
    }

    @Override
    public UsuarioDTO toUserDTO(Usuario user) {
        if ( user == null ) {
            return null;
        }

        String id = null;
        String nombre = null;
        String email = null;
        String telefono = null;
        Rol rol = null;
        LocalDate fechaNacimiento = null;
        String foto = null;

        id = user.getId();
        nombre = user.getNombre();
        email = user.getEmail();
        telefono = user.getTelefono();
        rol = user.getRol();
        fechaNacimiento = user.getFechaNacimiento();
        foto = user.getFoto();

        UsuarioDTO usuarioDTO = new UsuarioDTO( id, nombre, email, telefono, rol, fechaNacimiento, foto );

        return usuarioDTO;
    }

    @Override
    public void updateUsuarioFromDTO(EdicionUsuarioDTO dto, Usuario usuario) {
        if ( dto == null ) {
            return;
        }

        usuario.setNombre( dto.nombre() );
        usuario.setTelefono( dto.telefono() );
        usuario.setFechaNacimiento( dto.fechaNacimiento() );
        usuario.setFoto( dto.foto() );
    }
}
