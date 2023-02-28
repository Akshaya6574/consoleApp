package enroll;

import dto.Course;
import repository.Repository;

import java.util.List;

public class EnrollModel implements enrollModelCallBack {
    private enrollControllerCallBack controllerObj;

    public EnrollModel(enrollControllerCallBack controllerObj) {
        this.controllerObj = controllerObj;
    }


    public List<Course> getCourseDetails() {
        return Repository.getInstance().getCourseDetails();
    }

    @Override
    public boolean enroll(long phoneNumber, Course selectedCourse) {
        return Repository.getInstance().enroll(phoneNumber, selectedCourse);
    }
}
