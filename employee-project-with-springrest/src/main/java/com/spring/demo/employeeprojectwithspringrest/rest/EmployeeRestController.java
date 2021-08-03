package com.spring.demo.employeeprojectwithspringrest.rest;

import com.spring.demo.employeeprojectwithspringrest.entity.Employee;
import com.spring.demo.employeeprojectwithspringrest.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
    private EmployeeService employeeService;
    @Autowired
    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    @GetMapping(path="/employee")
    public List<Employee> getAllEmp(){
        return this.employeeService.findAll();
    }
    @GetMapping(path="/employee/{employeeID}")
    public Employee getEmpById(@PathVariable int employeeID){
        return this.employeeService.findById(employeeID);
    }
    @PostMapping(path="/employee")
    public Employee addEmp(@RequestBody Employee Emp){
        this.employeeService.save(Emp);
        return Emp;
    }
    @PutMapping(path="/employee")
    public Employee updateEmp(@RequestBody Employee Emp){
        this.employeeService.save(Emp);
        return Emp;

    }
    @DeleteMapping(path="/employee/{employeeID}")
    public String updateEmp(@PathVariable int employeeID){
        Employee Emp = this.employeeService.findById(employeeID);
        if(Emp == null){
            throw new RuntimeException("Employee id not found - " + employeeID);
        }
        employeeService.deleteById(employeeID);

        return "Deleted employee id - " + employeeID;

    }

}
