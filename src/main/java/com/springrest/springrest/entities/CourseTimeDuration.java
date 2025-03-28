package com.springrest.springrest.entities;

public class CourseTimeDuration {
    private Long id;
    private String startDate;
    private String endDate;
    private String coursePrice;

    public CourseTimeDuration() {
    }

    public CourseTimeDuration(String startDate, String endDate, String coursePrice) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.coursePrice = coursePrice;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setCoursePrice(String coursePrice) {
        this.coursePrice = coursePrice;
    }

    public String getCoursePrice() {
        return coursePrice;
    }

}
