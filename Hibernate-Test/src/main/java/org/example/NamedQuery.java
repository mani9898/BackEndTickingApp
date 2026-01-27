package org.example;

import org.example.util.SessionProvider;
import org.hibernate.Session;
import org.hibernate.query.Query;

public class NamedQuery {

    public static void main(String[] args) {
        Session session = SessionProvider.getSession();
        Query query = session.getNamedQuery("Employee.findAll");
        System.out.println(query.getResultList());
    }

}
