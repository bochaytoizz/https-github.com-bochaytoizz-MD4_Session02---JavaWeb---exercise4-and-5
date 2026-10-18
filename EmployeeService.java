package ra.employeemanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ra.employeemanagement.model.Employee;
import ra.employeemanagement.repository.EmloyeeRepository;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    private final EmloyeeRepository emloyeeRepository;

    // Constructor Injection
    @Autowired
    public EmployeeService (EmloyeeRepository emloyeeRepository) {
        this.emloyeeRepository = emloyeeRepository;
    }

    public Employee createEmployee(Employee employee) {
        // Có thể thêm business logic: validate email, check trùng, ...
        return emloyeeRepository.save(employee);
    }

    public List<Employee> getAllEmployee() {
        return emloyeeRepository.findAll();
    }

    public Optional<Employee> getEmployeeById(Long id) {
        return emloyeeRepository.findById(id);
    }

    public List<Employee> serchByName(String name) {
       return emloyeeRepository.findByName(name);
    }

    public List<Employee> filterEmployees(String name, String department) {
        return emloyeeRepository.findByNameAndDepartment(name, department);
    }

    public Optional<Employee> updateEmployee(Long id, Employee newInfo) {
        return emloyeeRepository.update(id, newInfo);
    }

    public boolean deleteEmployee(Long id) {
        return emloyeeRepository.deleteById(id);
    }

}
