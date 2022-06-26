package com.foxpro.employee.controller;


import com.foxpro.employee.domain.Employee;
import com.foxpro.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @PostMapping("/createEmployee")
    ResponseEntity createEmployee(@RequestBody Employee employee) {
        return new ResponseEntity(employeeService.createEmployee(employee), HttpStatus.MULTI_STATUS.OK);
    }

    @GetMapping("/getEmployee/{employeeId}")
    ResponseEntity getEmployee(@PathVariable("employeeId") int employeeId) {
        return new ResponseEntity(employeeService.getEmployee(employeeId), HttpStatus.MULTI_STATUS.OK);
    }

    @GetMapping("/getEmployee")
    ResponseEntity getAllEmployees() {
        return new ResponseEntity(employeeService.getAllEmployees(), HttpStatus.MULTI_STATUS.OK);
    }

    @PutMapping("/updateEmployee/{employeeId}")
    ResponseEntity updateEmployee(@RequestBody Employee employee, @PathVariable("employeeId") int employeeId) {
        return new ResponseEntity(employeeService.updateEmployee(employee, employeeId), HttpStatus.MULTI_STATUS.OK);
    }

    @DeleteMapping("/deleteEmployee/{employeeId}")
    ResponseEntity deleteEmployee(@PathVariable("employeeId") int employeeId) {
        employeeService.deleteEmployee(employeeId);
        Employee deletedEmployee = new Employee();
        deletedEmployee.setEmployeeId(employeeId);
        return new ResponseEntity<>(deletedEmployee, HttpStatus.OK);

    }


}

