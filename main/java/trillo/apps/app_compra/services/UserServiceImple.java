package trillo.apps.app_compra.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import trillo.apps.app_compra.percistence.entities.Usuario;
import trillo.apps.app_compra.percistence.repositiories.UserRepository;

import java.util.List;

@Service
public class UserServiceImple implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public Usuario addUser(Usuario usuario) {
        userRepository.save(usuario);
        return usuario;
    }

    @Override
    public List<Usuario> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public Usuario updateUser(Usuario usuario) {
        Usuario usu = userRepository.findByUsername(usuario.getUsername());
        if(usu != null){
            usu.setNombre(usuario.getNombre());
            usu.setUsername(usuario.getUsername());
            usu.setPassword(usuario.getPassword());
            usu.setWallet(usuario.getWallet());
            userRepository.save(usu);
            return usu;
        }
        else {
            return null;
        }
    }

    @Override
    public Usuario deleteUser(String username) {
        Usuario usu = userRepository.findByUsername(username);
        if (usu != null){
        userRepository.delete(usu);
        return usu;
        }
        else {
            return null;
        }
    }
}
