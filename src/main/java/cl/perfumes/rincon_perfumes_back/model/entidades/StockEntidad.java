package cl.perfumes.rincon_perfumes_back.model.entidades;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "stock")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StockEntidad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idStock;

    @Column(nullable = false)
    private Integer cantidadDisponible;

    @Column(nullable = false)
    private LocalDateTime fechaActualizacion;

    @OneToOne
    @JoinColumn(name = "id_producto", nullable = false)
    private ProductoEntidad producto;

    @PrePersist
    @PreUpdate
    protected void onUpdate() {
        fechaActualizacion = LocalDateTime.now();
    }
}

