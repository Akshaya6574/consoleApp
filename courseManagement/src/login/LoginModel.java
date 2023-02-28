package login;

import dto.Course;
import repository.Repository;

import java.util.List;

public class LoginModel implements loginModelCallBack {
    private loginControllerCallBack controllerObj;

    public LoginModel(loginControllerCallBack controllerObj) {
        this.controllerObj = controllerObj;
    }

    public List<Course> getCourseDetails() {
        return Repository.getInstance().getCourseDetails();
    }

    public boolean loginCredentials(String username, long phoneNumber, String email) {
        return Repository.getInstance().loginCredentials(username, phoneNumber, email);
    }
}
