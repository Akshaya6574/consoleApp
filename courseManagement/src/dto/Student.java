package dto;

import java.util.List;

public class Student {
    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Course> getEnrolledCourse() {
        return enrolledCourse;
    }

    public void setEnrolledCourse(List<Course> enrolledCourse) {
        this.enrolledCourse = enrolledCourse;
    }

    private String studentName;
    private long phoneNumber;
    private String email;
    private List<Course> enrolledCourse;

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    private String studentId;
    private static int id = 100;

    public Student(String studentName, long phoneNumber, String email, List<Course> enrolledCourse) {
        this.studentName = studentName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.enrolledCourse = enrolledCourse;
        studentId = studentName + (id++);
    }

    public Student() {

    }
}
