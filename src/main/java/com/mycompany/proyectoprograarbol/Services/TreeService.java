/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectoprograarbol.Services;

import com.mycompany.proyectoprograarbol.dao.CustomerRepository;
import com.mycompany.proyectoprograarbol.dao.ICustomerRepository;
import com.mycompany.proyectoprograarbol.persistence.entities.Customer;
import com.mycompany.proyectoprograarbol.persistence.entities.Node;
import com.mycompany.proyectoprograarbol.persistence.entities.Tree;
import java.util.List;

/**
 *
 * @author Admin
 */
public class TreeService  implements ITreeService{
    private Tree service;
    private ICustomerRepository repository;
    
    public TreeService(){
        service = new Tree();
        repository=new CustomerRepository();
        
    }

    @Override
    public Node deleteNode(Customer customer) {
        return service.destroyNode(customer);
    }

    @Override
    public Node updateNode(Customer customer) {
       return service.update(customer);
    }

    @Override
    public Node addNode(Customer customer) {
       return service.insertNode(customer);
    }

    @Override
    public Node searchNode(Customer customer) {
        return service.searchNode(customer);
    }

    @Override
    public Node getTreeAsync() {
       List<Customer> customers = repository.findAllCustomers();
       
       for(Customer cumstomer: customers){
           service.insertNode(cumstomer);
       }
       return service.raiz;
    }

    @Override
    public void saveAsync() {
        List<Customer> customers = service.inOrder();
        repository.syncCustomers(customers);
    }

    @Override
    public List<Customer> getInOrder() {
       return service.inOrder();
    }

    @Override
    public List<Customer> getPostOrder() {
        return service.postOrder();
    }

    @Override
    public List<Customer> getPreOrder() {
        return service.preOrder();
    }
    
    
    
}
