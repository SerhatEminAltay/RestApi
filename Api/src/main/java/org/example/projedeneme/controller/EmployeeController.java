package org.example.projedeneme.controller;

import org.example.projedeneme.Service.EmployeeService;
import org.example.projedeneme.dto.EmployeeRequest;
import org.example.projedeneme.entity.Employee;
import org.example.projedeneme.exception.EmployeeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/all")
    public ResponseEntity<List<Employee>> getAllEmployee() {
        List<Employee> employees = employeeService.getAllEmployee();
        return new ResponseEntity<>(employees, HttpStatus.OK); // 200 OK ve tüm çalışanları döndür
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getEmployeeById(@PathVariable long id) {
        try {
            Employee employee = employeeService.getEmployeeById(id);
            return new ResponseEntity<>(employee, HttpStatus.OK); // 200 OK ve bulunan çalışanı döndür
        } catch (EmployeeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND); // 404 Not Found ve hata mesajı döndür
        }
    }

    @PostMapping("/save")
    public ResponseEntity<Employee> saveEmployee(@RequestBody EmployeeRequest employeeRequest) {

        Employee savedEmployee = employeeService.saveEmployee(employeeRequest);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED); // 201 Created ve kaydedilen çalışanı döndür
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateEmployee(@PathVariable long id, @RequestBody EmployeeRequest employeeRequest) {
        try {
            Employee updatedEmployee = employeeService.updateEmployee(id, employeeRequest);
            return new ResponseEntity<>(updatedEmployee, HttpStatus.OK); // 200 OK ve güncellenen çalışanı döndür
        } catch (EmployeeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND); // 404 Not Found ve hata mesajı döndür
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable long id) {
        try {
            employeeService.deleteEmployee(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT); // 204 No Content döndür
        } catch (EmployeeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND); // 404 Not Found ve hata mesajı döndür
        }
    }

}