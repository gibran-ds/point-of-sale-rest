package edu.itson.posweb.services.implementations;

import edu.itson.posweb.daos.interfaces.IProductsDao;
import edu.itson.posweb.entities.Product;
import edu.itson.posweb.services.interfaces.IProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductsService implements IProductsService {

    @Autowired
    private IProductsDao productsDao;

    @Override
    public List<Product> getAll() {
        // TODO: BUSINESS LOGIC
        return this.productsDao.getAll();
    }

    @Override
    public Product get(Long id) {
        // TODO: BUSINESS LOGIC
        return this.productsDao.get(id);
    }

    @Override
    public Product create(Product product) {
        // TODO: BUSINESS LOGIC
        return this.productsDao.create(product);
    }

    @Override
    public Product update(Product product) {
        // TODO: BUSINESS LOGIC
        return this.productsDao.update(product);
    }

    @Override
    public Product delete(Long id) {
        // TODO: BUSINESS LOGIC
        return this.productsDao.delete(id);
    }
}
