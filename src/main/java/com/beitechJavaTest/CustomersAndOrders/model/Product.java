/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.beitechJavaTest.CustomersAndOrders.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.List;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 *
 * @author Andrés Felipe
 */
@Entity
@Table(name = "product")
public class Product implements Serializable{
    
    
    private Integer product_id;
    
    
    private String name;
    

    private Integer price;
    
    
    private List<Customer> availableForCostumers;
    
    
    private Set<OrdenDetail> orden_detail;
    
    @Id
    @Column(name = "product_id", nullable = false)
    public Integer getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Integer product_id) {
        this.product_id = product_id;
    }
    
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    @Column(name = "price")
    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
    
    @ManyToMany(mappedBy = "customer_available_products", fetch = FetchType.LAZY)
    @JsonIgnore
    public List<Customer> getAvailableForCostumers() {
        return availableForCostumers;
    }

    public void setAvailableForCostumers(List<Customer> availableForCostumers) {
        this.availableForCostumers = availableForCostumers;
    }
    
    @OneToMany(mappedBy = "pk.product", fetch = FetchType.LAZY)
    @JsonIgnore
    public Set<OrdenDetail> getOrden_detail() {
        return orden_detail;
    }

    public void setOrden_detail(Set<OrdenDetail> orden_detail) {
        this.orden_detail = orden_detail;
    }
    
    
}
