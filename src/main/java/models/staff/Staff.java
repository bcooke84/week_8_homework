package models.staff;

import team.Team;

import javax.persistence.*;
import java.util.GregorianCalendar;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "staff_members")
public abstract class Staff {
    private int id;
    private String name;
    private int salary;
    private int age;
    private GregorianCalendar contractStart;
    private GregorianCalendar contractEnd;


    public Staff() {
    }

    public Staff(String name, int salary, int age, GregorianCalendar contractStart, GregorianCalendar contractEnd) {
        this.name = name;
        this.salary = salary;
        this.age = age;
        this.contractStart = contractStart;
        this.contractEnd = contractEnd;
    }

    @Id
    @GeneratedValue
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Column(name = "salary")
    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Column(name = "age")
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Column(name = "contractStart")
    public GregorianCalendar getContractStart() {
        return contractStart;
    }

    public void setContractStart(GregorianCalendar contractStart) {
        this.contractStart = contractStart;
    }

    @Column(name = "contractEnd")
    public GregorianCalendar getContractEnd() {
        return contractEnd;
    }

    public void setContractEnd(GregorianCalendar contractEnd) {
        this.contractEnd = contractEnd;
    }
}
