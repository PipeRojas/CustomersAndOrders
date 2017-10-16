/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.beitechJavaTest.CustomersAndOrders.dataWrappers;

import com.beitechJavaTest.CustomersAndOrders.model.Orden;
import com.beitechJavaTest.CustomersAndOrders.model.OrdenDetail;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Andrés Felipe
 */
public class OrderDetailsWrapper {
    private Orden orden;
    private List<OrdenDetail> details = new ArrayList<>();

    public Orden getOrden() {
        return orden;
    }

    public void setOrden(Orden orden) {
        this.orden = orden;
    }

    public List<OrdenDetail> getDetails() {
        return details;
    }

    public void setDetails(List<OrdenDetail> details) {
        this.details = details;
    }
    
    
}
