package edu.itson.posweb.graphql.controllers;

import edu.itson.posweb.graphql.services.GraphQLService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * This controller is the single endpoint required by graphql. Maps with graphql.servlet.mapping path provided in
 * the application.properties file
 */
@RequestMapping("/graphql")
@RestController
public class GraphQLController {

    @Autowired
    GraphQLService graphQLService;

    /**
     * The single graphql endpoint is this method
     * @param query a graphql operation
     */
    @PostMapping
    public void execute(@RequestBody String query){
        this.graphQLService.getGraphQL().execute(query);
    }

}
