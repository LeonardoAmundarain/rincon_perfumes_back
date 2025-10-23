package cl.perfumes.rincon_perfumes_back.repository;

import cl.perfumes.rincon_perfumes_back.model.entidades.RolEntidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolRepositorio extends JpaRepository<RolEntidad, Long> {
    boolean existsByNombreRol(String nombreRol);
}

