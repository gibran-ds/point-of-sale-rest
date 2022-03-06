package edu.itson.posweb.graphql.datafetchers;

import edu.itson.posweb.entities.Client;
import edu.itson.posweb.services.implementations.ClientsService;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;

/**
 * All clients' data provider
 * NOTE: This class works like a bridge between GraphQL and Spring Boot. This can connect directly to
 * Repositories (DAOs) or call Services to reuse the business logic implemented before
 */
@Component
public class AllClientsDataFetcher implements DataFetcher<List<Client>> {

    @Autowired
    private ClientsService clientsService;

    @Override
    public List<Client> get(DataFetchingEnvironment dataFetchingEnvironment) throws Exception {
        return this.clientsService.getAll();
    }
}
