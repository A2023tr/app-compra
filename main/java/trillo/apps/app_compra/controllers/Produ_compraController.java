package trillo.apps.app_compra.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import trillo.apps.app_compra.percistence.entities.Produ_Compra;
import trillo.apps.app_compra.percistence.entities.Productos;
import trillo.apps.app_compra.percistence.entities.Usuario;
import trillo.apps.app_compra.services.Produ_CompraService;

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
}
