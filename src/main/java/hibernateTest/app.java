package hibernateTest;

import hibernateTest.model.Departament;
import hibernateTest.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class app {
    public static void main(String [ ] args)
    {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = null;
        Transaction transaction = null;
        Departament dep = new Departament();
        dep.setDeptName("X");
        try{
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.save(dep);
            transaction.commit();
        }catch(Exception e){

            if(transaction!=null){
                transaction.rollback();
            }
        }finally{
            session.close();
        }

    }
}
