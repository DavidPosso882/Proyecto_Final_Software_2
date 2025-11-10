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
    date = "2025-11-09T23:27:11-0500",
    comments = "version: 1.6.3, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.14.jar, environment: Java 21.0.8 (Ubuntu)"
)
@Component
public class UsuarioMapperImpl implements UsuarioMapper {

    @Override
    public Usuario toEntity(CreacionUsuarioDTO usuarioDTO) {
        if ( usuarioDTO == null ) {
            return null;
        }

        Usuario.UsuarioBuilder usuario = Usuario.builder();

        usuario.nombre( usuarioDTO.nombre() );
        usuario.email( usuarioDTO.email() );
        usuario.contrasena( usuarioDTO.contrasena() );
        usuario.telefono( usuarioDTO.telefono() );
        usuario.fechaNacimiento( usuarioDTO.fechaNacimiento() );

        usuario.id( java.util.UUID.randomUUID().toString() );
        usuario.estado( Estado.ACTIVO );
        usuario.creadoEn( java.time.LocalDateTime.now() );
        usuario.rol( Rol.Huesped );

        return usuario.build();
    }

    @Override
    public Usuario toEntity(UsuarioDTO usuarioDTO) {
        if ( usuarioDTO == null ) {
            return null;
        }

        Usuario.UsuarioBuilder usuario = Usuario.builder();

        usuario.id( usuarioDTO.id() );
        usuario.nombre( usuarioDTO.nombre() );
        usuario.email( usuarioDTO.email() );
        usuario.telefono( usuarioDTO.telefono() );
        usuario.rol( usuarioDTO.rol() );
        usuario.fechaNacimiento( usuarioDTO.fechaNacimiento() );
        usuario.foto( usuarioDTO.foto() );
        usuario.esAnfitrion( usuarioDTO.esAnfitrion() );

        return usuario.build();
    }

    @Override
    public UsuarioDTO toUserDTO(Usuario usuario) {
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
        Boolean esAnfitrion = null;

        id = usuario.getId();
        nombre = usuario.getNombre();
        email = usuario.getEmail();
        telefono = usuario.getTelefono();
        rol = usuario.getRol();
        fechaNacimiento = usuario.getFechaNacimiento();
        foto = usuario.getFoto();
        esAnfitrion = usuario.getEsAnfitrion();

        UsuarioDTO usuarioDTO = new UsuarioDTO( id, nombre, email, telefono, rol, fechaNacimiento, foto, esAnfitrion );

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
