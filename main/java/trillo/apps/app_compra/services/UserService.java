package trillo.apps.app_compra.services;

import trillo.apps.app_compra.percistence.entities.Usuario;

import java.util.List;

public interface UserService {
    public Usuario addUser(Usuario usuario);
    public List<Usuario> getUsers();
    public Usuario updateUser(Usuario usuario);
    public Usuario deleteUser(String username);
}
