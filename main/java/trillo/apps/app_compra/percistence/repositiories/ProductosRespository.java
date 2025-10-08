package trillo.apps.app_compra.percistence.repositiories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;
import trillo.apps.app_compra.percistence.entities.Productos;

import java.util.List;

@Repository
public interface ProductosRespository extends JpaRepository<Productos,Integer> {
      public List<Productos> findAllByCantidad(int cantidad);
      public Productos findByNombre(String nombre);
      public List<Productos> findAllByCategoria(String categoria);
      //@Query(value = "select * from producto where cantidad between" +rango1+" and "+rango2,nativeQuery = true)
      //public List<Productos> getProductosByLimits();
}
