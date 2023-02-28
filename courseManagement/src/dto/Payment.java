package dto;

import java.util.ArrayList;
import java.util.List;

public class Payment {
    public static List<Student> getStudentsList() {
        return studentsList;
    }

    public void setStudentsList(List<Student> studentsList) {
        this.studentsList = studentsList;
    }

    private static List<Student> studentsList = new ArrayList<>();


}
