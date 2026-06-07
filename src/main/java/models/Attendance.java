package models;

import java.time.LocalDate;
import java.time.LocalTime;
import java.io.Serializable;

public class Attendance implements Serializable {
    private static final long serialVersionUID = 1L;
    private int employeeId;
    private String employeeName;
    private LocalDate date;
    private LocalTime checkIn;
    private LocalTime checkOut;
    private String status;

    public Attendance(
            int employeeId,
            String employeeName,
            LocalDate date,
            LocalTime checkIn,
            LocalTime checkOut,
            String status) {

        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.date = date;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.status = status;
    }

    // GETTERS

    public int getEmployeeId() {
        return employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public LocalDate getDate() {
        return date;
    }

    public LocalTime getCheckIn() {
        return checkIn;
    }

    public LocalTime getCheckOut() {
        return checkOut;
    }

    public String getStatus() {
        return status;
    }

    // SETTER

    public void setCheckOut(LocalTime checkOut) {
        this.checkOut = checkOut;
    }
}
