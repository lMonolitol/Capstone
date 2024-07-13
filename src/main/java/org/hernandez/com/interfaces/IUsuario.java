package org.hernandez.com.interfaces;


import java.util.Optional;

import org.hernandez.com.modelo.Usuario;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface IUsuario extends MongoRepository<Usuario, Integer>  {
	boolean existsByNombre(String nombre);
	Optional<Usuario> findByNombreOrCorreo(String nombre, String correo);
}
