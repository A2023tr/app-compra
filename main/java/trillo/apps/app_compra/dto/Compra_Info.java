package trillo.apps.app_compra.dto;

import jakarta.annotation.Resource;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;

@Resource
@Getter
@Setter
public class Compra_Info {
    private String username;
    private int cantidad;
    private String nombre_pro;
    private double total_compra;
    private LocalDateTime fecha;
}
