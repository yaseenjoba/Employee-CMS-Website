package com.spring.demo.employeeprojectwithspringrest.dao;

import com.spring.demo.employeeprojectwithspringrest.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;



public interface EmployeeRepo extends JpaRepository<Employee, Integer> {

}
