package com.mycompany.proyectoprograarbol.persistence.entities;
import com.mycompany.proyectoprograarbol.CustomerService.CustomerService;

public class Tree {
    Node raiz = null;
    Customer c = new Customer((long)1,"Yo", "Guatemala", "5", 5000.0);
    
    
    public void insertNode(Customer customer){
        raiz = insertRecursive(raiz, customer);
    }
    
    //obtener la altura del nodo
    private int getHeight(Node node) {
        return (node == null) ? 0 : node.height; 
    }
    
    //obtener el equilibrio de un nodo
    private int getFactorBalance(Node node) {
        return (node == null) ? 0 : this.getHeight(node.left) - this.getHeight(node.right); 
    }
    
    //Actualizar la altura del nodo (incrementa mientras se vayan agregando mas nodos)
    private void updateHeight(Node node) { 
        node.height = 1 + Math.max(this.getHeight(node.left), this.getHeight(node.right)); 
    }
    
    //Rotacion simple a la derecha
    private Node rotateRight(Node desbalanceNode) { 
        Node newFather = desbalanceNode.left; 
        Node subInterTree = newFather.right; 
        
        //Se realiza la rotacion
        newFather.right = desbalanceNode; 
        desbalanceNode.left = subInterTree;
        
        //Actualizar las alturas
        this.updateHeight(desbalanceNode);
        this.updateHeight(newFather);
        
        return newFather; 
    }
    
    //Rotacion simple a la izquierda
    private Node rotateLeft(Node desbalanceNode) { 
        Node newFather = desbalanceNode.right; 
        Node subInterTree = newFather.left; 
        
        //Se realiza la rotacion (ahora a la izquierda)
        newFather.left = desbalanceNode ; 
        desbalanceNode.right = subInterTree; 
        
        //Actualizar las alturas
        this.updateHeight(desbalanceNode);
        this.updateHeight(newFather);
        
        return newFather; 
        
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

        this.updateHeight(current);
        
        //Obtener el equilibrio - rotaciones
        int factoryBalance = this.getFactorBalance(current); 
        
        //Casos de desequilibrio
        if(factoryBalance > 1 && customer.getId() < current.left.data.getId()) {
            return this.rotateRight(current);
        }
        if(factoryBalance < -1 && customer.getId() > current.right.data.getId()) {
            return this.rotateLeft(current);
        }
        if(factoryBalance > 1 && customer.getId() > current.left.data.getId()) {
            current.left = this.rotateLeft(current.left); 
            return this.rotateRight(current);
        }
        if(factoryBalance < -1 && customer.getId() < current.right.data.getId()) {
            current.right = this.rotateRight(current.right);
            return this.rotateLeft(current);
        }
        
        return current;
    }
    
}
