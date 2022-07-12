package com.employee.data.services;

import com.employee.data.Repositories.EmployeeRepo;
import com.employee.data.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService
{
    @Autowired
    private EmployeeRepo emp;

    public Employee add(Employee e)
    {
        return emp.save(e);
    }

    public Employee get(String name) {
        Employee e=emp.findByName(name);
        return e;
    }

    public void update(Employee e, int salary)
    {
        e.setSalary(salary);
        emp.save(e);
    }

    public void delete(Employee e)
    {
        emp.delete(e);
    }
}
