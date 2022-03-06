package edu.itson.posweb.graphql.services;

import edu.itson.posweb.graphql.datafetchers.AllClientsDataFetcher;
import edu.itson.posweb.graphql.datafetchers.ClientDataFetcher;
import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeDefinitionRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;

/***
 * This class sets up the GraphQL environment, also map the schema Queries with Data Fetchers
 */
@Service
public class GraphQLService {

    @Value("classpath:schema/projectschema.graphqls")
    Resource graphqlSchemaResource;

    private GraphQL graphQL;
    @Autowired
    private AllClientsDataFetcher allClientsDataFetcher;
    @Autowired
    private ClientDataFetcher clientDataFetcher;

    /**
     * Sets up the graphql schema from .graphqls file
     * @throws IOException
     */
    @PostConstruct
    public void loadSchema() throws IOException {
        // load the graphql schema file
        File graphqlSchemaFile = graphqlSchemaResource.getFile();
        TypeDefinitionRegistry typeRegistry = new SchemaParser().parse(graphqlSchemaFile);
        RuntimeWiring wiring = buildRuntimeWiring();
        GraphQLSchema schema = new SchemaGenerator().makeExecutableSchema(typeRegistry, wiring);
        graphQL = GraphQL.newGraphQL(schema).build();
    }

    /**
     * Map the graphql schema Queries with Data Fetchers (spring boot services)
     * @return mapping
     */
    private RuntimeWiring buildRuntimeWiring() {
        return RuntimeWiring.newRuntimeWiring()
                .type("Query", typeWiring-> {
                    return typeWiring
                        .dataFetcher("allClients", allClientsDataFetcher)
                        .dataFetcher("client", clientDataFetcher);
                })
                .build();
    }

    public GraphQL getGraphQL(){
        return this.graphQL;
    }

}
