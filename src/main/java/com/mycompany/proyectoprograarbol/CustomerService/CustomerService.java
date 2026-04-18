/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectoprograarbol.CustomerService;

import com.mycompany.proyectoprograarbol.persistence.entities.Customer;
import com.mycompany.proyectoprograarbol.persistence.hibernate.HibernateUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author Admin
 */
public class CustomerService implements ICustomerService {

    private SessionFactory sessionFactory;

    public CustomerService() {
        sessionFactory = HibernateUtil.getSessionFactory();
    }

    @Override
    public List<Customer> getAll() {
        Transaction transaction = null;

        try (Session session = sessionFactory.openSession();) {
            transaction = session.beginTransaction();

            List<Customer> customers = session
                    .createQuery("FROM Customer", Customer.class)
                    .getResultList();

            transaction.commit();
            return customers;
        } catch (Exception e) {
            System.err.println(e.getMessage());
            throw new RuntimeException("Error Al consultar Clientes", e);

        }
    }

    @Override
    public boolean updateCustomer(List<Customer> customers) {
        Transaction transaction = null;
        Session session = null;

        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();

            List<Customer> customersToUpdate = new ArrayList<>();
            List<Customer> customersToDelete = new ArrayList<>();

            List<Customer> newCustomers = customers.stream()
                    .filter(item -> item.getId() == null).toList();

            List<Customer> customersFiltered = customers.stream()
                    .filter(item -> item.getId() != null).toList();

            List<Customer> currentCustomers = session
                    .createQuery("FROM Customer", Customer.class)
                    .getResultList();

            Map<Long, Customer> map = new HashMap<>();

            for (Customer c : customersFiltered) {
                map.put(c.getId(), c);
            }

            for (Customer cu : currentCustomers) {
                Customer value = map.get(cu.getId());
                if (value != null) {
                    customersToUpdate.add(value);
                } else {
                    customersToDelete.add(cu);
                }
            }

            delete(customersToDelete, session);
            update(customersToUpdate, session);
            create(newCustomers, session);

            transaction.commit();
            return true;

        } catch (Exception e) {

            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }

            throw new RuntimeException("Error al actualizar clientes", e);

        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    private void create(List<Customer> customers, Session session) {
        try {
            int batchSize = 20;

            for (int i = 0; i < customers.size(); i++) {

                session.persist(customers.get(i));

                if (i > 0 && i % batchSize == 0) {
                    session.flush();
                    session.clear();
                }
            }
        } catch (Exception e) {
            throw new RuntimeException("Error al insertar nuevos clientes", e);
        }
    }

    private void update(List<Customer> customers, Session session) {
        try {
            int batchSize = 20;

            for (int i = 0; i < customers.size(); i++) {

                session.merge(customers.get(i));

                if (i > 0 && i % batchSize == 0) {
                    session.flush();
                    session.clear();
                }
            }
        } catch (Exception e) {
            throw new RuntimeException("Error al actualizar clientes", e);
        }
    }

    private void delete(List<Customer> customers, Session session) {
        try {
            int batchSize = 20;

            for (int i = 0; i < customers.size(); i++) {

                session.remove(customers.get(i));

                if (i > 0 && i % batchSize == 0) {
                    session.flush();
                    session.clear();
                }
            }
        } catch (Exception e) {
            throw new RuntimeException("Error al insertar nuevos usuarios", e);
        }
    }

}
