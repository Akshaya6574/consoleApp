package login;

import admin.AdminLoginView;
import cancel.CancelLoginView;
import enroll.EnrollLoginView;

import java.util.Scanner;

public class LoginView implements loginViewCallBack {
    private Scanner sc = new Scanner(System.in);
    private loginControllerCallBack controllerObj;

    public LoginView() {
        controllerObj = new LoginController(this);
    }

    public static void main(String[] args) {

        LoginView loginView = new LoginView();
        loginView.welcome();

    }

    public void welcome() {
        System.out.println("Press 1 --> Admin");
        System.out.println("Press 2 --> User login");
        System.out.println("Press 3 --> User signup");
        System.out.println("Press 4 --> Teacher");
        int option = sc.nextInt();
        controllerObj.decideOptions(option);
    }

    public void adminLogin() {
        AdminLoginView adminLoginView = new AdminLoginView();
        adminLoginView.welcome();
    }

    public void userLogin() {

        signupDetails();

    }

    public void userSignup() {
        signupDetails();
    }

    public void teacherLogin() {

    }

    public void signupDetails() {
        System.out.println("-------------------------------USER LOGIN----------------------------------------");
        System.out.println("Enter the user_name");
        String username = sc.next();
        System.out.println("Enter the phone_number");
        long phoneNumber = sc.nextLong();
        System.out.println("Enter the email address");
        String email = sc.next();
        if (controllerObj.loginCredentials(username, phoneNumber, email))
            System.out.println("New User Added");
        else
            System.out.println("Existing user");

        enrollOrCancel();

    }

    private void enrollOrCancel() {
        System.out.println("Press 1 --> Show Course ");
        System.out.println("Press 2 --> Cancel");
        int option = sc.nextInt();
        controllerObj.decideEnrollOrCancel(option);

    }


    public void showCourse() {
        EnrollLoginView enrollLoginView = new EnrollLoginView();
        enrollLoginView.showCourse();

    }

    public void cancelCourse() {
        CancelLoginView cancelLoginView = new CancelLoginView();
        cancelLoginView.cancel();
    }


}
