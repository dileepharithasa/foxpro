package com.foxpro.employee.service;

import com.foxpro.employee.domain.Employee;
import com.foxpro.employee.entities.EmployeeEntity;
import com.foxpro.employee.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    public Employee createEmployee(Employee employee) {
        EmployeeEntity employeeEntity = new EmployeeEntity();
        employeeEntity.setEmployeeId(employee.getEmployeeId());
        employeeEntity.setEmployeeName(employee.getEmployeeName());
        employeeEntity.setEmployeeSalary(employee.getEmployeeSalary());
        EmployeeEntity savedEntity = employeeRepository.save(employeeEntity);

        Employee savedEmployee = new Employee();
        savedEmployee.setEmployeeId(savedEntity.getEmployeeId());
        savedEmployee.setEmployeeName(savedEntity.getEmployeeName());
        savedEmployee.setEmployeeSalary(savedEntity.getEmployeeSalary());

        return savedEmployee;
    }

    public Employee getEmployee(int employeeId) {
        Optional<EmployeeEntity> employeeEntity = employeeRepository.findById(employeeId);
        Employee emp = new Employee();
        if (employeeEntity.isPresent()) {
            emp.setEmployeeId(employeeEntity.get().getEmployeeId());
            emp.setEmployeeName(employeeEntity.get().getEmployeeName());
            emp.setEmployeeSalary(employeeEntity.get().getEmployeeSalary());
        }
        return emp;
    }

    public List<Employee> getAllEmployees() {
       List<EmployeeEntity> employeeEntityList = employeeRepository.findAll();
       List<Employee> employeeList = new ArrayList<>();
        for (EmployeeEntity employeeEntity : employeeEntityList) {
            Employee emp = new Employee();
            emp.setEmployeeId(employeeEntity.getEmployeeId());
            emp.setEmployeeName(employeeEntity.getEmployeeName());
            emp.setEmployeeSalary(employeeEntity.getEmployeeSalary());
            employeeList.add(emp);
        }
        return employeeList;
    }




    public Employee updateEmployee(Employee employee, int employeeId) {

        EmployeeEntity updateEntity = new EmployeeEntity();
        updateEntity.setEmployeeId(employee.getEmployeeId());
        updateEntity.setEmployeeName(employee.getEmployeeName());
        updateEntity.setEmployeeSalary(employee.getEmployeeSalary());
        EmployeeEntity savedEntity = employeeRepository.save(updateEntity);

        Employee savedEmployee = new Employee();
        savedEmployee.setEmployeeId(savedEntity.getEmployeeId());
        savedEmployee.setEmployeeName(savedEntity.getEmployeeName());
        savedEmployee.setEmployeeSalary(savedEntity.getEmployeeSalary());

        return savedEmployee;

    }

    public void deleteEmployee(int employeeId) {
        employeeRepository.deleteById(employeeId);
    }
}
