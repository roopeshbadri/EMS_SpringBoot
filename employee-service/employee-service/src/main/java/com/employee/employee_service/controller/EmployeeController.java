package com.employee.employee_service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.employee.employee_service.model.Employee;
import com.employee.employee_service.service.EmployeeService;

@CrossOrigin(maxAge = 3360)
@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees")
    public ResponseEntity<List<Employee>> getAllEmployees() {
        return ResponseEntity.ok(employeeService.getAllEmployees());
    }

    @GetMapping("/employees/{employeeId}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("employeeId") Long employeeId) {
        return ResponseEntity.ok(employeeService.getEmployeeById(employeeId));
    }

    @PostMapping("/employees")
    public ResponseEntity<String> createEmployee(@RequestBody Employee employee) {
        String Response = employeeService.addEmployee(employee);
        return ResponseEntity.ok(Response);
    }

    @PatchMapping("/employees/{employeeId}")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee,@PathVariable("employeeId") Long employeeId) {
        Employee empObj=employeeService.getEmployeeById(employeeId);
        if(empObj!=null) {
            empObj.setManager(employee.getManager());
            empObj.setName(employee.getName());
            empObj.setSalary(employee.getSalary());
        }
        return ResponseEntity.ok(employeeService.updateEmployee(empObj));
    }

    @DeleteMapping("/employees/{employeeId}")
    public ResponseEntity<String> updateEmployee(@PathVariable("employeeId") Long employeeId) {

        Employee empObj=employeeService.getEmployeeById(employeeId);
        String deleteMsg=null;
        if(empObj!=null) {
            deleteMsg=employeeService.deleteEmployee(empObj);
        }
        return ResponseEntity.ok(deleteMsg);
    }

}