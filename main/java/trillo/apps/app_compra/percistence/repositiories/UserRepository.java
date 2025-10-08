package trillo.apps.app_compra.percistence.repositiories;

import jdk.dynalink.linker.LinkerServices;
import org.springframework.data.jpa.repository.JpaRepository;
import trillo.apps.app_compra.percistence.entities.Usuario;

import java.util.List;

public interface UserRepository extends JpaRepository<Usuario,Integer> {
    public Usuario findByUsername(String username);
}
