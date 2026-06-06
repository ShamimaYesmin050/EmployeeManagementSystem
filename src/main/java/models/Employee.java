package models;

import java.io.Serializable;
public class Employee implements Serializable {
    private static final long serialVersionUID = 1L;
    private int id;
    private String name;
    private String department;
    private String email;
    private String phone;
    public Employee(int id,
                    String name,
                    String department,
                    String email,
                    String phone) {

        this.id = id;
        this.name = name;
        this.department = department;
        this.email = email;
        this.phone = phone;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    // ADD THIS HERE
    @Override
    public String toString() {
        return id + " - " + name;
    }
}
