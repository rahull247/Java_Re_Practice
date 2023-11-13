package com.practice.hibernate.onetoone;


import javax.persistence.*;

@Entity
@Table(name = "manager_uni")
public class ManagerUni {

    @Id
    @GeneratedValue
    private int id;

    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinTable(name = "manager_department_uni",
            joinColumns = {
                    @JoinColumn(name = "manger_id", referencedColumnName = "id", nullable = false)
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "department_id", referencedColumnName = "id", nullable = false)
            }

    )
    private DepartmentUni department;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DepartmentUni getDepartment() {
        return department;
    }

    public void setDepartment(DepartmentUni department) {
        this.department = department;
    }
}
