package edu.itson.posweb.services.interfaces;

import edu.itson.posweb.entities.Product;

import java.util.List;

public interface IProductsService {
    List<Product> getAll();
    Product get(Long id);
    Product create(Product product);
    Product update(Product product);
    Product delete(Long id);
}
