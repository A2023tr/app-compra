package trillo.apps.app_compra.percistence.repositiories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import trillo.apps.app_compra.percistence.entities.Produ_Compra;

@Repository
public interface Produ_CompraRespository extends JpaRepository<Produ_Compra,Integer> {

}
