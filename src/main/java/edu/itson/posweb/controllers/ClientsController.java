package edu.itson.posweb.controllers;

import edu.itson.posweb.entities.Client;
import edu.itson.posweb.services.interfaces.IClientsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
public class ClientsController {

    @Autowired
    private IClientsService clientsService;

    @RequestMapping(value = "client/{id}", method = RequestMethod.GET)
    public Client getClient(@PathVariable Long id){
        Client client = this.clientsService.get(id);
        if(client == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return client;
    }

    @RequestMapping(value = "client", method = RequestMethod.GET)
    public List<Client> getClient(){
        List<Client> clients = this.clientsService.getAll();
        return clients;
    }

    @RequestMapping(value = "client", method = RequestMethod.POST)
    public Client createClient(@RequestBody Client client){
        Client clientCreated = this.clientsService.create(client);
        if(client == null){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        return clientCreated;
    }

    @RequestMapping(value = "client", method = RequestMethod.PATCH)
    public Client updateClient(@RequestBody Client client){
        Client clientUpdated = this.clientsService.update(client);
        if(client == null){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        return clientUpdated;
    }

    @RequestMapping(value = "client/{id}", method = RequestMethod.DELETE)
    public Client deleteClient(@PathVariable Long id){
        Client client = this.clientsService.delete(id);
        if(client == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return client;
    }

    @RequestMapping(value = "client/{id}/sales", method = RequestMethod.GET)
    public Client getClientSales(@PathVariable Long id){
        Client client = this.clientsService.get(id);
        if(client == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return client;
    }

}
