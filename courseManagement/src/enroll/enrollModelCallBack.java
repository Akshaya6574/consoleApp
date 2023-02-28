package enroll;

import dto.Course;

import java.util.List;

public interface enrollModelCallBack {
    List<Course> getCourseDetails();

    boolean enroll(long phoneNumber, Course selectedCourse);
}
