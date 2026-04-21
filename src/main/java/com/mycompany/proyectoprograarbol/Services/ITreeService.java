/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectoprograarbol.Services;

import com.mycompany.proyectoprograarbol.persistence.entities.Customer;
import com.mycompany.proyectoprograarbol.persistence.entities.Node;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface ITreeService {
    Node deleteNode(Customer customer);
    Node updateNode(Customer customer);
    Node addNode(Customer customer);
    Node searchNode(Customer customer);
    Node getTreeAsync();
    void saveAsync();
    List<Customer> getInOrder();
    List<Customer> getPostOrder();
    List<Customer> getPreOrder();
    
}
