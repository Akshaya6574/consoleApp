package cancel;

import dto.Course;

import java.util.List;

public interface cancelModelCallBack {
    List<Course> cancel(long phoneNumber);

    boolean cancellation(Course deleteCourse, long phoneNumber);
}
