package com.example.task1implement.service;

import com.example.task1implement.exception.ResourceNotExisted;
import com.example.task1implement.model.Employee;
import com.example.task1implement.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;
    public EmployeeServiceImpl(EmployeeRepository employeeRepository){
        super();
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeByID(long id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        if (employee.isPresent()) return employee.get();
        else {
            throw new ResourceNotExisted("Employee", "Id", id);
        }
    }

    @Override
    public Employee updateEmployee(Employee employee, long id) {
        Employee extemployee = employeeRepository.findById(id).orElseThrow(
                () -> new ResourceNotExisted("Employee",
                        "Id", id));
        extemployee.setFirstname(employee.getFirstname());
        extemployee.setLastname(employee.getLastname());
        extemployee.setEmail(employee.getEmail());

        employeeRepository.save(extemployee);

        return extemployee;
    }

    @Override
    public void deleteEmployee(long id) {
        employeeRepository.findById(id).orElseThrow( ()->
                new ResourceNotExisted("Employee",
                        "Id", id));
        employeeRepository.deleteById(id);
    }

}
