package edu.itson.posweb.services.interfaces;

import edu.itson.posweb.entities.Client;
import edu.itson.posweb.entities.Sale;

import java.util.List;

public interface IClientsService {
    List<Client> getAll();
    Client get(Long id);
    Client create(Client client);
    Client update(Client client);
    Client delete(Long id);
}
