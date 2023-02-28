package dto;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class Course {
    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getTrainersName() {
        return trainersName;
    }

    public void setTrainersName(String trainersName) {
        this.trainersName = trainersName;
    }

    public List<Student> getStudentsList() {
        return studentsList;
    }

    public void setStudentsList(List<Student> studentsList) {
        this.studentsList = studentsList;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public int getNoOfStudents() {
        return noOfStudents;
    }

    public void setNoOfStudents(int noOfStudents) {
        this.noOfStudents = noOfStudents;
    }

    public int getAmountCollected() {
        return amountCollected;
    }

    public void setAmountCollected(int amountCollected) {
        this.amountCollected = amountCollected;
    }

    public int getFee() {
        return fee;
    }

    public void setFee(int fee) {
        this.fee = fee;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    private String courseId;
    private static int id=1;
    private String courseName;
    private String trainersName;
    private List<Student> studentsList;
    private int duration;
    private LocalDate startDate;
    private LocalDate endDate;
    private int noOfStudents;
    private  int amountCollected;
    private int fee;
    private LocalTime startTime;
    private  LocalTime endTime;


    public Course(String courseName, String trainersName, List<Student> studentsList, int duration, String startDate, String endDate, int noOfStudents, int amountCollected, int fee, String startTime, String endTime) {
        this.courseName = courseName;
        this.trainersName = trainersName;
        this.studentsList = studentsList;
        this.duration = duration;
        LocalDate formattedDate=LocalDate.parse(startDate);
        this.startDate = formattedDate;
        LocalDate endFormattedDate=LocalDate.parse(endDate);
        this.endDate =endFormattedDate ;
        this.noOfStudents = noOfStudents;
        this.amountCollected = amountCollected;
        this.fee = fee;
        LocalTime formattedTime=LocalTime.parse(startTime);
        this.startTime = formattedTime;
        LocalTime endFormattedTime=LocalTime.parse(endTime);
        this.endTime = endFormattedTime;
        courseId=courseName+(id++);
    }
}
