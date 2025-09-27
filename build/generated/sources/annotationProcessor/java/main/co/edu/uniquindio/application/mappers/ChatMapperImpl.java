package co.edu.uniquindio.application.mappers;

import co.edu.uniquindio.application.dtos.chat.ChatDTO;
import co.edu.uniquindio.application.dtos.chat.MensajeDTO;
import co.edu.uniquindio.application.dtos.usuario.UsuarioDTO;
import co.edu.uniquindio.application.models.entitys.Chat;
import co.edu.uniquindio.application.models.entitys.Mensaje;
import co.edu.uniquindio.application.models.entitys.Usuario;
import co.edu.uniquindio.application.models.enums.Rol;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-09-26T00:29:41-0500",
    comments = "version: 1.6.3, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.14.jar, environment: Java 21.0.8 (Ubuntu)"
)
@Component
public class ChatMapperImpl implements ChatMapper {

    @Override
    public ChatDTO toDTO(Chat chat) {
        if ( chat == null ) {
            return null;
        }

        List<UsuarioDTO> participantes = null;
        List<MensajeDTO> mensajes = null;

        participantes = usuarioListToUsuarioDTOList( chat.getParticipantes() );
        mensajes = mensajeListToMensajeDTOList( chat.getMensajes() );

        Integer reservaId = null;
        MensajeDTO ultimoMensaje = null;

        ChatDTO chatDTO = new ChatDTO( reservaId, participantes, mensajes, ultimoMensaje );

        return chatDTO;
    }

    @Override
    public MensajeDTO toMensajeDTO(Mensaje mensaje) {
        if ( mensaje == null ) {
            return null;
        }

        String contenido = null;
        LocalDateTime fechaEnvio = null;
        boolean leido = false;

        contenido = mensaje.getContenido();
        fechaEnvio = mensaje.getFechaEnvio();
        leido = mensaje.isLeido();

        Integer remitenteId = null;
        Integer destinatarioId = null;
        Integer reservaId = null;

        MensajeDTO mensajeDTO = new MensajeDTO( remitenteId, destinatarioId, reservaId, contenido, fechaEnvio, leido );

        return mensajeDTO;
    }

    @Override
    public Mensaje toEntity(MensajeDTO mensajeDTO) {
        if ( mensajeDTO == null ) {
            return null;
        }

        Mensaje.MensajeBuilder mensaje = Mensaje.builder();

        mensaje.contenido( mensajeDTO.contenido() );
        mensaje.fechaEnvio( mensajeDTO.fechaEnvio() );
        mensaje.leido( mensajeDTO.leido() );

        return mensaje.build();
    }

    @Override
    public UsuarioDTO toUsuarioDTO(Usuario usuario) {
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

    protected List<UsuarioDTO> usuarioListToUsuarioDTOList(List<Usuario> list) {
        if ( list == null ) {
            return null;
        }

        List<UsuarioDTO> list1 = new ArrayList<UsuarioDTO>( list.size() );
        for ( Usuario usuario : list ) {
            list1.add( toUsuarioDTO( usuario ) );
        }

        return list1;
    }

    protected List<MensajeDTO> mensajeListToMensajeDTOList(List<Mensaje> list) {
        if ( list == null ) {
            return null;
        }

        List<MensajeDTO> list1 = new ArrayList<MensajeDTO>( list.size() );
        for ( Mensaje mensaje : list ) {
            list1.add( toMensajeDTO( mensaje ) );
        }

        return list1;
    }
}
