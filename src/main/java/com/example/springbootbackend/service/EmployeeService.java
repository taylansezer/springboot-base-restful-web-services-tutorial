package com.example.springbootbackend.service;

import com.example.springbootbackend.exception.ResourceNotFoundException;
import com.example.springbootbackend.model.Employee;
import com.example.springbootbackend.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService implements IEmployeeService{

    @Autowired
    private EmployeeRepository employeeRepository;


    @Override
    public Employee saveEmployee(Employee employee)
    {

        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(long id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        if (employee.isPresent()){
            return employee.get();
        }else {
            throw new ResourceNotFoundException("Employee","Id",id);
        }
    }

    @Override
    public Employee updateEmployee(Employee employee, long id) {

        Employee updatedEmployee = employeeRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Employee","Id",id));

        updatedEmployee.setFirstName(employee.getFirstName());
        updatedEmployee.setLastName(employee.getLastName());
        updatedEmployee.setEmail(employee.getEmail());

        employeeRepository.save(updatedEmployee);

        return updatedEmployee;
    }

    @Override
    public void deleteEmployee(Long id)
    {

        Optional<Employee> employee = employeeRepository.findById(id);
        if (employee.isPresent()){
            employeeRepository.deleteById(id);
        }else {
            throw new ResourceNotFoundException("Employee","Id",id);
        }
    }

}
