package admin;

import dto.Student;
import login.LoginView;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AdminLoginView implements adminLoginViewCallBack {
    private Scanner sc = new Scanner(System.in);
    private adminControllerCallBack controllerObj;

    public AdminLoginView() {

        controllerObj = new AdminController(this);
    }

    public void welcome() {
        System.out.println("Press 1 --> ADD COURSE");
        System.out.println("Press 2 --> DELETE COURSE");
        System.out.println("Press 3 --> EXIT");

        int option = sc.nextInt();
        controllerObj.decideOption(option);
    }

    public void exit() {
        LoginView loginView = new LoginView();
        loginView.welcome();
    }

    @Override
    public void addCourse() {
        System.out.println("Enter Course Name");
        String courseName = sc.next();
        System.out.println("Enter Trainer Name");
        String trainerName = sc.next();
        List<Student> student = new ArrayList<>();
        System.out.println("Enter Duration");
        int duration = sc.nextInt();
        System.out.println("Enter Start Date(YYY-MM-DD)");
        String startDate = sc.next();
        System.out.println("Enter End Date(YYY-MM-DD)");
        String endDate = sc.next();
        System.out.println("Number Of Students");
        int noOfStudents = sc.nextInt();
        System.out.println("Amount Collected");
        int amountCollected = sc.nextInt();
        System.out.println("Couse Fee");
        int fee = sc.nextInt();
        System.out.println("Enter Start Time(HH:MM)");
        String startTime = sc.next();
        System.out.println("Enter End Time(HH:MM)");
        String endTime = sc.next();
        if (controllerObj.addCourse(courseName, trainerName, student, duration, startDate, endDate, startTime, endTime, noOfStudents, amountCollected, fee)) {
            System.out.println("Successfully Course Added");
        } else {
            System.out.println("Course Could Not Be Added");
        }

    }

    @Override
    public void deleteCourse() {
        System.out.println("Enter Course Name");
        String courseName = sc.next();
        if (controllerObj.deleteCourse(courseName)) {
            System.out.println("Course Deleted");
            welcome();
        } else {
            System.out.println("No Course Found");
            welcome();
        }


    }
}
