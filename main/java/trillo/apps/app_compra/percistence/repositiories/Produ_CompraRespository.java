package trillo.apps.app_compra.percistence.repositiories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import trillo.apps.app_compra.percistence.entities.Produ_Compra;

import java.util.List;

@Repository
public interface Produ_CompraRespository extends JpaRepository<Produ_Compra,Integer> {
     public Produ_Compra findById(int id);
     public List<Produ_Compra> findByUsuario_id(int id);
}
