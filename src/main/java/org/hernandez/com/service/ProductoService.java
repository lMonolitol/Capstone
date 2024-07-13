package org.hernandez.com.service;

import java.util.List;

import java.util.Optional;

import org.hernandez.com.interfaces.IProducto;
import org.hernandez.com.modelo.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class ProductoService {

    @Autowired
    private IProducto rto;
    
    public List<Producto> listarProductos(){
		return rto.findAll();
	}
	public Optional<Producto> buscarProducto(int id) {
		return rto.findById(id);
	}
	public Producto insertarProducto(Producto a)  {	
		int id = autoIncrement(rto.findAll());
		Producto producto = new Producto(id,
				a.getNombre(),
				a.getDescripcion(),
				a.getPrecio(),
				a.getStock(),
				a.getImagen()
				);
		return rto.save(producto);
	}
	public Producto actualizarProducto(int id, Producto a) {
		
		Producto producto = rto.findById(id).orElseThrow();
				
		producto.setNombre(a.getNombre());
		producto.setDescripcion(a.getDescripcion());
		producto.setPrecio(a.getPrecio());
		producto.setStock(a.getStock());
		producto.setImagen(a.getImagen());
		return rto.save(producto);
	}
	
	public Producto eliminarProducto(int id)  {
		Producto pro =  rto.findById(id).orElseThrow();
		rto.delete(pro);
		return pro;
	}
	
	public static int autoIncrement(List<Producto> list) {
		if(list.isEmpty()) {
			return 1;
		}else {
			return list.stream().max(java.util.Comparator.comparing(Producto::getId)).get().getId()+1;
		}
	}
}

