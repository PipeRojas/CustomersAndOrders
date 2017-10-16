/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.beitechJavaTest.CustomersAndOrders.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author Andrés Felipe
 */
@Entity
@Table(name = "orden")
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Orden implements Serializable{
    
    
    private Integer orden_id;
    
    private String delivery_address;
    
    private Long customer_id;
    
    private Date date;
    
    
    private Customer customer;
    

    private Set<OrdenDetail> orden_detail=new HashSet<>();
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "orden_id")
    public Integer getOrder_id() {
        return orden_id;
    }

    public void setOrder_id(Integer order_id) {
        this.orden_id = order_id;
    }
    
    @Column(name = "delivery_address")
    public String getDelivery_address() {
        return delivery_address;
    }

    public void setDelivery_address(String delivery_address) {
        this.delivery_address = delivery_address;
    }
    
    @Column(name = "customer_id")
    public Long getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(Long customer_id) {
        this.customer_id = customer_id;
    }
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id", referencedColumnName = "customer_id", insertable = false, updatable = false)
    @JsonIgnore
    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    
    @OneToMany(mappedBy = "pk.orden", fetch = FetchType.EAGER,
    cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JsonIgnore
    public Set<OrdenDetail> getOrden_detail() {
        return orden_detail;
    }

    public void setOrden_detail(Set<OrdenDetail> orden_detail) {
        this.orden_detail = orden_detail;
    }
    
    @Column(name = "`date`")
    @Temporal(javax.persistence.TemporalType.DATE)
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    
    
}
