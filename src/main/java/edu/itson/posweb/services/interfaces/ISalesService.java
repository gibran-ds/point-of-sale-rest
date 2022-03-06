package edu.itson.posweb.services.interfaces;

import edu.itson.posweb.entities.Sale;

import java.util.List;

public interface ISalesService {
    List<Sale> getAll();
    Sale get(Long id);
    Sale create(Sale sale);
    Sale delete(Long id);
}
