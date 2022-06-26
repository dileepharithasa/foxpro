package com.foxpro.employee.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    String employeeName;
    int employeeId;
    int employeeSalary;

}
