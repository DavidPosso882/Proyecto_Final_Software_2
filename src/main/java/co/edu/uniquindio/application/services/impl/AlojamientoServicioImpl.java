package co.edu.uniquindio.application.services.impl;

import co.edu.uniquindio.application.dtos.alojamiento.*;
import co.edu.uniquindio.application.dtos.resena.CreacionResenaDTO;
import co.edu.uniquindio.application.dtos.resena.ItemResenaDTO;
import co.edu.uniquindio.application.dtos.usuario.EdicionUsuarioDTO;
import co.edu.uniquindio.application.exceptions.NoFoundException;
import co.edu.uniquindio.application.models.entitys.Alojamiento;
import co.edu.uniquindio.application.models.entitys.Usuario;
import co.edu.uniquindio.application.models.enums.Estado;
import co.edu.uniquindio.application.models.vo.Direccion;
import co.edu.uniquindio.application.models.vo.Localizacion;
import co.edu.uniquindio.application.repositories.AlojamientoRepositorio;
import co.edu.uniquindio.application.repositories.UsuarioRepositorio;
import co.edu.uniquindio.application.services.AlojamientoServicio;
import co.edu.uniquindio.application.services.AuthServicio;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AlojamientoServicioImpl implements AlojamientoServicio {

    private final AlojamientoRepositorio alojamientoRepositorio;
    private final UsuarioRepositorio usuarioRepositorio;
    private final AuthServicio authServicio;

    @Override
    public void crear(CreacionAlojamientoDTO alojamientoDTO) throws Exception {
        // Obtener usuario autenticado
        String usuarioId = authServicio.obtnerIdUsuarioAutenticado();
        Usuario usuario = usuarioRepositorio.findById(usuarioId)
                .orElseThrow(() -> new NoFoundException("Usuario no encontrado"));

        // Crear entidad Alojamiento primero sin colecciones
        Alojamiento alojamiento = new Alojamiento();
        alojamiento.setTitulo(alojamientoDTO.titulo());
        alojamiento.setDescripcion(alojamientoDTO.descripcion());
        alojamiento.setDireccion(new Direccion(
                alojamientoDTO.ubicacion().ciudad(),
                alojamientoDTO.ubicacion().direccion(),
                new Localizacion(
                        alojamientoDTO.ubicacion().coordenadas().latitud().floatValue(),
                        alojamientoDTO.ubicacion().coordenadas().longitud().floatValue()
                )
        ));
        alojamiento.setMaxHuespedes(alojamientoDTO.capacidad());
        alojamiento.setPrecioPorNoche(alojamientoDTO.precioNoche());
        alojamiento.setEstado(Estado.ACTIVO);
        alojamiento.setAnfitrion(usuario);
        alojamiento.setCreadoEn(LocalDateTime.now());

        // Guardar primero el alojamiento para obtener el ID
        Alojamiento alojamientoGuardado = alojamientoRepositorio.save(alojamiento);
        
        // Ahora agregar las colecciones
        alojamientoGuardado.setImagenes(alojamientoDTO.imagenes());
        alojamientoGuardado.setServicios(new HashSet<>(alojamientoDTO.servicios()));
        
        // Guardar nuevamente con las colecciones
        alojamientoRepositorio.save(alojamientoGuardado);
    }

    @Override
    public void editar (Long id, EdicionUsuarioDTO edicionUsuarioDTO) throws Exception {

    }

    @Override
    public void eliminar(Long id) throws Exception {

    }

    @Override
    public Alojamiento obtenerAlojamientoId(Long id) throws Exception {
        return null;
    }

    @Override
    public MetricasDTO obtenerMetricas(Long id) throws Exception {
        return null;
    }

    @Override
    public List<ItemAlojamientoDTO> obtenerAlojamiento(AlojamientoFiltroDTO filtros) throws Exception {
        return null;
    }

    @Override
    public List<ItemAlojamientoDTO> obtenerAlojamientoUsuario(String id, int pagina) throws Exception {

        Pageable pageable = PageRequest.of(pagina, 5);
        Page<ItemAlojamientoDTO> alojamientos = alojamientoRepositorio.getAlojamientos(id, pageable);

        return alojamientos.toList();
    }
}
