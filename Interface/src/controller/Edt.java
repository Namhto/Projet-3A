package controller;

import Model.Teacher;
import javafx.collections.ObservableList;

/**
 * Created by maxime on 08/12/2016.
 */
public class Edt {

    private ObservableList<Teacher> teachers;

    public ObservableList<Teacher> getTeachers() {
        return teachers;
    }

    public void setProfessors(ObservableList<Teacher> teachers) {
        this.teachers = teachers;
    }


    public void populate(){
        Teacher p1 = new Teacher("Perronne");
        Teacher p2 = new Teacher("Hassenforder");

        teachers.add(p1);
        teachers.add(p2);
    }
}
