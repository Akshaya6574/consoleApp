package login;

import dto.Course;

import java.util.List;

public interface loginModelCallBack {
    List<Course> getCourseDetails();

    boolean loginCredentials(String username, long phoneNumber, String email);
}
