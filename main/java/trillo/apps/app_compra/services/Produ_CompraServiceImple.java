package trillo.apps.app_compra.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import trillo.apps.app_compra.percistence.entities.Produ_Compra;
import trillo.apps.app_compra.percistence.entities.Productos;
import trillo.apps.app_compra.percistence.entities.Usuario;
import trillo.apps.app_compra.percistence.repositiories.Produ_CompraRespository;
import trillo.apps.app_compra.percistence.repositiories.ProductosRespository;
import trillo.apps.app_compra.percistence.repositiories.UserRepository;

@Service
public class Produ_CompraServiceImple implements Produ_CompraService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProductosRespository productosRespository;

    @Autowired
    private Produ_CompraRespository produCompraRespository;

    @Override
    public Produ_Compra addCompra(String username, String producto, Produ_Compra compra) {

        Usuario user = userRepository.findByUsername(username);
        if (user != null){
            Productos productos = productosRespository.findByNombre(producto);
            if(productos != null){
                Produ_Compra new_compra = new Produ_Compra();
                new_compra.setUsuario(user);
                new_compra.setProductos(productos);
                new_compra.setCantidad(compra.getCantidad());
                produCompraRespository.save(new_compra);
                return new_compra;
            }
            else{
                return null;
            }
        }
        else {
            return null;
        }
    }
}
