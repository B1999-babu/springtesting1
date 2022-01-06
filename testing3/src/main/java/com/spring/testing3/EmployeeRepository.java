package com.spring.testing3;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee , Long> {

    Optional<Employee> findByEmail(String email);
}
