package org.example.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class SessionProvider {
    private static SessionFactory sessionFactory = null;

    public static Session getSession() {
        if (sessionFactory == null) {
            StandardServiceRegistry register = new StandardServiceRegistryBuilder().configure().build();
            sessionFactory = new MetadataSources(register).buildMetadata().buildSessionFactory();
        }
        return sessionFactory.openSession();
    }

    public static void closeSession(Session session) {
        session.close();
    }
}
