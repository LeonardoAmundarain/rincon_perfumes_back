package cl.perfumes.rincon_perfumes_back.repository;

import cl.perfumes.rincon_perfumes_back.model.entidades.PedidoEntidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PedidoRepositorio extends JpaRepository<PedidoEntidad, Long> {
    List<PedidoEntidad> findByClienteId(Long clienteId);
    List<PedidoEntidad> findByEstado(String estado);
}
