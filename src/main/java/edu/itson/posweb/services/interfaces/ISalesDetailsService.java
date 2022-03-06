package edu.itson.posweb.services.interfaces;

import edu.itson.posweb.entities.SaleDetail;

import java.util.List;

public interface ISalesDetailsService {
    List<SaleDetail> getAll();
    List<SaleDetail> getAllBySale(Long saleId);
    SaleDetail get(Long id);
}
