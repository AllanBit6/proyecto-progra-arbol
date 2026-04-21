package com.mycompany.proyectoprograarbol.persistence.entities;

public class Node {
    public Node left = null;
    public Node right = null;
    public Customer data = null;
    public int height = 1; 
    
    public Node(){    
    }
    
    public Node(Customer customer){
        this.data = customer;
    }
}
