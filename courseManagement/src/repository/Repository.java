package repository;

import dto.*;

import java.util.ArrayList;
import java.util.List;

public class Repository {
    private static Repository repository;
    List<Admin> admin = new ArrayList<>();
    List<Student> student = new ArrayList<>();
    List<Teacher> teacher = new ArrayList<>();
    List<Course> course = new ArrayList<>();
    List<Insight> insight = new ArrayList<>();
    List<Payment> payment = new ArrayList<>();

    private Repository() {

    }

    public static Repository getInstance() {
        if (repository == null) {
            repository = new Repository();
            repository.initialSetup();
        }
        return repository;

    }

    public void initialSetup() {
        student.add(new Student());
        admin.add(new Admin("admin", "zsgs"));
        course.add(new Course("java", "rajeshwari", student, 3, "2023-03-01", "2023-05-01", 0, 0, 5000, "10:30", "10:30"));
        course.add(new Course("ui/ux", "aadhirai", student, 5, "2023-03-01", "2023-07-01", 0, 0, 8000, "10:30", "10:30"));
        course.add(new Course("tally", "adhirai", student, 2, "2023-03-01", "2023-04-01", 0, 0, 3000, "10:30", "10:30"));
        course.add(new Course("fullstack", "rajeshwari", student, 6, "2023-03-01", "2023-08-01", 0, 0, 12000, "10:30", "10:30"));
        List<Course> list = new ArrayList<>();
        list.add(new Course("java", "rajeshwari", student, 3, "2023-03-01", "2023-05-01", 0, 0, 5000, "10:30", "10:30"));
        insight.add(new Insight("akshaya", 9600984051L, "akshayag@gmail.com"));
        student.add(new Student("akshaya", 9600984051L, "akshayag@gmail.com", list));


    }

    public List<Course> getCourseDetails() {
        return course;
    }

    public boolean loginCredentials(String username, long phoneNumber, String email) {
        if (insight.size() == 0) {
            insight.add(new Insight(username, phoneNumber, email));
            return true;

        } else {

            for (Insight in : insight) {
                if (in.getPhoneNumber() == phoneNumber) {
                    return false;
                }

            }
        }
        return insight.add(new Insight(username, phoneNumber, email));

    }

    public boolean enroll(long phoneNumber, Course selectedCourse) {
        boolean value = true;
        for (Student stu : student) {

            if (phoneNumber == stu.getPhoneNumber()) {
                for (Course obj : stu.getEnrolledCourse()) {
                    if (obj.getCourseId().equals(selectedCourse.getCourseId()))
                        return false;
                }
                value = false;
                stu.getEnrolledCourse().add(selectedCourse);
                selectedCourse.getStudentsList().add(stu);
                selectedCourse.setAmountCollected(selectedCourse.getAmountCollected() + selectedCourse.getFee());
                selectedCourse.setNoOfStudents(selectedCourse.getNoOfStudents() + 1);
                Payment.getStudentsList().add(stu);
                return true;
            }

        }
        if (value) {
            for (Insight in : insight) {
                if (phoneNumber == in.getPhoneNumber()) {
                    List<Course> list = new ArrayList<>();
                    list.add(selectedCourse);
                    student.add(new Student(in.getUserName(), in.getPhoneNumber(), in.getEmail(), list));
                    selectedCourse.getStudentsList().add(new Student(in.getUserName(), in.getPhoneNumber(), in.getEmail(), list));
                    selectedCourse.setAmountCollected(selectedCourse.getAmountCollected() + selectedCourse.getFee());
                    selectedCourse.setNoOfStudents(selectedCourse.getNoOfStudents() + 1);
                    Payment.getStudentsList().add(new Student(in.getUserName(), in.getPhoneNumber(), in.getEmail(), list));
                    return true;
                }
            }
        }

        return value;
    }

    public List<Course> cancel(long phoneNumber) {
        for (Student it : Payment.getStudentsList()) {
            if (it.getPhoneNumber() == phoneNumber) {
                return it.getEnrolledCourse();
            }


        }
        return null;
    }

    public boolean cancellation(Course deleteCourse, long phoneNumber) {
        List<Student> delete = deleteCourse.getStudentsList();
        for (Student it : delete) {
            if (it.getPhoneNumber() == phoneNumber) {
                deleteCourse.getStudentsList().remove(it);
                it.getEnrolledCourse().remove(deleteCourse);
                deleteCourse.setNoOfStudents(deleteCourse.getNoOfStudents() - 1);
                deleteCourse.setAmountCollected(deleteCourse.getAmountCollected() - deleteCourse.getFee());
                return true;
            }
        }
        return false;
    }

    public boolean addCourse(String courseName, String trainerName, List<Student> student, int duration, String startDate, String endDate, String startTime, String endTime, int noOfStudents, int amountCollected, int fee) {
        for (Course it : course) {
            if (it.getCourseName().equals(courseName) && it.getStartDate().equals(startDate) && it.getEndDate().equals(endDate))
                return false;

        }
        return course.add(new Course(courseName, trainerName, student, duration, startDate, endDate, noOfStudents, amountCollected, fee, startTime, endTime));
    }

    public boolean deleteCourse(String courseName) {
        for (Course it : course) {
            if (it.getCourseName().equals(courseName))
                course.remove(it);
            for (Student in : it.getStudentsList()) {
                in.getEnrolledCourse().remove(it);
            }
            return true;
        }
        return false;
    }
}
