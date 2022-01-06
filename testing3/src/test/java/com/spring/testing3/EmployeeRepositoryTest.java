package com.spring.testing3;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class EmployeeRepositoryTest {


    @Autowired
    private EmployeeRepository employeeRepository;


    @Test
    @Order(1)
    @Rollback(value = false)
    public void saveEmployeeTest(){
        Employee employee= Employee.builder()
                .firstName("Baburao")
                .lastName("doog")
                .email("baburao@gmail.com")
                .build();
        employeeRepository.save(employee);


    }
    @Test
    @Order(2)
    public void getEmployeeTest(){
        Employee employee=employeeRepository.getById(1L);

    }

    @Test
    @Order(3)
    public  void getListOfEmployeeTest(){

        List<Employee> employees=employeeRepository.findAll();
    }

    @Test
    @Order(4)
    @Rollback(value = false)
    public void updateofEmployeeTest(){
        Employee employee=employeeRepository.findById(1L).get();
        employee.setEmail("babu@gmail.com");
        Employee EmployeeUpadated=employeeRepository.save(employee);
    }



}