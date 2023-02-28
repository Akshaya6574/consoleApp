package login;

import dto.Course;

import java.util.List;

public interface loginControllerCallBack {
    void decideOptions(int option);

    List<Course> getCourseDetails();

    boolean loginCredentials(String username, long phoneNumber, String email);

    void decideEnrollOrCancel(int option);
}
