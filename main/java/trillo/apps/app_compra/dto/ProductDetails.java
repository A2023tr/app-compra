package trillo.apps.app_compra.dto;


import jakarta.annotation.Resource;
import lombok.Getter;
import lombok.Setter;

@Resource
@Getter
@Setter
public class ProductDetails {
    String nombre;
    double precio;
}
