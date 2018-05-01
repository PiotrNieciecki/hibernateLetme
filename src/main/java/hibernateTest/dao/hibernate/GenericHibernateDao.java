package hibernateTest.dao.hibernate;

import hibernateTest.dao.GenericDAO;
import hibernateTest.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class GenericHibernateDao<T, K> implements GenericDAO<T, K>{
    private final Class<T> type;

    public GenericHibernateDao(){
        Type t = getClass().getGenericSuperclass();
        ParameterizedType pt = (ParameterizedType) t;
        type = (Class) pt.getActualTypeArguments()[0];
    }

    @Override
    public void save(T t){
        SessionFactory sessionFactory = getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(t);
        transaction.commit();
        session.close();
    }

    @Override
    public void delete(K id) {
        SessionFactory sessionFactory = getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        T t = (T) session.get(type, (Serializable) id);
        session.delete(t);
        transaction.commit();
    }

    @Override
    public void update(T t){
        SessionFactory sessionFactory = getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(t);
        transaction.commit();
    }

    @Override
    public T findById(K id){
        SessionFactory sessionFactory = getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        T dto = (T) session.get(type, (Serializable) id);
        session.close();
        return dto;
    }

    protected SessionFactory getSessionFactory(){
        return HibernateUtil.getSessionFactory();
    }
}
