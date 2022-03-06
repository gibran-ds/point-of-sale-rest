package edu.itson.posweb.services.implementations;

import edu.itson.posweb.daos.interfaces.ISalesDao;
import edu.itson.posweb.entities.Sale;
import edu.itson.posweb.services.interfaces.ISalesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalesService implements ISalesService {

    @Autowired
    private ISalesDao salesDao;

    @Override
    public List<Sale> getAll() {
        // TODO: BUSINESS LOGIC
        return this.salesDao.getAll();
    }

    @Override
    public Sale get(Long id) {
        // TODO: BUSINESS LOGIC
        return this.salesDao.get(id);
    }

    @Override
    public Sale create(Sale sale) {
        // TODO: BUSINESS LOGIC
        return this.salesDao.create(sale);
    }

    @Override
    public Sale delete(Long id) {
        // TODO: BUSINESS LOGIC
        return this.salesDao.delete(id);
    }
}
