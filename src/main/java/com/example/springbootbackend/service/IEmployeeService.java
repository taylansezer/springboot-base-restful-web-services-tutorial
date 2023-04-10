package com.example.springbootbackend.service;

import com.example.springbootbackend.model.Employee;

import java.util.List;

public interface IEmployeeService {
    Employee saveEmployee(Employee employee);
    List<Employee> getAllEmployees();

    Employee getEmployeeById(long id);

    Employee updateEmployee(Employee employee,long id);


    void deleteEmployee(Long id);
}
