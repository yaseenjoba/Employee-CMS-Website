package com.spring.demo.employeeproject.dao;

import com.spring.demo.employeeproject.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;
@Repository
public class EmployeeDAOHibernateImpl implements EmployeeDAO {

    private EntityManager entityManager ;
    @Autowired
    public EmployeeDAOHibernateImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> findAll() {
        Session currentSession = entityManager.unwrap(Session.class);

        // create a query
        Query<Employee> theQuery =
                currentSession.createQuery("from Employee", Employee.class);

        // execute query and get result list
        List<Employee> employees = theQuery.getResultList();

        // return the results
        return employees;
    }

    @Override
    public Employee findById(int theId) {
        Session currentSession = entityManager.unwrap(Session.class);

        Employee Emp =
                currentSession.get(Employee.class,theId);
        return Emp;
    }

    @Override
    public void save(Employee theEmployee) {
        Session currentSession = entityManager.unwrap(Session.class);
        System.out.println(theEmployee.toString());
        currentSession.saveOrUpdate(theEmployee);
    }

    @Override
    public void deleteById(int theId) {
        // get the current hibernate session
        Session currentSession = entityManager.unwrap(Session.class);

        // delete object with primary key
        Query theQuery =
                currentSession.createQuery(
                        "delete from Employee where id=:employeeId");
        theQuery.setParameter("employeeId", theId);

        theQuery.executeUpdate();
    }
}
