package edu.itson.posweb.daos.implementations;

import edu.itson.posweb.daos.interfaces.IClientsSalesDao;
import edu.itson.posweb.entities.Sale;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class ClientsSalesDao implements IClientsSalesDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Sale> getAll(Long clientId) {
        // TODO: QUERY
        return null;
    }

    @Override
    public Sale get(Long clientId) {
        // TODO: QUERY
        return null;
    }
}
