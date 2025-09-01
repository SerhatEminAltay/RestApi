package org.example.projedeneme.Service;

import org.example.projedeneme.dto.EmployeeRequest;
import org.example.projedeneme.entity.Employee;
import org.example.projedeneme.exception.EmployeeException;
import org.example.projedeneme.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;


    public List<Employee> getAllEmployee(){
        return employeeRepository.findAll();
    }

    public Employee getEmployeeById(long employeeId) throws EmployeeException {
        var employee = employeeRepository.findById(employeeId);
        if (employee.isEmpty()) {
            throw new EmployeeException("Id değeri " + employeeId + " olan nesne bulunamadı. " +
                    "Bu sebepten dolayı nesne getirilemedi!");
        }
        return employee.get();
    }

    public Employee saveEmployee(EmployeeRequest employeeRequest){
       Employee employee = new Employee();
       employee.setName(employeeRequest.getName());
       employee.setSurname(employeeRequest.getSurname());
       employee.setEmail(employeeRequest.getEmail());
       employee.setAge(employeeRequest.getBirthYear());
       return employeeRepository.save(employee);
    }

    public Employee updateEmployee(long employeeId, EmployeeRequest employeeRequest) throws EmployeeException {

        var existingEmployee = employeeRepository.findById(employeeId);
        if (existingEmployee.isEmpty()) {
            throw new EmployeeException("Id değeri " + employeeId + " olan nesne bulunamadı. " +
                    "Bu sebepten ötürü nesne güncellenemedi!");
        }
            Employee employee = existingEmployee.get();
            employee.setName(employeeRequest.getName());
            employee.setSurname(employeeRequest.getSurname());
            employee.setEmail(employeeRequest.getEmail());
            employee.setAge(employeeRequest.getBirthYear());
            return employeeRepository.save(employee);
    }

    public void deleteEmployee(long employeeId) throws EmployeeException{
        var employee = employeeRepository.findById(employeeId);
        if (employee.isEmpty()) {
            throw new EmployeeException("Id değeri " + employeeId + " olan nesne bulunamadı. " +
                    "Bu sebepten ötürü nesne silinemedi!");
        }

        employeeRepository.deleteById(employeeId);
    }


}
