package org.example;

import org.example.model.Employee;
import org.example.util.SessionProvider;
import org.hibernate.Session;
import org.hibernate.Transaction;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {


        Session session = SessionProvider.getSession();

        try {
            Transaction transaction = session.beginTransaction();

            Employee employee = new Employee("JohnDoe", "Doe","Doe@gmail.com");


            session.persist(employee); // Save the employee entity to the database
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            SessionProvider.closeSession(session);
        }

    }
}