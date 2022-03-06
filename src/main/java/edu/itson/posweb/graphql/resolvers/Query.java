package edu.itson.posweb.graphql.resolvers;

import edu.itson.posweb.entities.Client;
import edu.itson.posweb.entities.Product;
import edu.itson.posweb.entities.Sale;
import edu.itson.posweb.entities.SaleDetail;
import edu.itson.posweb.services.interfaces.IClientsService;
import edu.itson.posweb.services.interfaces.IProductsService;
import edu.itson.posweb.services.interfaces.ISalesDetailsService;
import edu.itson.posweb.services.interfaces.ISalesService;
import graphql.kickstart.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * This class works like a bridge between GraphQL and Spring Boot.
 * To apply SOLID principles at least we should split each resolver in its own class.
 * NOTE: This can connect directly to Repositories (DAOs) or call Services to reuse
 * the business logic implemented before
 */
@Component
public class Query implements GraphQLQueryResolver {

    @Autowired
    private IClientsService clientsService;
    @Autowired
    private IProductsService productsService;
    @Autowired
    private ISalesService salesService;
    @Autowired
    private ISalesDetailsService salesDetailsService;

    public List<Client> allClients(){
        return this.clientsService.getAll();
    }

    public Client client(int id){
        return this.clientsService.get((long)id);
    }

    public List<Product> allProducts(){
        return this.productsService.getAll();
    }

    public Product product(int id){
        return this.productsService.get((long)id);
    }

    public List<Sale> allSales() { return this.salesService.getAll(); }

    public Sale sale(int id){ return this.salesService.get((long)id); }

    public List<SaleDetail> allSalesDetails() { return this.salesDetailsService.getAll(); }

    public SaleDetail saleDetail(int id){ return this.salesDetailsService.get((long)id); }

}
