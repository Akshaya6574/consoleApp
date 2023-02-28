package cancel;

import dto.Course;

import java.util.List;

public interface cancelControllerCallBack {
    List<Course> cancel(long phoneNumber);

    Course decideOptions(int option, List<Course> enrolledCourse);

    boolean cancellation(Course deleteCourse, long phoneNumber);
}
