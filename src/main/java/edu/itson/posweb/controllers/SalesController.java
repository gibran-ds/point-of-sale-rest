package edu.itson.posweb.controllers;

import edu.itson.posweb.daos.interfaces.ISalesDao;
import edu.itson.posweb.entities.Sale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
public class SalesController {

    @Autowired
    private ISalesDao salesDao;

    @RequestMapping(value = "sale/{id}", method = RequestMethod.GET)
    public Sale getSale(@PathVariable Long id){
        Sale sale = this.salesDao.get(id);
        if(sale == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return sale;
    }

    @RequestMapping(value = "sale", method = RequestMethod.GET)
    public List<Sale> getSales(){
        List<Sale> sales = this.salesDao.getAll();
        return sales;
    }

    @RequestMapping(value = "sale", method = RequestMethod.POST)
    public Sale createSale(@RequestBody Sale sale){
        Sale saleCreated = this.salesDao.create(sale);
        if(sale == null){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        return saleCreated;
    }

    @RequestMapping(value = "sale/{id}", method = RequestMethod.DELETE)
    public Sale deleteSale(@PathVariable Long id){
        Sale sale = this.salesDao.delete(id);
        if(sale == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return sale;
    }

}
