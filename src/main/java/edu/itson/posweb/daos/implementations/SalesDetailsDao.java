package edu.itson.posweb.daos.implementations;

import edu.itson.posweb.daos.interfaces.ISalesDetailsDao;
import edu.itson.posweb.entities.SaleDetail;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
@Transactional
public class SalesDetailsDao implements ISalesDetailsDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public SaleDetail get(Long id) {
        return this.entityManager.find(SaleDetail.class, id);
    }

    @Override
    public List<SaleDetail> getAll() {
        String jpqlQuery = "FROM SaleDetail";
        TypedQuery<SaleDetail> query = this.entityManager.createQuery(jpqlQuery, SaleDetail.class);
        return query.getResultList();
    }

    @Override
    public List<SaleDetail> getAllBySale(Long saleId) {
        //String jpqlQuery = "FROM SaleDetail WHERE saleId=:saleId";
        String jpqlQuery = "SELECT sd FROM Sale s JOIN s.details sd WHERE s.id=:saleId";
        TypedQuery<SaleDetail> query = this.entityManager.createQuery(jpqlQuery, SaleDetail.class);
        query.setParameter("saleId", saleId);
        return query.getResultList();
    }
}
