package enroll;

import dto.Course;
import login.LoginView;

import java.util.List;
import java.util.Scanner;

public class EnrollLoginView implements enrollLoginViewCallBack {
    private Scanner sc = new Scanner(System.in);
    private enrollControllerCallBack controllerObj;

    public EnrollLoginView() {
        controllerObj = new EnrollController(this);

    }

    public void showCourse() {
        int j = 1;//for option purpose
        List<Course> course = controllerObj.getCourseDetails();
        System.out.println("--------------------------------Course Details-----------------------------------------");
        for (int i = 0; i < course.size(); i++) {

            System.out.println("Press" + "  " + (j++) + "-->" + course.get(i).getCourseName() + " " + course.get(i).getDuration());
        }
        int option = sc.nextInt();
        Course selectedCourse = controllerObj.showCourseDetails(option, course);
        showCourseDetails(selectedCourse);
    }

    public void showCourseDetails(Course selectedCourse) {
        System.out.println("Course Id " + selectedCourse.getCourseId());
        System.out.println("Course Name " + selectedCourse.getCourseName());
        System.out.println("Course Duration " + selectedCourse.getDuration());
        System.out.println("Course Starting Date " + selectedCourse.getStartDate());
        System.out.println("Course Ending Date " + selectedCourse.getEndDate());
        System.out.println("Course Start Timing " + selectedCourse.getStartTime());
        System.out.println("Course End Timing " + selectedCourse.getEndTime());
        System.out.println("Trainers Name " + selectedCourse.getTrainersName());
        System.out.println("Course Fee " + selectedCourse.getFee());
        System.out.println("--------------------------------------------------------------------------------------------------------------");
        // deciding payment
        System.out.println("Proceed To Payment");
        System.out.println("Press 1 --> Yes");
        System.out.println("Press 2 --> Show Previous Menu");
        int option = sc.nextInt();
        controllerObj.decideOptions(option, selectedCourse);
    }

    public void enroll(Course selectedCourse) {
        System.out.println("Enter The PhoneNumber");
        long phoneNumber = sc.nextLong();
        if (controllerObj.enroll(phoneNumber, selectedCourse)) {
            System.out.println("Successfully Enrolled");
            LoginView obj = new LoginView();
            obj.welcome();
        } else {
            System.out.println("You Have Already Enrolled For The Course ");
            showCourse();
        }
    }
}
