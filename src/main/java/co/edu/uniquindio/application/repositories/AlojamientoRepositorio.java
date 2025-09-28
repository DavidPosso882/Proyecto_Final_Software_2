package co.edu.uniquindio.application.repositories;

import co.edu.uniquindio.application.dtos.alojamiento.ItemAlojamientoDTO;
import co.edu.uniquindio.application.models.entitys.Alojamiento;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface AlojamientoRepositorio extends JpaRepository<Alojamiento, Long> {

    @Query("SELECT a FROM Alojamiento a WHERE a.anfitrion.id = :idUser")
    Page<Alojamiento> getAlojamientos(String idUser, Pageable pageable);

    @Query("SELECT a FROM Alojamiento a WHERE " +
           "(:ciudad IS NULL OR LOWER(a.direccion.ciudad) LIKE LOWER(CONCAT('%', :ciudad, '%'))) AND " +
           "(:precioMin IS NULL OR a.precioPorNoche >= :precioMin) AND " +
           "(:precioMax IS NULL OR a.precioPorNoche <= :precioMax) AND " +
           "(:capacidad IS NULL OR a.maxHuespedes >= :capacidad) AND " +
           "a.estado = 'ACTIVO'")
    Page<Alojamiento> buscarConFiltros(String ciudad, Float precioMin, Float precioMax, Integer capacidad, Pageable pageable);
}
