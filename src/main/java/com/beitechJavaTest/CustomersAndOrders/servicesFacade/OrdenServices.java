/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.beitechJavaTest.CustomersAndOrders.servicesFacade;

import com.beitechJavaTest.CustomersAndOrders.model.OrdenDetail;
import java.util.Set;

/**
 *
 * @author Andrés Felipe
 */
public interface OrdenServices {
    /**
     * Retorna los detalles pertenecientes a la orden con id ordenId
     * @param ordenId Id de la orden a consultar
     * @return Retorna los detalles pertenecientes a la orden con id ordenId
     */
    public Set<OrdenDetail> getOrdenDetailsByOrdenId(Integer ordenId);
}
