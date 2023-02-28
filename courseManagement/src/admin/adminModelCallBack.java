package admin;

import dto.Student;

import java.util.List;

public interface adminModelCallBack {

    boolean addCourse(String courseName, String trainerName, List<Student> student, int duration, String startDate, String endDate, String startTime, String endTime, int noOfStudents, int amountCollected, int fee);

    boolean deleteCourse(String courseName);
}
