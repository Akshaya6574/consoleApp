package enroll;

import dto.Course;

import java.util.List;

public interface enrollControllerCallBack {

    List<Course> getCourseDetails();

    Course showCourseDetails(int option, List<Course> course);

    void decideOptions(int option, Course selectedCourse);

    boolean enroll(long phoneNumber, Course selectedCourse);
}
