package edu.itson.posweb.graphql.resolvers;

import edu.itson.posweb.daos.interfaces.ISalesDetailsDao;
import edu.itson.posweb.entities.Sale;
import edu.itson.posweb.entities.SaleDetail;
import edu.itson.posweb.services.interfaces.ISalesDetailsService;
import graphql.kickstart.tools.GraphQLResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * This is necessary when you have a complex relationship like Sale and SaleDetails
 * This way, we tell GraphQL how to resolve the inner field made when the client ask
 * a nested relation
 * Note: the name getDetails() must fallow the naming convention to be linked appropriately
 */
@Component
public class SalesDetailsResolver implements GraphQLResolver<Sale> {

    @Autowired
    private ISalesDetailsDao salesDetailsDao;

    public List<SaleDetail> getDetails(Sale sale){
        return this.salesDetailsDao.getAllBySale(sale.getId());
    }

}
