package com.mycompany.proyectoprograarbol.persistence.entities;
import com.mycompany.proyectoprograarbol.CustomerService.CustomerService;

public class Tree {
    Node raiz = null;
    Customer c = new Customer((long)1,"Yo", "Guatemala", "5", 5000.0);
    
    
    public void insertNode(Customer customer){
        raiz = insertRecursive(raiz, customer);
    }
    private Node insertRecursive(Node current, Customer customer){

        if(current == null){
            return new Node(customer);
        }
        if(customer.getId() < current.data.getId()){
            current.left = insertRecursive(current.left, customer);
        } 
        else if(customer.getId() > current.data.getId()){
            current.right = insertRecursive(current.right, customer);
        } 
        else {
            System.out.println("ID duplicado");
        }

        return current;
    }
}
