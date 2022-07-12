package com.employee.data.controller;

import com.employee.data.model.Employee;
import com.employee.data.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class EmployeeController
{
    @Autowired
    private EmployeeService service;

    // add employee
    @PostMapping("/add")
    public Employee addEmployee(@RequestBody Employee emp)
    {
        return service.add(emp);
    }

    //get employee
    @GetMapping("/get{name}")
    public Employee getEmployeeByName(@RequestParam String name)
    {
        return service.get(name);
    }

    //update employee
    @PutMapping("/update{name}{salary}")
    public String updateSalary(@RequestParam String name,int salary)
    {
        Employee emp=service.get(name);
        if(emp!=null)
        {
            service.update(emp,salary);
            return "Updated Successfully";
        }
        return "Error Occurs";
    }


    //delete employee
    @DeleteMapping("/delete{name}")
    public String deleteEmployee(@RequestParam String name)
    {
        Employee emp=service.get(name);
        if(emp!=null)
        {
            service.delete(emp);
            return "Deleted Successfully";
        }
        return "Error Occurs";
    }

}
