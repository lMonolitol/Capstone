package org.hernandez.com.controlador;

import java.util.List;
import java.util.Optional;

import org.hernandez.com.modelo.Usuario;
import org.hernandez.com.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin (origins = "http://localhost:4200")
@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    @Autowired
    private UsuarioService servicio;
    
    @GetMapping
    public List<Usuario> listar(){
        return servicio.listarUsuarios();
    }

    @PostMapping("/agregar")
    public Usuario agregar(@RequestBody Usuario usuario){
        return servicio.insertarUsuario(usuario);
    }

    @DeleteMapping("/eliminar/{id}")
    public void eliminar(@PathVariable int id){
        servicio.eliminarUsuario(id);
    }
    
    @GetMapping("/obtener/{id}")
    public ResponseEntity<Usuario> obtenerUsuarioPorId(@PathVariable int id) {
        Optional<Usuario> usuario = servicio.buscarUsuario(id);
        return usuario.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/editar/{id}")
    public Usuario editar(@PathVariable int id, @RequestBody Usuario usuario){
        Optional<Usuario> u = servicio.buscarUsuario(id);
        if(u.isPresent()){
            Usuario usuarioExistente = u.get();
            usuarioExistente.setNombre(usuario.getNombre());
            usuarioExistente.setApellido(usuario.getApellido());
            usuarioExistente.setCorreo(usuario.getCorreo());
            usuarioExistente.setContraseña(usuario.getContraseña());
            return servicio.actualizarUsuario(id,usuarioExistente);
        } else {
            return null;
        }
    }
}
