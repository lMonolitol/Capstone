package org.hernandez.com.service;

import java.util.ArrayList;
import java.util.List;

import org.hernandez.com.interfaces.IUsuario;
import org.hernandez.com.modelo.Item;
import org.hernandez.com.modelo.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemService {
	 @Autowired
	    private IUsuario rto;
	    
	 public List<Item> getCarrito(String nombre){
			Usuario user = rto.findByNombreOrCorreo(nombre, nombre).orElseThrow();
			if(user.getCarrito().isEmpty()) {
				return new ArrayList<>();
			}
	        return user.getCarrito();
	    }

		public Usuario addItem(String nombre, Item itemCarrito) {
			Usuario user = rto.findByNombreOrCorreo(nombre, nombre).orElseThrow();
			user.getCarrito().add(itemCarrito);
			return rto.save(user);
		}
			
		
		public Usuario clearCarrito(String nombre) {
			Usuario user = rto.findByNombreOrCorreo(nombre, nombre).orElseThrow();
		    user.getCarrito().clear();
		    return rto.save(user);
		}
		public Usuario actualizarCantidad(String nombre, Long productoId, int cantidad) {
			Usuario user = rto.findByNombreOrCorreo(nombre, nombre).orElseThrow();
	        user.getCarrito().stream()
	            .filter(item -> item.getProducto().getId() == (productoId))
	            .findFirst()
	            .ifPresent(item -> item.setCantidad(cantidad));
	        return rto.save(user);
	    }

	    public Usuario eliminarProducto(String nombre, Long productoId) {
	    	Usuario user = rto.findByNombreOrCorreo(nombre, nombre).orElseThrow();
	        user.getCarrito().removeIf(item -> item.getProducto().getId() == (productoId));
	        return rto.save(user);
	    }
}
