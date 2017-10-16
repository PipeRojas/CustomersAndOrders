/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.beitechJavaTest.CustomersAndOrders.servicesFacade;

import com.beitechJavaTest.CustomersAndOrders.model.OrdenDetail;
import com.beitechJavaTest.CustomersAndOrders.repository.OrdenDetailRepository;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Andrés Felipe
 */
@Service
public class OrdenServicesJpaImplementation implements OrdenServices{
    @Autowired
    private OrdenDetailRepository detailRepository;

    @Override
    public Set<OrdenDetail> getOrdenDetailsByOrdenId(Integer ordenId) {
        return detailRepository.getDetailsByOrderId(ordenId);
    }
    
}
