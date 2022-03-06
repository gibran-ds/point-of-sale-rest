package edu.itson.posweb.services.implementations;

import edu.itson.posweb.daos.interfaces.ISalesDetailsDao;
import edu.itson.posweb.entities.SaleDetail;
import edu.itson.posweb.services.interfaces.ISalesDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalesDetailsService implements ISalesDetailsService {

    @Autowired
    private ISalesDetailsDao salesDetailsDao;

    @Override
    public List<SaleDetail> getAll() {
        // TODO: BUSINESS LOGIC
        return this.salesDetailsDao.getAll();
    }

    @Override
    public List<SaleDetail> getAllBySale(Long saleId) {
        // TODO: BUSINESS LOGIC
        return this.salesDetailsDao.getAllBySale(saleId);
    }

    @Override
    public SaleDetail get(Long id) {
        // TODO: BUSINESS LOGIC
        return this.salesDetailsDao.get(id);
    }
}
