/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.proyectoprograarbol.CustomerService;

import com.mycompany.proyectoprograarbol.entities.Customer;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public interface ICustomerService {
    
    ArrayList<Customer> getAll();
    
    boolean updateCustomer(ArrayList<Customer> customers);
    
}
