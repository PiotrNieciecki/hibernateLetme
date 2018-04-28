package hibernateTest.model;

import javax.persistence.*;

@Entity
@Table(name="departament")
public class Departament {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column
    private String deptName;

    public Departament(){}

    public long getId(){return id;}
    public void setId(long id){this.id = id;}

    public String getDeptName(){return deptName;}
    public void setDeptName(String deptName){this.deptName = deptName;}
}
