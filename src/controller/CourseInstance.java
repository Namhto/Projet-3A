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

    public CourseInstance(String teacher, String promo, String room, String course, int time) {
        this.teacher = teacher;
        this.promo = promo;
        this.room = room;
        this.course = course;
        this.time = time;
    }
}
