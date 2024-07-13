package org.hernandez.com.interfaces;

import org.hernandez.com.modelo.Producto;



import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface IProducto  extends MongoRepository<Producto, Integer> {

}
