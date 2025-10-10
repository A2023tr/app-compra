package trillo.apps.app_compra.services;

import trillo.apps.app_compra.percistence.entities.Productos;

import java.util.List;

public interface ProductosSerivice {
    public Productos addProducto(Productos productos);
    public List<Productos> getProductos();
    public List<Productos> getProduCant(int cantidad);
    public Productos getProduName(String nombre);
    public List<Productos> getProduCar(String categoria);
    public Productos updateProdu(Productos producto);
    public Productos deleteProdu(String producto);
}
