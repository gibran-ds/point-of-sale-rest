package edu.itson.posweb.daos.interfaces;

import edu.itson.posweb.entities.Client;

import java.util.List;

public interface IClientsDao {
    List<Client> getAll();
    Client get(Long id);
    Client create(Client client);
    Client update(Client client);
    Client delete(Long id);
}
