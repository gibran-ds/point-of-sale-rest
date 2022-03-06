package edu.itson.posweb.daos.implementations;

import edu.itson.posweb.daos.interfaces.IProductsDao;
import edu.itson.posweb.entities.Product;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
@Transactional
public class ProductsDao implements IProductsDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Product> getAll() {
        String jpqlQuery = "FROM Product";
        TypedQuery<Product> query = this.entityManager.createQuery(jpqlQuery, Product.class);
        return query.getResultList();
    }

    @Override
    public Product get(Long id) {
        return this.entityManager.find(Product.class, id);
    }

    @Override
    public Product create(Product product) {
        this.entityManager.persist(product);
        return product;
    }

    @Override
    public Product update(Product product) {
        Product productSaved = this.entityManager.find(Product.class, product.getId());
        if(productSaved == null){
            return null;
        }
        productSaved.setName(product.getName());
        productSaved.setStock(product.getStock());
        productSaved.setPrice(product.getPrice());
        this.entityManager.persist(productSaved);
        return productSaved;
    }

    @Override
    public Product delete(Long id) {
        Product product = this.entityManager.find(Product.class, id);
        if(product != null){
            this.entityManager.remove(product);
            return product;
        }
        return null;
    }
}
