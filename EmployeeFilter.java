package ra.employeemanagement.model;

public class EmployeeFilter {
    private String name;
    private String department;

    // Constructor rỗng BẮT BUỘC (Spring cần để tạo instance)

    public EmployeeFilter() {
    }

    public EmployeeFilter(String name, String department) {
        this.name = name;
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "EmployeeFilter{" +
                "name='" + name + '\'' +
                ", department='" + department + '\'' +
                '}';
    }
}
