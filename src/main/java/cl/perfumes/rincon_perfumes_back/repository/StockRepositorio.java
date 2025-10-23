package cl.perfumes.rincon_perfumes_back.repository;

import cl.perfumes.rincon_perfumes_back.model.entidades.StockEntidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockRepositorio extends JpaRepository<StockEntidad, Long> {
}

