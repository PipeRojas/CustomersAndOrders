/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.beitechJavaTest.CustomersAndOrders.controller;

import com.beitechJavaTest.CustomersAndOrders.servicesFacade.OrdenServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Andrés Felipe
 */

@RestController
@RequestMapping(value = "/orden")
public class OrdenController {
    
    /**
     * Instancia de fachada de servicios con soporte a JPA
     */
    @Autowired
    private OrdenServices ordenServices;
    
    @RequestMapping(method = RequestMethod.GET, path = "/{ordenId}/detail")
    public ResponseEntity<?> getOrdenDetailsByOrdenId(@PathVariable Integer ordenId){
        return new ResponseEntity<>(ordenServices.getOrdenDetailsByOrdenId(ordenId), HttpStatus.ACCEPTED);
    }
}
