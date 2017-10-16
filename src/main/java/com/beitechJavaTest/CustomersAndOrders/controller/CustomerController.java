/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.beitechJavaTest.CustomersAndOrders.controller;

import com.beitechJavaTest.CustomersAndOrders.dataWrappers.OrderDetailsWrapper;
import com.beitechJavaTest.CustomersAndOrders.exception.CustomerException;
import com.beitechJavaTest.CustomersAndOrders.model.Orden;
import com.beitechJavaTest.CustomersAndOrders.model.OrdenDetail;
import com.beitechJavaTest.CustomersAndOrders.servicesFacade.CustomerServices;
import com.beitechJavaTest.CustomersAndOrders.servicesFacade.OrdenServices;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Andrés Felipe
 */

@RestController
@RequestMapping(value = "/customer")
public class CustomerController {
    
    /**
     * Instancia de fachada de servicios con soporte a JPA
     */
    @Autowired
    private CustomerServices customerServices;
    
    @RequestMapping(method = RequestMethod.POST, path = "/{customerId}/orden")
    public ResponseEntity<?> newOrderToCustomer(@PathVariable Long customerId, @RequestBody OrderDetailsWrapper order){
        ResponseEntity<?> ans;
        try {
            Integer resp=customerServices.newOrderToCustomer(customerId, order.getOrden());
            order.getDetails().forEach((detail) -> {
                detail.getOrden().setOrder_id(resp);
            });
            customerServices.saveOrderDetails(order.getDetails());
            ans=new ResponseEntity<>(resp, HttpStatus.ACCEPTED);
        } catch (CustomerException ex) {
            ans=new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ans;
    }
    
    @RequestMapping(method = RequestMethod.POST, path = "/{customerId}/orden/details")
    public ResponseEntity<?> saveOrderDetails(@PathVariable Long customerId, @RequestBody List<OrdenDetail> details){
        ResponseEntity<?> ans;
        try {
            customerServices.saveOrderDetails(details);
            ans= new ResponseEntity<>(HttpStatus.ACCEPTED);
        } catch (CustomerException ex) {
            ans = new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ans;
    }
    
    @RequestMapping(method = RequestMethod.GET, path = "/{customerId}/orden")
    public ResponseEntity<?> getOrdersByCustomerInRange(@PathVariable Long customerId, @RequestParam(value = "from", required = true) @DateTimeFormat(pattern = "dd-MM-yyyy") Date fromDate, @RequestParam(value = "to", required = true) @DateTimeFormat(pattern = "dd-MM-yyyy") Date toDate){
        ResponseEntity<?> ans;
        try {
            ans=new ResponseEntity<>(customerServices.getOrdersByCustomerInRange(customerId, fromDate, toDate), HttpStatus.ACCEPTED);
        } catch (CustomerException ex) {
            ans=new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ans;
    }
    
    
    @RequestMapping(method = RequestMethod.GET, path = "/{customerId}")
    public ResponseEntity<?> getCustomer(@PathVariable Long customerId){
        ResponseEntity<?> ans;
        try {
            ans= new ResponseEntity<>(customerServices.getCustomer(customerId), HttpStatus.ACCEPTED);
        } catch (CustomerException ex) {
            ans= new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ans;
    }
    
    @RequestMapping(method = RequestMethod.GET, path = "/{customerId}/orden/details")
    public ResponseEntity<?> getAllOrderDetailsByCustomer(@PathVariable Long customerId){
        ResponseEntity<?> ans;
        List<OrdenDetail> details=new ArrayList<>();
        try {
            for (Orden orden : customerServices.getAllOrdersOfCustomer(customerId)) {
                orden.getOrden_detail().forEach((ordenDetail) -> {
                    details.add(ordenDetail);
                });
            }
            ans= new ResponseEntity<>(details, HttpStatus.ACCEPTED);
        } catch (CustomerException ex) {
            ans= new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ans;
    }
}
