package com.spring.demo.employeeprojectwithspringrest.services;

import com.spring.demo.employeeprojectwithspringrest.dao.EmployeeRepo;
import com.spring.demo.employeeprojectwithspringrest.entity.Employee;

import com.spring.demo.employeeprojectwithspringrest.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepo employeeRepo;
    @Autowired
    public EmployeeServiceImpl(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    @Override
    public List<Employee> findAll() {
        return this.employeeRepo.findAll();
    }

    @Override
    public Employee findById(int theId) {
        return  this.employeeRepo.getById(theId);
    }

    @Override
    public void save(Employee theEmployee) {
        this.employeeRepo.save(theEmployee);
    }

    @Override
    public void deleteById(int theId) {
        this.employeeRepo.deleteById(theId);
    }
}
