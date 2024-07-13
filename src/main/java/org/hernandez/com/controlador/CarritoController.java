package org.hernandez.com.controlador;

import java.util.List;
import java.util.Map;

import org.hernandez.com.modelo.Item;
import org.hernandez.com.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

@RestController
@RequestMapping("/items")
@CrossOrigin
public class CarritoController {

    @Autowired
    private ItemService itemService;
    
	@GetMapping("/{username}")
    public ResponseEntity<List<Item>> getCarrito(@PathVariable String username) {
        return ResponseEntity.ok(itemService.getCarrito(username));
    }

    @PostMapping("/{username}")
    public ResponseEntity<String> addItem(@PathVariable String username, @RequestBody Item itemCarrito) {
    	itemService.addItem(username, itemCarrito);
        return ResponseEntity.ok("Agregado");
    }


    @DeleteMapping("/{username}")
    public ResponseEntity<String> clearCarrito(@PathVariable String username) {
    	itemService.clearCarrito(username);
        return ResponseEntity.ok("Vaciado");
    }
	
    @PutMapping("/{username}/item/{productoId}")
    public ResponseEntity<String> actualizarCantidad(@PathVariable String username, @PathVariable Long productoId, @RequestBody Map<String, Integer> request) {
        int cantidad = request.get("cantidad");
        itemService.actualizarCantidad(username, productoId, cantidad);
        return ResponseEntity.ok("Cantidad Actualizada");
    }
    
    @DeleteMapping("/{username}/item/{productoId}")
    public ResponseEntity<String> eliminarProducto(@PathVariable String username, @PathVariable Long productoId) {
    	itemService.eliminarProducto(username, productoId);
        return ResponseEntity.ok("Eliminado");
    }
}