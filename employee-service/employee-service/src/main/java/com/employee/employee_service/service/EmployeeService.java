package com.employee.employee_service.service;

import com.employee.employee_service.model.Employee;
import java.util.List;
public interface EmployeeService {
    List<Employee> getAllEmployees();
    Employee getEmployeeById(Long employeeId);
    String addEmployee(Employee employee);
    Employee updateEmployee(Employee employee);
    String deleteEmployee(Employee employee);

}
