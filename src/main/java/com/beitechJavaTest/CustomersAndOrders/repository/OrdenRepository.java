/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.beitechJavaTest.CustomersAndOrders.repository;

import com.beitechJavaTest.CustomersAndOrders.model.Orden;
import java.util.Set;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author Andrés Felipe
 */
public interface OrdenRepository extends CrudRepository<Orden, Integer>{
    @Query("SELECT orden FROM Orden orden WHERE orden.customer_id=:customerId")
    public Set<Orden> getOrdersByCustomerId(@Param("customerId") Long customer_id);
}
