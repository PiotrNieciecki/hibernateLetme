package hibernateTest;

import hibernateTest.dao.EmployeeDAO;
import hibernateTest.dao.hibernate.EmployeeHibernateDao;
import hibernateTest.model.Employee;
import hibernateTest.util.HibernateUtil;


public class app {
    public static void main(String [ ] args)
    {
        EmployeeDAO empd = new EmployeeHibernateDao();
        Employee emp = (Employee) empd.findById(3l);
        System.out.println(emp.toString());
        emp.setSalary(10000);
        empd.update(emp);
        emp = (Employee) empd.findById(3l);
        System.out.println(emp.toString());
        HibernateUtil.shutdown();
    }
}
