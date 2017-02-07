package controller;

/**
 * Created by othman on 19/01/2017.
 */
public class CourseInstance {

    public String teacher;
    public String promo;
    public String room;
    public String course;
    public int time;

    public CourseInstance() {

    }

    public CourseInstance(String teacher, String promo, String room, String course, int time) {
        this.teacher = teacher;
        this.promo = promo;
        this.room = room;
        this.course = course;
        this.time = time;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public String getPromo() {
        return promo;
    }

    public void setPromo(String promo) {
        this.promo = promo;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }
}
