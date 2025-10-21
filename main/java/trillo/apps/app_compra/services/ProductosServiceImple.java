package trillo.apps.app_compra.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import trillo.apps.app_compra.dto.ProductDetails;
import trillo.apps.app_compra.percistence.entities.Productos;
import trillo.apps.app_compra.percistence.repositiories.ProductosRespository;

import java.util.ArrayList;
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
    public List<ProductDetails> getProductByCantidad(int param1, int param2) {
        List<Productos> productos = productosRespository.getProductosByLimits(param1,param2);
        List<ProductDetails> productDetails = new ArrayList<>();
        for(Productos pro:productos){
            ProductDetails nuevo_pro = new ProductDetails();
            nuevo_pro.setNombre(pro.getNombre());
            nuevo_pro.setPrecio(pro.getPrecio());
            productDetails.add(nuevo_pro);
        }
        return  productDetails;
    }

    @Override
    public List<ProductDetails> getProductByPrecio(Double param1, Double param2) {
        List<Productos> productosList = productosRespository.getProductosByPrecio(param1,param2);
        List<ProductDetails> productDetails = new ArrayList<>();
        for (Productos pro: productosList){
            ProductDetails nuevo_pro = new ProductDetails();
            nuevo_pro.setNombre(pro.getNombre());
            nuevo_pro.setPrecio(pro.getPrecio());
            productDetails.add(nuevo_pro);
        }
        return productDetails;
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
