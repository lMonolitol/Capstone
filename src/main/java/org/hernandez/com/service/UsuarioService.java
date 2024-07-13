package org.hernandez.com.service;

import java.util.List;

import java.util.Optional;

import org.hernandez.com.interfaces.IUsuario;
import org.hernandez.com.modelo.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class UsuarioService{
	@Autowired
    private IUsuario rto;
    
    public List<Usuario> listarUsuarios(){
		return rto.findAll();
	}
	public Optional<Usuario> buscarUsuario(int id) {
		return rto.findById(id);
	}
	public Usuario insertarUsuario(Usuario a)  {	
		int id = autoIncrement(rto.findAll());
		Usuario usuario = new Usuario(id,
				a.getNombre(),
				a.getApellido(),
				a.getCorreo(),
				a.getContraseña()	
				);
		return rto.save(usuario);
	}
	public Usuario actualizarUsuario(int id, Usuario a) {
		
		Usuario usuario = rto.findById(id).orElseThrow();
				
		usuario.setNombre(a.getNombre());
		usuario.setApellido(a.getApellido());
		usuario.setCorreo(a.getCorreo());
		usuario.setContraseña(a.getContraseña());
		return rto.save(usuario);
	}
	
	public Usuario eliminarUsuario(int id)  {
		Usuario pro =  rto.findById(id).orElseThrow();
		rto.delete(pro);
		return pro;
	}
	
	public static int autoIncrement(List<Usuario> list) {
		if(list.isEmpty()) {
			return 1;
		}else {
			return list.stream().max(java.util.Comparator.comparing(Usuario::getId)).get().getId()+1;
		}
	}
}
