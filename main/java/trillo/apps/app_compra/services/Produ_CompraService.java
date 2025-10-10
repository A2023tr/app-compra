package trillo.apps.app_compra.services;

import org.springframework.stereotype.Service;
import trillo.apps.app_compra.percistence.entities.Produ_Compra;

public interface Produ_CompraService {

    public Produ_Compra addCompra(String username,String producto, Produ_Compra compra);

}
