package com.mycompany.proyectoprograarbol;

import com.mycompany.proyectoprograarbol.persistence.entities.Customer;
import com.mycompany.proyectoprograarbol.persistence.hibernate.HibernateUtil;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class ProyectoPrograArbol {

    public static void main(String[] args) {
        System.out.println("Probando David x Jhon");

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            
            Customer customer = new Customer(null,"David");
            session.persist(customer);
            
            List<Customer> usuarios = session
                    .createQuery("FROM Customer", Customer.class)
                    .getResultList();

            for (Customer u : usuarios) {
                System.out.println(u.getName());
            }

            session.getTransaction().commit();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
