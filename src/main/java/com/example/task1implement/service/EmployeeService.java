package com.example.task1implement.service;

import com.example.task1implement.model.Employee;

import java.util.List;

public interface EmployeeService {
    Employee saveEmployee(Employee employee);
    List<Employee> getAllEmployees();
    Employee getEmployeeByID(long id);
    Employee updateEmployee(Employee employee, long id);
    void deleteEmployee(long id);
}
