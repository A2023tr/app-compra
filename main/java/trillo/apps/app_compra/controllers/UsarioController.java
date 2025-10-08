package trillo.apps.app_compra.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import trillo.apps.app_compra.percistence.entities.Usuario;
import trillo.apps.app_compra.services.UserService;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsarioController {

    @Autowired
    private UserService userService;

    @PostMapping("/añadir")
    private ResponseEntity<?> addUser(@RequestBody Usuario usuario){
        Usuario usu = userService.addUser(usuario);
        return ResponseEntity.ok(usu);
    }

    @GetMapping
    private ResponseEntity<?> getUsers(){
        List<Usuario> usuarios = userService.getUsers();
        return ResponseEntity.ok(usuarios);
    }

    @PutMapping("/actualizar")
    private ResponseEntity<?> updateUser(@RequestBody Usuario usuario){
        Usuario usu = userService.updateUser(usuario);
        return ResponseEntity.ok(usu);
    }

    @DeleteMapping("/{username}")
    private ResponseEntity<?> deleteUser(@PathVariable String username){
        Usuario usuario = userService.deleteUser(username);
        return ResponseEntity.ok(usuario);
    }
}
