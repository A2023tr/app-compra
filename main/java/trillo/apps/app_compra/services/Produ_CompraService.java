package trillo.apps.app_compra.services;

import org.springframework.stereotype.Service;
import trillo.apps.app_compra.dto.Compra_Info;
import trillo.apps.app_compra.percistence.entities.Produ_Compra;

import java.util.List;

public interface Produ_CompraService {

    public Produ_Compra addCompra(String username,String producto, Produ_Compra compra);
    public List<Compra_Info> getCompras();
    public Produ_Compra deleteCompra(int id);
    public List<Compra_Info> getCompraUsuario(String username);

}
