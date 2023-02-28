package dto;

import java.util.List;

public class Teacher {
    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public List<Course> getCourseList() {
        return courseList;
    }

    public void setCourseList(List<Course> courseList) {
        this.courseList = courseList;
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

    private String teacherName;
    private List<Course> courseList;
    private long phoneNumber;
    private String email;
    private String teacherId;
    private static int id = 200;

    public Teacher(String teacherName, List<Course> courseList, long phoneNumber, String email) {
        this.teacherName = teacherName;
        this.courseList = courseList;
        this.phoneNumber = phoneNumber;
        this.email = email;
        teacherId = teacherName + (id++);
    }
}
