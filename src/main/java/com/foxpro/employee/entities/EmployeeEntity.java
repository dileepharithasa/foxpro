package com.foxpro.employee.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "EMPLOYEE")
public class EmployeeEntity {

    @Column(name = "EMPLOYEE_ID")
    @Id
    int employeeId;

    @Column(name = "EMPLOYEE_NAME")
    String employeeName;

    @Column(name = "EMPLOYEE_SALARY")
    int employeeSalary;

}
