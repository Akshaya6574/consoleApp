package cancel;

import dto.Course;
import login.LoginView;

import java.util.List;
import java.util.Scanner;

public class CancelLoginView implements cancelLoginViewCallBack {
    private Scanner sc = new Scanner(System.in);
    private cancelControllerCallBack controllerObj;

    public CancelLoginView() {
        controllerObj = new CancelController(this);
    }

    public void cancel() {
        int i = 1;
        System.out.println("Enter The Phone Number");
        long phoneNumber = sc.nextLong();
        List<Course> enrolledCourse = controllerObj.cancel(phoneNumber);
        if (enrolledCourse.size() == 0) {
            System.out.println(" No Course Enrolled ");
        } else {

            for (Course it : enrolledCourse)
                System.out.println("Press " + (i++) + "--> " + it.getCourseName());
        }
        int option = sc.nextInt();
        Course deleteCourse = controllerObj.decideOptions(option, enrolledCourse);
        cancellation(deleteCourse, phoneNumber);
    }

    public void cancellation(Course deleteCourse, long phoneNumber) {
        if (controllerObj.cancellation(deleteCourse, phoneNumber)) {
            System.out.println("Successfully Cancelled");
            LoginView obj = new LoginView();
            obj.welcome();
        } else {
            System.out.println("You have not Enrolled");
            LoginView obj = new LoginView();
            obj.welcome();
        }

    }

}
