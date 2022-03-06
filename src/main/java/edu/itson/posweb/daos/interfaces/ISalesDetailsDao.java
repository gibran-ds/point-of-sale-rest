package edu.itson.posweb.daos.interfaces;

import edu.itson.posweb.entities.SaleDetail;

import java.util.List;

public interface ISalesDetailsDao {
    List<SaleDetail> getAll();
    List<SaleDetail> getAllBySale(Long saleId);
    SaleDetail get(Long id);
}
