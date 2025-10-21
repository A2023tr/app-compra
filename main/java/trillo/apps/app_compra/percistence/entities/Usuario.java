package trillo.apps.app_compra.percistence.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@Entity(name = "usuario")
@Getter
@Setter
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombre;
    @Column(name = "username",unique = true)
    private String username;
    @Column(name = "password",unique = true)
    private String password;
    private Double wallet;
}
