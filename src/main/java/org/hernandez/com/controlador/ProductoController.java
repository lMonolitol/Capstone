package org.hernandez.com.controlador;

import java.util.List;


import java.util.Optional;
import org.hernandez.com.modelo.Producto;
import org.hernandez.com.service.ProductoService;
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

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/productos")
public class ProductoController {
	@Autowired
	private ProductoService servicio;
	
	@GetMapping
	 public List<Producto> listar(){
        return servicio.listarProductos();
    }

    @PostMapping("/agregar")
    public Producto agregar(@RequestBody Producto producto){
        return servicio.insertarProducto(producto);
    }

    @DeleteMapping("/eliminar/{id}")
    public void eliminar(@PathVariable int id){
        servicio.eliminarProducto(id);
    }
    
    @GetMapping("/obtener/{id}")
    public ResponseEntity<Producto> obtenerProductoPorId(@PathVariable int id) {
        Optional<Producto> producto = servicio.buscarProducto(id);
        return producto.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/editar/{id}")
    public Producto editar(@PathVariable int id, @RequestBody Producto producto){
        Optional<Producto> p = servicio.buscarProducto(id);
        if(p.isPresent()){
            Producto productoExistente = p.get();
            productoExistente.setNombre(producto.getNombre());
            productoExistente.setDescripcion(producto.getDescripcion());
            productoExistente.setPrecio(producto.getPrecio());
            productoExistente.setStock(producto.getStock());
            productoExistente.setImagen(producto.getImagen());
            return servicio.actualizarProducto(id,productoExistente);
        } else {
            return null;
        }
    }
	
}
