package ra.employeemanagement.repository;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;
import ra.employeemanagement.model.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class EmloyeeRepository {
    // Giả lập database bằng List
    private final List<Employee> employeeList = new ArrayList<>();
    private Long currentId = 1L;

    //✅ Chạy 1 lần sau khi Bean được khởi tạo → seed data
    @PostConstruct
    public void initData() {
        save(new Employee(null, "Nguyen Van A", "a@example.com", "IT"));
        save(new Employee(null, "Tran Thi B",   "b@example.com", "HR"));
        save(new Employee(null, "Le Van C",     "c@example.com", "Finance"));
        save(new Employee(null, "Pham Thi D",   "d@example.com", "IT"));
    }

    // Lưu nhân viên mới
    public Employee save (Employee employee) {
        employee.setId(currentId++);
        employeeList.add(employee);
        return employee;
    }

    // Lấy tất cả
    public List<Employee> findAll() {
        return new ArrayList<>(employeeList);
    }

    // Tìm theo Id
    public Optional<Employee> findById(Long id) {
        return employeeList.stream()
                .filter(e -> e.getId().equals(id))
                .findFirst();
    }

    // Tìm theo tên ( chứa Keyword, không phân biệt hoa thường )
    public List<Employee> findByName(String name) {
        return employeeList.stream()
                .filter(e -> e.getFullName().toLowerCase().contains(name.toLowerCase()))
                .toList();
    }

    // Tìm theo name + department
    public List<Employee> findByNameAndDepartment(String name, String department) {
        return employeeList.stream()
                .filter(e -> name == null || e.getFullName().toLowerCase().contains(name.toLowerCase()))
                .filter(e -> department == null || e.getDepartment().toLowerCase().contains(department.toLowerCase()))
                .toList();
    }

    // Cập nhật trả về Optional để biết có tìm thấy hay không
    public Optional<Employee> update(Long id, Employee newInfo) {
        return findById(id).map(existing -> {
            existing.setFullName(newInfo.getFullName());
            existing.setId(newInfo.getId());
            existing.getDepartment(newInfo.getDepartment());
            return existing;
        });
    }

    // Xóa - trả về boolean để biết có xóa được không
    public boolean deleteById(Long id) {

        return employeeList.removeIf(e -> e.getId().equals(id));
    }
}
