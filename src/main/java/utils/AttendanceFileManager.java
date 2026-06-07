package utils;

import models.Attendance;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class AttendanceFileManager {

    private static final String FILE_NAME =
            "attendance.dat";

    public static void saveAttendance(
            List<Attendance> attendanceList) {

        try(ObjectOutputStream out =
                    new ObjectOutputStream(
                            new FileOutputStream(FILE_NAME))) {

            out.writeObject(
                    new ArrayList<>(attendanceList)
            );

        } catch(Exception e) {

            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    public static List<Attendance> loadAttendance() {

        try(ObjectInputStream in =
                    new ObjectInputStream(
                            new FileInputStream(FILE_NAME))) {

            return (List<Attendance>)
                    in.readObject();

        } catch(Exception e) {

            return new ArrayList<>();
        }
    }
}
