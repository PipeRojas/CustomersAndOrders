/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.beitechJavaTest.CustomersAndOrders.servicesFacade;

import com.beitechJavaTest.CustomersAndOrders.exception.CustomerException;
import com.beitechJavaTest.CustomersAndOrders.model.Customer;
import com.beitechJavaTest.CustomersAndOrders.model.Orden;
import com.beitechJavaTest.CustomersAndOrders.model.OrdenDetail;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 *
 * @author Andrés Felipe
 */
public interface CustomerServices {
    /**
     * Entrega el cliente que tenga el ID del parametro
     * @param id del cliente
     * @return cliente con el id del parametro
     * @throws com.beitechJavaTest.CustomersAndOrders.exception.CustomerException Cuando no se encuentre el cliente
     */
    public Customer getCustomer(Long id) throws CustomerException;
    /**
     * Actualiza en la persistencia el cliente del parametro
     * @param customer cliente a actualizar
     * @throws com.beitechJavaTest.CustomersAndOrders.exception.CustomerException Cuando el cliente no esté registrado
     */
    public void updateCustomer(Customer customer) throws CustomerException;
    /**
     * Guarda una orden enlazada al cliente con el ID parametro
     * @param customerId ID del cliente
     * @param order Orden a guardar
     * @throws com.beitechJavaTest.CustomersAndOrders.exception.CustomerException En caso de no encntrar el cliente o que la orden tenga más de 5 productos
     * @return the Integer ID of new order
     */
    public Integer newOrderToCustomer(Long customerId, Orden order) throws CustomerException;
    /**
     * Retorna las ordenes del cliente con ID customerId registradas despues de fromDate y antes de toDate
     * @param customerId ID del cliente
     * @param fromDate Fecha de inicio de rango de ordenes
     * @param toDate Fecha de fin de rango de ordenes
     * @return Ordenes del cliente con ID customerId registradas despues de fromDate y antes de toDate
     * @throws com.beitechJavaTest.CustomersAndOrders.exception.CustomerException 
     */
    public List<Orden> getOrdersByCustomerInRange(Long customerId, Date fromDate, Date toDate) throws CustomerException;
    /**
     * Guarda el nuevo cliente en la base de datos
     * @param customer Cliente a Guardar
     * @throws CustomerException Si el cliente ya existe
     */
    public void newCustomer(Customer customer) throws CustomerException;
    /**
     * Retorna true si el cliente con id customerId está registrado en la base de datos
     * @param customerId ID del cliente a consultar
     * @return true si el cliente con id customerId está registrado en la base de datos
     */
    public Boolean customerExists(Long customerId);
    /**
     * Retorna todas las ordenes del cliente con id customerId
     * @param customerId Id del cliente a consultar
     * @return Ordenes del cliente con id customerId
     * @throws CustomerException 
     */
    public Set<Orden> getAllOrdersOfCustomer(Long customerId) throws CustomerException;
    /**
     * Guarda detalles de una orden con la condición que la orden, el cliente y el producto ta esten registrados
     * @param details Detalles de orden a guardar
     * @throws CustomerException La orden, el cliente y el producto no están registrados
     */
    public void saveOrderDetails(List<OrdenDetail> details) throws CustomerException;
}
