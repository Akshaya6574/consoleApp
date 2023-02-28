package cancel;

import dto.Course;

import java.util.List;

public class CancelController implements cancelControllerCallBack, cancelModelCallBack {
    private cancelLoginViewCallBack viewObj;
    private cancelModelCallBack modelObj;


    public CancelController(cancelLoginViewCallBack viewObj) {
        this.viewObj = viewObj;
        modelObj = new CancelModel(this);
    }

    @Override
    public List<Course> cancel(long phoneNumber) {
        return modelObj.cancel(phoneNumber);
    }

    public Course decideOptions(int option, List<Course> enrolledCourse) {
        return enrolledCourse.get(option - 1);
    }

    @Override

    public boolean cancellation(Course deleteCourse, long phoneNumber) {
        return modelObj.cancellation(deleteCourse, phoneNumber);

    }
}
