package edu.itson.posweb.graphql.datafetchers;

import edu.itson.posweb.entities.Client;
import edu.itson.posweb.services.implementations.ClientsService;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Single client data provider
 * NOTE: This class works like a bridge between GraphQL and Spring Boot. This can connect directly to
 * Repositories (DAOs) or call Services to reuse the business logic implemented before
 */
@Component
public class ClientDataFetcher implements DataFetcher<Client> {

    @Autowired
    private ClientsService clientService;

    @Override
    public Client get(DataFetchingEnvironment dataFetchingEnvironment) throws Exception {
        Long id = dataFetchingEnvironment.getArgument("id");
        return this.clientService.get(id);
    }
}
