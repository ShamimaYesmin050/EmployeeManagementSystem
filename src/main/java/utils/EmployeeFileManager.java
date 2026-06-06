package utils;

import models.Employee;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeFileManager {

    private static final String FILE_NAME =
            "employees.dat";

    public static void saveEmployees(
            List<Employee> employees) {

        try(ObjectOutputStream out =
                    new ObjectOutputStream(
                            new FileOutputStream(FILE_NAME))) {

            out.writeObject(
                    new ArrayList<>(employees)
            );

        } catch(Exception e) {

            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    public static List<Employee> loadEmployees() {

        try(ObjectInputStream in =
                    new ObjectInputStream(
                            new FileInputStream(FILE_NAME))) {

            return (List<Employee>)
                    in.readObject();

        } catch(Exception e) {

            return new ArrayList<>();
        }
    }
}