package ra.employeemanagement.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ra.employeemanagement.model.Employee;
import ra.employeemanagement.model.EmployeeFilter;
import ra.employeemanagement.service.EmployeeService;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeControler {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeControler(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    // Test tạm
    @GetMapping
    public List<Employee> getAll() {
        return employeeService.getAllEmployee();
    }

    // ==================== READ ====================
    // API/ lấy chi tiết nhân viên
    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmloyeeById(@PathVariable Long id) {
        return employeeService.getEmployeeById(id)
                .map(ResponseEntity::ok)  // 200 OK nếu tìm thấy
                .orElse(ResponseEntity.notFound().build());  // 404 nếu không có
    }

    // API serch nhân viên theo name
    @GetMapping("/serch")
    public List<Employee> serchEmloyeer(@RequestParam(name = "name") String name) {
        return employeeService.serchByName(name);
    }

    // tìm kiếm nhân viên theo name và department
    @GetMapping("/filter")
    public List<Employee> filterEmployees(@ModelAttribute EmployeeFilter filter) {
        return employeeService.filterEmployees(filter.getName(), filter.getDepartment());
    }


    // ==================== CREATE ====================
    @PostMapping
    public ResponseEntity<Employee> createrEmployee(@RequestBody Employee employee) {
        Employee   created = employeeService.createEmployee(employee);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }


    // ==================== UPDATE ====================
    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployee(
            @PathVariable Long id,
            @RequestBody Employee employee) {

        return employeeService.updateEmployee(id, employee)
                .map(ResponseEntity::ok)     // 200 OK + data mới
                .orElse(ResponseEntity.notFound().build());   // 404 nếu id không tồn tại
    }



    // ==================== DELETE ====================
    @DeleteMapping("/{id}")
    public ResponseEntity<Employee> deleteEmployee(@PathVariable Long id) {
        boolean deleted = employeeService.deleteEmployee(id);
        if (deleted) {
            return ResponseEntity.noContent().build();  // 204 No Content
        }
        return ResponseEntity.noContent().build();      // 404  Not Found
    }
}
