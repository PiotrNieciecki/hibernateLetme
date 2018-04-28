package hibernateTest.model;
import javax.persistence.*;

@Entity
@Table(name="employee")
public class Employee {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="firstname")
    private String firstName;

    @Column(name="salary")
    private double salary;

    @JoinColumn(name="departament")
    @ManyToOne
    private Departament departament; //reference to Departament

    public Employee(){}

    public long getId(){return id;}
    public void setId(long id){this.id = id;}

    public String getFirstName(){return firstName;}
    public void setFirstName(String firstName){this.firstName = firstName;}

    public double getSalary(){return salary;}
    public void setSalary(double salary){this.salary = salary;}

    public Departament getDepartament(){return departament;}
    public void setDepartament(Departament departament){this.departament = departament;}
}
