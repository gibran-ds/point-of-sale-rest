package edu.itson.posweb.daos.implementations;

import edu.itson.posweb.daos.interfaces.ISalesDao;
import edu.itson.posweb.entities.Sale;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
@Transactional
public class SalesDao implements ISalesDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Sale> getAll() {
        String jpqlQuery = "FROM Sale";
        TypedQuery<Sale> query = this.entityManager.createQuery(jpqlQuery, Sale.class);
        return query.getResultList();
    }

    @Override
    public Sale get(Long id) {
        return this.entityManager.find(Sale.class, id);
    }

    @Override
    public Sale create(Sale sale) {
        sale.getDetails().forEach(detail -> {
            detail.setSale(sale);
        });
        this.entityManager.persist(sale);
        return sale;
    }

    @Override
    public Sale delete(Long id) {
        Sale sale = this.entityManager.find(Sale.class, id);
        if(sale != null){
            this.entityManager.remove(sale);
            return sale;
        }
        return null;
    }
}
