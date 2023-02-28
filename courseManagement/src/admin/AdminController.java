package admin;

import dto.Student;

import java.util.List;

public class AdminController implements adminControllerCallBack, adminModelCallBack {
    private adminLoginViewCallBack viewObj;
    private adminModelCallBack modelObj;


    public AdminController(adminLoginViewCallBack viewObj) {
        this.viewObj = viewObj;
        modelObj = new AdminModel(this);
    }

    @Override
    public void decideOption(int option) {
        switch (option) {
            case 1:
                viewObj.addCourse();
                break;
            case 2:
                viewObj.deleteCourse();
                break;
            case 3:
                viewObj.exit();
                break;
            default:
                viewObj.welcome();
                break;
        }
    }

    @Override
    public boolean addCourse(String courseName, String trainerName, List<Student> student, int duration, String startDate, String endDate, String startTime, String endTime, int noOfStudents, int amountCollected, int fee) {
        return modelObj.addCourse(courseName, trainerName, student, duration, startDate, endDate, startTime, endTime, noOfStudents, amountCollected, fee);
    }

    @Override
    public boolean deleteCourse(String courseName) {
        return modelObj.deleteCourse(courseName);
    }
}

