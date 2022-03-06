package edu.itson.posweb.daos.interfaces;

import edu.itson.posweb.entities.Product;
import java.util.List;

public interface IProductsDao {
    List<Product> getAll();
    Product get(Long id);
    Product create(Product product);
    Product update(Product product);
    Product delete(Long id);
}
