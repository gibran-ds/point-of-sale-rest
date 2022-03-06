package edu.itson.posweb.daos.interfaces;

import edu.itson.posweb.entities.Sale;

import java.util.List;

public interface ISalesDao {
    List<Sale> getAll();
    Sale get(Long id);
    Sale create(Sale sale);
    Sale delete(Long id);
}
