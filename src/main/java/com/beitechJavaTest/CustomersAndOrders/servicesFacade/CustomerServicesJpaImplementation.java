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
import com.beitechJavaTest.CustomersAndOrders.model.OrdenDetailId;
import com.beitechJavaTest.CustomersAndOrders.repository.CustomerRepository;
import com.beitechJavaTest.CustomersAndOrders.repository.OrdenDetailRepository;
import com.beitechJavaTest.CustomersAndOrders.repository.OrdenRepository;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Andrés Felipe
 */
@Service
@Transactional
public class CustomerServicesJpaImplementation implements CustomerServices{
    
    @Autowired
    private CustomerRepository customerRepository;
    
    @Autowired
    private OrdenRepository ordenRepository;
    
    @Autowired
    private OrdenDetailRepository detailRepository;
    
    @Override
    public Customer getCustomer(Long id) throws CustomerException {
        Customer ans;
        if(customerRepository.exists(id)){
            ans=customerRepository.findOne(id);
        }else{
            throw new CustomerException("El cliente no se encuentra registrado");
        }
        return ans;
    }

    @Override
    public void updateCustomer(Customer customer) throws CustomerException{
        if(customerRepository.exists(customer.getCustomer_id())){
            customerRepository.save(customer);
        }else{
            throw new CustomerException("El cliente que desea actualizar no está registrado");
        }
    }

    @Override
    public Integer newOrderToCustomer(Long customerId, Orden order) throws CustomerException {
        Customer cust=getCustomer(customerId);
        List<Orden> cOrders= cust.getOrdens();
        Orden ord = order;
        ord.setCustomer(cust);
        ord.setCustomer_id(cust.getCustomer_id());
        ord.setDate(order.getDate());
        ord.setDelivery_address(order.getDelivery_address());
        Set<OrdenDetail> orderDetails = new HashSet<>();
        order.getOrden_detail().stream().map((oDet) -> {
            OrdenDetail od=new OrdenDetail();
            od.setProduct_description(oDet.getProduct_description());
            od.setQuantity(oDet.getQuantity());
            od.setOrden(ord);
            od.setProduct(oDet.getProduct());
            OrdenDetailId odPk=new OrdenDetailId();
            odPk.setOrden(ord);
            odPk.setProduct(oDet.getProduct());
            od.setPk(odPk);
            return od;
        }).forEachOrdered((od) -> {
            orderDetails.add(od);
        });
        ord.setOrden_detail(orderDetails);
        cOrders.add(ord);
        cust.setOrdens(cOrders);
        ordenRepository.save(order);
        return order.getOrder_id();
    }

    @Override
    public List<Orden> getOrdersByCustomerInRange(Long customerId, Date fromDate, Date toDate) throws CustomerException {
        List<Orden> ans=new ArrayList<>();
        if(fromDate.before(toDate)){
            ordenRepository.getOrdersByCustomerId(customerId).stream().filter((orden) -> ((orden.getDate().after(sumarRestarDiasFecha(fromDate, -1)))&&(orden.getDate().before(sumarRestarDiasFecha(toDate, 1))))).map((orden) -> {
                Set<OrdenDetail> details= new HashSet<>();

                detailRepository.getDetailsByOrderId(orden.getOrder_id()).forEach((ordenDetail) -> {
                    details.add(ordenDetail);
                });

                orden.setOrden_detail(details);
                return orden;
            }).forEachOrdered((orden) -> {
                ans.add(orden);
            });
        }else{
            throw new CustomerException("Las fechas del parametro no cumplen los requerimientos: from antes de to");
        }
        return ans;
    }

    @Override
    public void newCustomer(Customer customer) throws CustomerException {
        if(customerRepository.exists(customer.getCustomer_id())){
            throw new CustomerException("El cliente ya existe, no puede ser agregado");
        }else{
            customerRepository.save(customer);
        }
    }

    @Override
    public Boolean customerExists(Long customerId) {
        return customerRepository.exists(customerId);
    }
    
    /**
     * Retorna la fecha resultante de sumar/restar dias a fecha
     * @param fecha Fecha inicial
     * @param dias Dias a sumar/restar
     * @return Fecha con dias sumados/(restados si dias<0)
     */
    public Date sumarRestarDiasFecha(Date fecha, int dias){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(fecha);
        calendar.add(Calendar.DAY_OF_YEAR, dias);
        return calendar.getTime();
    }

    @Override
    public Set<Orden> getAllOrdersOfCustomer(Long customerId) throws CustomerException {
        return ordenRepository.getOrdersByCustomerId(customerId);
    }

    @Override
    public void saveOrderDetails(List<OrdenDetail> details) throws CustomerException {
        detailRepository.save(details);
    }
    
}
