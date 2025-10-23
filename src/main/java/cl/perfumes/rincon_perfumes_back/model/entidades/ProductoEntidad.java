package cl.perfumes.rincon_perfumes_back.model.entidades;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "producto")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductoEntidad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProducto;

    @Column(nullable = false, length = 150)
    private String nombreProducto;

    @Column(length = 500)
    private String descripcion;

    @Column(nullable = false)
    private Double precio;

    @Column(nullable = false)
    private Integer volumenML;

    @ManyToOne
    @JoinColumn(name = "id_marca", nullable = false)
    private MarcaEntidad marca;

    @ManyToOne
    @JoinColumn(name = "id_categoria", nullable = false)
    private CategoriaEntidad categoria;

    @ManyToOne
    @JoinColumn(name = "id_tipo_producto", nullable = false)
    private TipoProductoEntidad tipoProducto;

    @ManyToOne
    @JoinColumn(name = "id_genero", nullable = false)
    private GeneroEntidad genero;
}
