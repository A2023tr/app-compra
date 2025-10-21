package trillo.apps.app_compra.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import trillo.apps.app_compra.dto.Compra_Info;
import trillo.apps.app_compra.percistence.entities.Produ_Compra;
import trillo.apps.app_compra.percistence.entities.Productos;
import trillo.apps.app_compra.percistence.entities.Usuario;
import trillo.apps.app_compra.services.Produ_CompraService;

import java.util.List;

@RestController
@RequestMapping("/registro_compra")
public class Produ_compraController {

    @Autowired
    private Produ_CompraService produCompraService;

    @PostMapping("/{username}/{producto}")
    private ResponseEntity<?> addCompra(@PathVariable("username") String username,
                                        @PathVariable("producto") String producto,
                                        @RequestBody Produ_Compra produCompra){
        Produ_Compra compra = produCompraService.addCompra(username,producto,produCompra);
        return ResponseEntity.ok(compra);
    }

    @GetMapping
    private ResponseEntity<?> getCompras(){
        List<Compra_Info> compras = produCompraService.getCompras();
        return ResponseEntity.ok(compras);
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<?> deleteCompra(@PathVariable int id){
        Produ_Compra compra = produCompraService.deleteCompra(id);
        return ResponseEntity.ok(compra);
    }

    @GetMapping("/{username}")
    private ResponseEntity<?> getComprasUsuario(@PathVariable String username){
        List<Compra_Info> compraInfos = produCompraService.getCompraUsuario(username);
        return ResponseEntity.ok(compraInfos);

    }
    
}
