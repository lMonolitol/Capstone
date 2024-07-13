package org.hernandez.com.interfaces;

import org.hernandez.com.modelo.Venta;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IVenta extends MongoRepository<Venta, Integer> {

}
