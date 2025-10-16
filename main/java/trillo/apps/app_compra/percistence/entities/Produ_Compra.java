package trillo.apps.app_compra.percistence.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.service.spi.InjectService;

import java.sql.Time;
import java.time.LocalDateTime;
import java.util.Date;

@Entity(name = "produ_compra")
@Getter
@Setter

public class Produ_Compra {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int cantidad;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "producto_id")
    private Productos productos;
    private Double total_compra;
    private LocalDateTime fecha_compra;
}
