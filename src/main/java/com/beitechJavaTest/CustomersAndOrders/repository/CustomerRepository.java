/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.beitechJavaTest.CustomersAndOrders.repository;

import com.beitechJavaTest.CustomersAndOrders.model.Customer;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Andrés Felipe
 */
public interface CustomerRepository extends CrudRepository<Customer, Long>{
}
