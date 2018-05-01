package hibernateTest;

import hibernateTest.model.Departament;
import hibernateTest.model.Employee;
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
        Employee emp2;
        Departament dep = new Departament();
        dep.setDeptName("X");
        Employee emp = new Employee();
        emp.setFirstName("Tomek");
        emp.setSalary(5505.90);
        emp.setDepartament(dep);
        try{
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.save(dep);
            session.save(emp);
            transaction.commit();
            emp2 = (Employee) session.get(Employee.class, 2l);
            if(emp2!=null)
                System.out.println(emp2.toString());
        }catch(Exception e){

            if(transaction!=null){
                transaction.rollback();
            }
        }finally{
            session.close();
        }
        HibernateUtil.shutdown();
        System.out.println(emp.getId()+" "+emp.getFirstName()+" "+emp.getSalary()+" "+emp.getDepartament().getDeptName());


    }
}
