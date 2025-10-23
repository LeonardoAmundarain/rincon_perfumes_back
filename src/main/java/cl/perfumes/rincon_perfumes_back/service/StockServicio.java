package cl.perfumes.rincon_perfumes_back.service;

import cl.perfumes.rincon_perfumes_back.model.entidades.StockEntidad;
import java.util.List;
import java.util.Optional;

public interface StockServicio {
    List<StockEntidad> listarStock();
    Optional<StockEntidad> obtenerPorId(Long id);
    StockEntidad guardar(StockEntidad stock);
    void eliminar(Long id);
}

