package co.edu.uniquindio.application.services;

import co.edu.uniquindio.application.dtos.alojamiento.*;
import co.edu.uniquindio.application.models.entitys.Alojamiento;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface AlojamientoServicio {
    void crear(CreacionAlojamientoDTO dto) throws Exception;
    void editar(Long id, EdicionAlojamientoDTO edicionAlojamientoDTO) throws Exception;
    void eliminar(Long id) throws Exception;
    Alojamiento obtenerAlojamientoId(Long id) throws Exception;
    MetricasDTO obtenerMetricas(Long id) throws Exception;
    Page<ItemAlojamientoDTO> obtenerAlojamiento(AlojamientoFiltroDTO filtros, Pageable pageable) throws Exception;
    List<ItemAlojamientoDTO> obtenerAlojamientoUsuario(String id, int pagina) throws Exception;
}
