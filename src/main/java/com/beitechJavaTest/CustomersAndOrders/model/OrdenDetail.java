/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.beitechJavaTest.CustomersAndOrders.model;

import java.io.Serializable;
import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author Andrés Felipe
 */
@Entity
@Table(name = "orden_detail")
@AssociationOverrides({
    @AssociationOverride(name = "pk.product", joinColumns = @JoinColumn(name = "product_id")),
    @AssociationOverride(name = "pk.orden", joinColumns = @JoinColumn(name = "orden_id"))
})
public class OrdenDetail implements Serializable{
    
    
    private OrdenDetailId pk=new OrdenDetailId();
    
    
    private String product_description;
    
    
    
    private Integer quantity;
    
    
    @EmbeddedId
    public OrdenDetailId getPk() {
        return pk;
    }

    public void setPk(OrdenDetailId pk) {
        this.pk = pk;
    }
    
    @Transient
    public Orden getOrden() {
        return pk.getOrden();
    }

    public void setOrden(Orden orden) {
        pk.setOrden(orden);
    }
    
    @Transient
    public Product getProduct() {
        return pk.getProduct();
    }

    public void setProduct(Product product) {
        pk.setProduct(product);
    }

    @Column(name = "product_description")
    public String getProduct_description() {
        return product_description;
    }

    public void setProduct_description(String product_description) {
        this.product_description = product_description;
    }

    @Column(name = "quantity")
    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this== o) return true;
        if (o ==null|| getClass() != o.getClass()) return false;

        OrdenDetail that = (OrdenDetail) o;

        return !(getPk() !=null?!getPk().equals(that.getPk()) : that.getPk() !=null);
    }

    @Override
    public int hashCode() {
        return (getPk() !=null? getPk().hashCode() : 0);
    }
}
