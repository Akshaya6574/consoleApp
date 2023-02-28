package login;

import dto.Course;

import java.util.List;

public class LoginController implements loginControllerCallBack, loginModelCallBack {
    private loginViewCallBack viewObj;
    private loginModelCallBack modelObj;

    public LoginController(loginViewCallBack viewObj) {
        this.viewObj = viewObj;
        modelObj=new LoginModel(this);
    }
    public  void decideEnrollOrCancel(int option)
    {
        switch(option)
        {
            case 1:viewObj.showCourse();
            break;
            case 2:viewObj.cancelCourse();
            break;
            default: System.out.println("Improper input");
                break;
        }
    }

    @Override
    public void decideOptions(int option) {
       switch (option)
       {
           case 1:
               viewObj.adminLogin();
               break;
           case 2:
               viewObj.userLogin();
               break;
           case 3:
               viewObj.userSignup();
               break;
           case 4:
               viewObj.teacherLogin();
               break;
           default:
               viewObj.welcome();
               break;
       }
    }

    @Override
    public List<Course> getCourseDetails() {
        return modelObj.getCourseDetails();
    }

    @Override
    public boolean loginCredentials(String username, long phoneNumber, String email) {
        return modelObj.loginCredentials(username,phoneNumber,email);

    }
}
