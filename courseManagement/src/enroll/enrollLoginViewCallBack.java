package enroll;

import dto.Course;

public interface enrollLoginViewCallBack {
    void showCourse();

    void showCourseDetails(Course selectedCourse);

    void enroll(Course selectedCourse);
}
