package enroll;

import dto.Course;

import java.util.List;

public class EnrollController implements enrollControllerCallBack, enrollModelCallBack {
    private enrollLoginViewCallBack viewObj;
    private enrollModelCallBack modelObj;

    public EnrollController(enrollLoginViewCallBack viewObj) {
        this.viewObj = viewObj;
        modelObj = new EnrollModel(this);
    }

    public List<Course> getCourseDetails() {
        return modelObj.getCourseDetails();
    }

    public Course showCourseDetails(int option, List<Course> course) {
        return course.get(option - 1);
    }

    public void decideOptions(int option, Course selectedCourse) {
        switch (option) {
            case 1:
                viewObj.enroll(selectedCourse);
                break;
            case 3:
                viewObj.showCourse();
                break;
        }
    }

    @Override
    public boolean enroll(long phoneNumber, Course selectedCourse) {
        return modelObj.enroll(phoneNumber, selectedCourse);
    }
}
