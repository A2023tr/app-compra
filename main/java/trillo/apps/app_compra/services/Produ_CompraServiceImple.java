package trillo.apps.app_compra.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import trillo.apps.app_compra.dto.Compra_Info;
import trillo.apps.app_compra.percistence.entities.Produ_Compra;
import trillo.apps.app_compra.percistence.entities.Productos;
import trillo.apps.app_compra.percistence.entities.Usuario;
import trillo.apps.app_compra.percistence.repositiories.Produ_CompraRespository;
import trillo.apps.app_compra.percistence.repositiories.ProductosRespository;
import trillo.apps.app_compra.percistence.repositiories.UserRepository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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
            if(productos != null && productos.getCantidad() >= compra.getCantidad()){
                Double total_spent = (compra.getCantidad() * productos.getPrecio());
                if(user.getWallet() < total_spent){
                    throw new IllegalArgumentException("Saldo Insuficiente");
                }
                Produ_Compra new_compra = new Produ_Compra();
                new_compra.setUsuario(user);
                new_compra.setProductos(productos);
                new_compra.setCantidad(compra.getCantidad());
                new_compra.setTotal_compra(total_spent);
                LocalDateTime today = LocalDateTime.now();
                new_compra.setFecha_compra(today);
                productos.setCantidad(productos.getCantidad()-compra.getCantidad());
                user.setWallet(user.getWallet() - total_spent);
                produCompraRespository.save(new_compra);
                userRepository.save(user);
                productosRespository.save(productos);
                return new_compra;
            }
            else{
                 throw new IllegalArgumentException("No hay suficiente cantidad de ese producto!");
            }
        }
        else {
            return null;
        }
    }

    @Override
    public List<Compra_Info> getCompras() {
        List<Produ_Compra> compras = produCompraRespository.findAll();
        List<Compra_Info> infos = new ArrayList<>();
        for(Produ_Compra compra: compras){
            Compra_Info info = new Compra_Info();
            Usuario usu = compra.getUsuario();
            Productos produ = compra.getProductos();
            info.setUsername(usu.getUsername());
            info.setCantidad(compra.getCantidad());
            info.setNombre_pro(produ.getNombre());
            info.setTotal_compra(compra.getTotal_compra());
            info.setFecha(compra.getFecha_compra());
            infos.add(info);
        }
        return  infos;
    }

    @Override
    public Produ_Compra deleteCompra(int id) {
        Produ_Compra compra = produCompraRespository.findById(id);
        produCompraRespository.delete(compra);
        return compra;
    }
}
