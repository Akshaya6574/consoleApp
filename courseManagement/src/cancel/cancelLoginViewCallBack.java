package cancel;

import dto.Course;

public interface cancelLoginViewCallBack {
    void cancel();

    void cancellation(Course course, long phoneNumber);
}
