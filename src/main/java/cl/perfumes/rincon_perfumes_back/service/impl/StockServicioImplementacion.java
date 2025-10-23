package cl.perfumes.rincon_perfumes_back.service.impl;

import cl.perfumes.rincon_perfumes_back.model.entidades.StockEntidad;
import cl.perfumes.rincon_perfumes_back.repository.StockRepositorio;
import cl.perfumes.rincon_perfumes_back.service.StockServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StockServicioImplementacion implements StockServicio {

    @Autowired
    private StockRepositorio stockRepositorio;

    @Override
    public List<StockEntidad> listarStock() {
        return stockRepositorio.findAll();
    }

    @Override
    public Optional<StockEntidad> obtenerPorId(Long id) {
        return stockRepositorio.findById(id);
    }

    @Override
    public StockEntidad guardar(StockEntidad stock) {
        return stockRepositorio.save(stock);
    }

    @Override
    public void eliminar(Long id) {
        stockRepositorio.deleteById(id);
    }
}

