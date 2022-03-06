package edu.itson.posweb.daos.implementations;

import edu.itson.posweb.daos.interfaces.IClientsDao;
import edu.itson.posweb.daos.interfaces.IProductsDao;
import edu.itson.posweb.entities.Client;
import edu.itson.posweb.entities.Product;
import edu.itson.posweb.entities.Sale;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
@Transactional
public class ClientsDao implements IClientsDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Client> getAll() {
        String jpqlQuery = "FROM Client";
        TypedQuery<Client> query = this.entityManager.createQuery(jpqlQuery, Client.class);
        return query.getResultList();
    }

    @Override
    public Client get(Long id) {
        return this.entityManager.find(Client.class, id);
    }

    @Override
    public Client create(Client client) {
        this.entityManager.persist(client);
        return client;
    }

    @Override
    public Client update(Client client) {
        Client clientSaved = this.entityManager.find(Client.class, client.getId());
        if(clientSaved == null){
            return null;
        }
        clientSaved.setName(client.getName());
        clientSaved.setPhone(client.getPhone());
        this.entityManager.persist(clientSaved);
        return clientSaved;
    }

    @Override
    public Client delete(Long id) {
        Client client = this.entityManager.find(Client.class, id);
        if(client != null){
            this.entityManager.remove(client);
            return client;
        }
        return null;
    }
}
