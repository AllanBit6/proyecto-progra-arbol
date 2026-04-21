/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.proyectoprograarbol.dao;

import com.mycompany.proyectoprograarbol.persistence.entities.Customer;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface ICustomerRepository {

    /**
     * Obtiene todos los clientes almacenados en la base de datos.
     *
     * @return Lista de todos los clientes.
     * @throws RuntimeException si ocurre un error al consultar la información.
     */
    List<Customer> findAllCustomers();

    /**
     * Sincroniza la lista de clientes con la base de datos.
     *
     * Actualiza los clientes
     * Elimina clientes
     * inserta clientes
     *
     * @param customers Lista de clientes a sincronizar.
     * @return true si la operación se realiza correctamente.
     * @throws RuntimeException si ocurre algún error durante la transacción.
     */
    boolean syncCustomers(List<Customer> customers);

}
