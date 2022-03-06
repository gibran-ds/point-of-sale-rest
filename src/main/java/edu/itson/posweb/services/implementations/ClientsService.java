package edu.itson.posweb.services.implementations;

import edu.itson.posweb.daos.interfaces.IClientsDao;
import edu.itson.posweb.entities.Client;
import edu.itson.posweb.entities.Sale;
import edu.itson.posweb.services.interfaces.IClientsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ClientsService implements IClientsService {

    @Autowired
    private IClientsDao clientsDao;

    @Override
    public List<Client> getAll() {
        // TODO: BUSINESS LOGIC
        return this.clientsDao.getAll();
    }

    @Override
    public Client get(Long id) {
        // TODO: BUSINESS LOGIC
        return this.clientsDao.get(id);
    }

    @Override
    public Client create(Client client) {
        // TODO: BUSINESS LOGIC
        return this.clientsDao.create(client);
    }

    @Override
    public Client update(Client client) {
        // TODO: BUSINESS LOGIC
        return this.clientsDao.update(client);
    }

    @Override
    public Client delete(Long id) {
        // TODO: BUSINESS LOGIC
        return this.clientsDao.delete(id);
    }
}
