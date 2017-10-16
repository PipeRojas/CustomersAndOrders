/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.beitechJavaTest.CustomersAndOrders.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

/**
 *
 * @author Andrés Felipe
 */
@Entity
public class Customer implements Serializable{
    
    
    private Long customer_id;
    
    
    private String name;
    
    private String email;
    
    
    private List<Orden> ordens = new ArrayList<>();
    
    private Set<Product> customer_available_products=new HashSet<>();
    
    @Id
    @Column(name = "customer_id")
    public Long getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(Long customer_id) {
        this.customer_id = customer_id;
    }
    
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    @OneToMany(fetch = FetchType.EAGER , mappedBy = "customer", orphanRemoval = true)
    @JsonIgnore
    public List<Orden> getOrdens() {
        return ordens;
    }

    public void setOrdens(List<Orden> ordens) {
        this.ordens = ordens;
    }
    
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "customer_available_products",
            joinColumns = {@JoinColumn(name = "customer_id",
                    referencedColumnName = "customer_id", updatable = false, insertable = false
            )},
            inverseJoinColumns = {@JoinColumn(name = "product_id",
                    referencedColumnName = "product_id")})
    public Set<Product> getCustomer_available_products() {
        return customer_available_products;
    }

    public void setCustomer_available_products(Set<Product> customer_available_products) {
        this.customer_available_products = customer_available_products;
    }
    
    
}
