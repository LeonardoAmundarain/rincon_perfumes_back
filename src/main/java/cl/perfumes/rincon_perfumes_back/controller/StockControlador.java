package cl.perfumes.rincon_perfumes_back.controller;

import cl.perfumes.rincon_perfumes_back.model.entidades.StockEntidad;
import cl.perfumes.rincon_perfumes_back.service.StockServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/stock")
@CrossOrigin(origins = "*")
public class StockControlador {

    @Autowired
    private StockServicio stockServicio;

    @GetMapping
    public ResponseEntity<List<StockEntidad>> listarStock() {
        return ResponseEntity.ok(stockServicio.listarStock());
    }

    @GetMapping("/{id}")
    public ResponseEntity<StockEntidad> obtenerPorId(@PathVariable Long id) {
        return stockServicio.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<StockEntidad> crear(@RequestBody StockEntidad stock) {
        return ResponseEntity.ok(stockServicio.guardar(stock));
    }

    @PutMapping("/{id}")
    public ResponseEntity<StockEntidad> actualizar(@PathVariable Long id, @RequestBody StockEntidad stock) {
        return stockServicio.obtenerPorId(id)
                .map(existente -> {
                    stock.setIdStock(id);
                    return ResponseEntity.ok(stockServicio.guardar(stock));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        stockServicio.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
