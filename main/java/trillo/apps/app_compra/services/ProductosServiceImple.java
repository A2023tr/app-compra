package trillo.apps.app_compra.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import trillo.apps.app_compra.percistence.entities.Productos;
import trillo.apps.app_compra.percistence.repositiories.ProductosRespository;

import java.util.List;

@Service
public class ProductosServiceImple implements ProductosSerivice{

    @Autowired
    private ProductosRespository productosRespository;

    @Override
    public Productos addProducto(Productos productos) {
        productosRespository.save(productos);
        return productos;
    }

    @Override
    public List<Productos> getProductos() {
        List<Productos> productos = productosRespository.findAll();
        return productos;
    }

    @Override
    public List<Productos> getProduCant(int cantidad) {
        List<Productos> productosList = productosRespository.findAllByCantidad(cantidad);
        return productosList;
    }

    @Override
    public Productos getProduName(String nombre) {
        Productos producto = productosRespository.findByNombre(nombre);
        return  producto;
    }

    @Override
    public List<Productos> getProduCar(String categoria) {
        List<Productos> productosList = productosRespository.findAllByCategoria(categoria);
        return productosList;
    }

    @Override
    public Productos updateProdu(Productos producto) {
        Productos produ = productosRespository.findByNombre(producto.getNombre());
        if(produ != null){
            produ.setNombre(producto.getNombre());
            produ.setCantidad(producto.getCantidad());
            produ.setCategoria(producto.getCategoria());
            produ.setPrecio(producto.getPrecio());
            productosRespository.save(produ);
            return produ;
        }
        else {
            return null;
        }
    }

    @Override
    public Productos deleteProdu(String producto) {
        Productos produ = productosRespository.findByNombre(producto);
        productosRespository.delete(produ);
        return produ;
    }


}
