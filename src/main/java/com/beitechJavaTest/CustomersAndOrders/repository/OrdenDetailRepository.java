/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.beitechJavaTest.CustomersAndOrders.repository;

import com.beitechJavaTest.CustomersAndOrders.model.OrdenDetail;
import com.beitechJavaTest.CustomersAndOrders.model.OrdenDetailId;
import java.util.Set;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author Andrés Felipe
 */
public interface OrdenDetailRepository extends CrudRepository<OrdenDetail, OrdenDetailId>{
    @Query("SELECT od FROM OrdenDetail od WHERE od.pk.orden.order_id=:ordenId")
    public Set<OrdenDetail> getDetailsByOrderId(@Param("ordenId") Integer orden_id);
}
