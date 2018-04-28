package hibernateTest.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.*;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;


public class HibernateUtil {
    private static final SessionFactory sessionFactory;

    static{
        try {
            StandardServiceRegistry standardRegistery = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
            Metadata metaData = new MetadataSources(standardRegistery).getMetadataBuilder().build();
            sessionFactory = metaData.getSessionFactoryBuilder().build();
        }catch(Throwable th){
            throw new ExceptionInInitializerError(th);
        }
    }

    public static SessionFactory getSessionFactory(){return sessionFactory;}

    public static void shutdown(){getSessionFactory().close();}
}
