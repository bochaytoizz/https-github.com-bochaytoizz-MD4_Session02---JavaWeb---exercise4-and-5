package ra.employeemanagement.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class Employee {
    private Long id;
    private String fullName;
    private String email;
    private String department;


    public Employee() {
    }

    public Employee(Long id, String fullName, String email, String department) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.department = department;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", email='" + email + '\'' +
                ", department='" + department + '\'' +
                '}';
    }


    public void getDepartment(Object department) {
    }
}
