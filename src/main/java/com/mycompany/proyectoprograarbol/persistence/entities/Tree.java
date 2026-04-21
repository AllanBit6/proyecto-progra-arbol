package com.mycompany.proyectoprograarbol.persistence.entities;

import com.mycompany.proyectoprograarbol.dao.CustomerRepository;
import java.util.ArrayList;
import java.util.List;

public class Tree {

   public  Node raiz = null;
    Customer c = new Customer((long) 1, "Yo", "Guatemala", "5", 5000.0);

    public Node insertNode(Customer customer) {
        raiz = insertRecursive(raiz, customer);
        return raiz;
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
        newFather.left = desbalanceNode;
        desbalanceNode.right = subInterTree;

        //Actualizar las alturas
        this.updateHeight(desbalanceNode);
        this.updateHeight(newFather);

        return newFather;

    }

    private Node insertRecursive(Node current, Customer customer) {

        int customerCode = Integer.parseInt(customer.getCode());

        if (current == null) {
            return new Node(customer);
        }

        int currentCode = Integer.parseInt(current.data.getCode());

        if (customerCode < currentCode) {
            current.left = insertRecursive(current.left, customer);
        } else if (customerCode > currentCode) {
            current.right = insertRecursive(current.right, customer);
        } else {
            System.out.println("ID duplicado");
        }

        this.updateHeight(current);

        int factoryBalance = this.getFactorBalance(current);

        // Balanceos
        if (factoryBalance > 1 && customerCode < Integer.parseInt(current.left.data.getCode())) {
            return this.rotateRight(current);
        }

        if (factoryBalance < -1 && customerCode > Integer.parseInt(current.right.data.getCode())) {
            return this.rotateLeft(current);
        }

        if (factoryBalance > 1 && customerCode > Integer.parseInt(current.left.data.getCode())) {
            current.left = this.rotateLeft(current.left);
            return this.rotateRight(current);
        }

        if (factoryBalance < -1 && customerCode < Integer.parseInt(current.right.data.getCode())) {
            current.right = this.rotateRight(current.right);
            return this.rotateLeft(current);
        }

        return current;
    }

    private Node searchMin(Node node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    private Node deleteNode(Node node, Customer custom) {

        if (node == null) {
            return null;
        }

        int customCode = Integer.parseInt(custom.getCode());
        int nodeCode = Integer.parseInt(node.data.getCode());

        if (customCode < nodeCode) {
            node.left = deleteNode(node.left, custom);
        } else if (customCode > nodeCode) {
            node.right = deleteNode(node.right, custom);
        } else {
            if ((node.left == null) || (node.right == null)) {
                node = (node.left != null) ? node.left : node.right;
            } else {
                Node tempNode = this.searchMin(node.right);
                node.data = tempNode.data;
                node.right = deleteNode(node.right, tempNode.data);
            }
        }

        if (node == null) {
            return null;
        }

        this.updateHeight(node);
        int factoryBalance = this.getFactorBalance(node);

        // ⚖ Casos AVL
        if (factoryBalance > 1 && customCode < Integer.parseInt(node.left.data.getCode())) {
            return this.rotateRight(node);
        }

        if (factoryBalance < -1 && customCode > Integer.parseInt(node.right.data.getCode())) {
            return this.rotateLeft(node);
        }

        if (factoryBalance > 1 && customCode > Integer.parseInt(node.left.data.getCode())) {
            node.left = this.rotateLeft(node.left);
            return this.rotateRight(node);
        }

        if (factoryBalance < -1 && customCode < Integer.parseInt(node.right.data.getCode())) {
            node.right = this.rotateRight(node.right);
            return this.rotateLeft(node);
        }

        return node;
    }

    public Node destroyNode(Customer custom) {
        raiz = this.deleteNode(raiz, custom);
        return raiz;
    }

    public List<Customer> inOrder() {
        List<Customer> result = new ArrayList<>();
        inOrderRecursive(raiz, result);
        return result;
    }

    private void inOrderRecursive(Node node, List<Customer> result) {
        if (node != null) {
            inOrderRecursive(node.left, result);
            result.add(node.data);
            inOrderRecursive(node.right, result);
        }
    }

    public List<Customer> preOrder() {
        List<Customer> result = new ArrayList<>();
        preOrderRecursive(raiz, result);
        return result;
    }

    private void preOrderRecursive(Node node, List<Customer> result) {
        if (node != null) {
            result.add(node.data);
            preOrderRecursive(node.left, result);
            preOrderRecursive(node.right, result);
        }
    }

    public List<Customer> postOrder() {
        List<Customer> result = new ArrayList<>();
        postOrderRecursive(raiz, result);
        return result;
    }

    private void postOrderRecursive(Node node, List<Customer> result) {
        if (node != null) {
            postOrderRecursive(node.left, result);
            postOrderRecursive(node.right, result);
            result.add(node.data);
        }
    }

    public Node update(Customer customer) {
        raiz = deleteNode(raiz, customer);   // eliminar
        raiz = insertRecursive(raiz, customer); // insertar actualizado

        return searchRecursive(raiz, customer);
    }

    public Node searchNode(Customer customer) {
        return searchRecursive(raiz, customer);
    }

    private Node searchRecursive(Node node, Customer customer) {
        if (node == null) {
            return null;
        }

        int searchCode = Integer.parseInt(customer.getCode());
        int nodeCode = Integer.parseInt(node.data.getCode());

        if (searchCode == nodeCode) {
            return node;
        } else if (searchCode < nodeCode) {
            return searchRecursive(node.left, customer);
        } else {
            return searchRecursive(node.right, customer);
        }
    }
}
