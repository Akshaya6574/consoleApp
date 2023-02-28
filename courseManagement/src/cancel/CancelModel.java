package cancel;

import dto.Course;
import repository.Repository;

import java.util.List;

public class CancelModel implements cancelModelCallBack {
    private cancelControllerCallBack controllerObj;


    public CancelModel(cancelControllerCallBack controllerObj) {
        this.controllerObj = controllerObj;
    }

    public List<Course> cancel(long phoneNumber) {
        return Repository.getInstance().cancel(phoneNumber);
    }

    public boolean cancellation(Course deleteCourse, long phoneNumber) {

        return Repository.getInstance().cancellation(deleteCourse, phoneNumber);

    }
}
