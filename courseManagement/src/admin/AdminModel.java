package admin;

import dto.Student;
import repository.Repository;

import java.util.List;

public class AdminModel implements adminModelCallBack {
    private adminControllerCallBack controllerObj;

    public AdminModel(adminControllerCallBack controllerObj) {
        this.controllerObj = controllerObj;
    }

    @Override
    public boolean addCourse(String courseName, String trainerName, List<Student> student, int duration, String startDate, String endDate, String startTime, String endTime, int noOfStudents, int amountCollected, int fee) {
        return Repository.getInstance().addCourse(courseName, trainerName, student, duration, startDate, endDate, startTime, endTime, noOfStudents, amountCollected, fee);
    }

    @Override
    public boolean deleteCourse(String courseName) {
        return Repository.getInstance().deleteCourse(courseName);
    }
}
