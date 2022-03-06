package edu.itson.posweb.daos.interfaces;

import edu.itson.posweb.entities.Sale;
import java.util.List;

public interface IClientsSalesDao {
    List<Sale> getAll(Long clientId);
    Sale get(Long clientId);
}
