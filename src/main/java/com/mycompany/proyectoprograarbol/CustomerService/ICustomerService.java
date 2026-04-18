/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.proyectoprograarbol.CustomerService;

import com.mycompany.proyectoprograarbol.persistence.entities.Customer;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface ICustomerService {
    
    List<Customer> getAll();
    
    //Metodo unico para insertar, actualizar o eliminar
    boolean updateCustomer(List<Customer> customers);
    
}
