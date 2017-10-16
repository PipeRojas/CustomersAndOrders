/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.beitechJavaTest.CustomersAndOrders.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author Andrés Felipe
 */
@Embeddable
public class OrdenDetailId implements Serializable{
    
    
    private Orden orden;
    
    private Product product;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    public Orden getOrden() {
        return orden;
    }

    public void setOrden(Orden orden) {
        this.orden = orden;
    }
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "orden_id")
    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this== o) return true;
        if (o ==null|| getClass() != o.getClass()) return false;

        OrdenDetailId that = (OrdenDetailId) o;

        if (orden !=null?!orden.equals(that.orden) : that.orden !=null) return false;
        if (product !=null?!product.equals(that.product) : that.product !=null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        result = (orden !=null? orden.hashCode() : 0);
        result =31* result + (product !=null? product.hashCode() : 0);
        return result;
    }
}
