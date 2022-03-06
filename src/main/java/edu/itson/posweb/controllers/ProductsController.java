package edu.itson.posweb.controllers;

import edu.itson.posweb.entities.Product;
import edu.itson.posweb.services.interfaces.IProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
public class ProductsController {

    @Autowired
    private IProductsService productsService;

    @RequestMapping(value = "product/{id}", method = RequestMethod.GET)
    public Product getProduct(@PathVariable Long id){
        Product product = this.productsService.get(id);
        if(product == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return product;
    }

    @RequestMapping(value = "product", method = RequestMethod.GET)
    public List<Product> getProducts(){
        List<Product> products = this.productsService.getAll();
        return products;
    }

    @RequestMapping(value = "product", method = RequestMethod.POST)
    public Product createProduct(@RequestBody Product product){
        Product productCreated = this.productsService.create(product);
        if(product == null){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        return productCreated;
    }

    @RequestMapping(value = "product", method = RequestMethod.PATCH)
    public Product updateProduct(@RequestBody Product product){
        Product productUpdated = this.productsService.update(product);
        if(product == null){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        return productUpdated;
    }

    @RequestMapping(value = "product/{id}", method = RequestMethod.DELETE)
    public Product deleteProduct(@PathVariable Long id){
        Product product = this.productsService.delete(id);
        if(product == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return product;
    }

}
