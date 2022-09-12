package com.example.restservice.api;

import com.example.restservice.model.Employee;
import com.example.restservice.model.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class EmployeeController {

    //use a static list to send the list of fruits in the getFruits
    //use the same list if you add a new fruit


    @GetMapping("/employee")
    public List<Employee> getEmployees(@RequestBody Employee employee){
        ArrayList<Employee> emplList = new ArrayList<>();
        emplList.add(new Employee(employee.getId(), employee.getFirstName(), employee.getLastName()));
        return emplList;
    }

    @PostMapping("/employee")
    public Employee sendEmployee(@RequestBody Employee employee){
       return new Employee(employee.getId(), employee.getFirstName(), employee.getLastName());
    }

    //Update

    //DELETE

    //adding exception

}
