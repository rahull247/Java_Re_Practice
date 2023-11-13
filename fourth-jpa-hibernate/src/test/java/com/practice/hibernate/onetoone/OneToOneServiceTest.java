package com.practice.hibernate.onetoone;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class OneToOneServiceTest {

    @Autowired
    private OneToOneService oneToOneService;


    @Test
    void saveOneToOne() {
        DepartmentUni managerDepartment=new DepartmentUni();
        managerDepartment.setDepartment("Manager");

        DepartmentUni hrDepartment=new DepartmentUni();
        hrDepartment.setDepartment("HR");

        ManagerUni managerUni=new ManagerUni();
        managerUni.setDepartment(managerDepartment);
        managerUni.setName("Rahul");

        ManagerUni managerUni1=new ManagerUni();
        managerUni1.setDepartment(hrDepartment);
        managerUni1.setName("Kunal");

        oneToOneService.saveOneToOne(managerUni);
        oneToOneService.saveOneToOne(managerUni1);
    }
}