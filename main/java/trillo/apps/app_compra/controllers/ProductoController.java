package trillo.apps.app_compra.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import trillo.apps.app_compra.percistence.entities.Productos;
import trillo.apps.app_compra.services.ProductosSerivice;

import java.util.List;

@RestController
@RequestMapping("/productos")
public class ProductoController {

    @Autowired
    private ProductosSerivice productosSerivice;
    @PostMapping("/añadir")
    private ResponseEntity<?> addProducto(@RequestBody Productos producto){
        Productos productos = productosSerivice.addProducto(producto);
        return ResponseEntity.ok(productos);
    }

    @GetMapping
    private ResponseEntity<?> getProductos(){
        List<Productos> productos = productosSerivice.getProductos();
        return ResponseEntity.ok(productos);
    }

    @GetMapping("/{cantidad}")
    private ResponseEntity<?> getProduCant(@PathVariable int cantidad){
        List<Productos> productosList = productosSerivice.getProduCant(cantidad);
        return ResponseEntity.ok(productosList);
    }

    @GetMapping("/nombre/{nombrePr}")
    private ResponseEntity<?> getProductoName(@PathVariable("nombrePr") String nombre){
        Productos producto = productosSerivice.getProduName(nombre);
        return ResponseEntity.ok(producto);
    }

    @GetMapping("/categoria/{cat}")
    private ResponseEntity<?> getProduCat(@PathVariable("cat") String categoria){
        List<Productos> productosList = productosSerivice.getProduCar(categoria);
        return ResponseEntity.ok(productosList);
    }

    @PutMapping
    private ResponseEntity<?> updateProdu(@RequestBody Productos producto){
        Productos productoAc = productosSerivice.updateProdu(producto);
        return ResponseEntity.ok(productoAc);
    }

    @DeleteMapping("/{nombre}")
    private ResponseEntity<?> deleteProdu(@PathVariable String nombre){
        Productos producto = productosSerivice.deleteProdu(nombre);
        return ResponseEntity.ok(producto);
    }
}
