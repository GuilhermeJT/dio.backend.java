package dio.web.api.controller;


import dio.web.api.model.Usuario;
import dio.web.api.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UsuarioController {
    @Autowired
    private UsuarioRepository repositorio;
    @GetMapping()
    public List<Usuario> getUsers(){
        return repositorio.listAll();
    }

    @GetMapping("/{login}")
    public Usuario getUsuario(@PathVariable("login") String login){
        return repositorio.findByLogin(login);
    }


    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id){
        repositorio.remove(id);
    }


    @PostMapping()
    public void save(@RequestBody Usuario usuario){ //@RequestBody entender o xml e transformar em obj
        repositorio.save(usuario);
    }

    @PutMapping
    public void putUser(@RequestBody Usuario usuario){
        repositorio.update(usuario);
    }
}
