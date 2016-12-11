package controller;

import Model.Curse;
import Model.Item;
import Model.Teacher;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;

/**
 * Created by maxime on 08/12/2016.
 */
public class MainApp {

    private ObservableList<Teacher> teachers = FXCollections.observableArrayList();
    private ObservableList<Curse> curses = FXCollections.observableArrayList();
    private ObservableList<String> items = FXCollections.observableArrayList();


    public ObservableList<Curse> getCurses() {
        return curses;
    }


    public MainApp(){
        Teacher p1 = new Teacher("Perronne");
        Teacher p2 = new Teacher("Hassenforder");
        teachers.add(p1);
        teachers.add(p2);

        Curse c1 = new Curse("Java");

        Curse c2 = new Curse("Android");
        curses.addAll(c1,c2);

        items.add("Teachers");
        items.add("Classes");





    }

    public ObservableList<Teacher> getTeachers() {
        return teachers;
    }


    public void setProfessors(ObservableList<Teacher> teachers) {
        this.teachers = teachers;
    }

    public void setTeachers(ObservableList<Teacher> teachers) {
        this.teachers = teachers;
    }

    public ObservableList<String> getItems() {
        return this.items;
    }

    public void setItems(ObservableList<String> items) {
        this.items = items;
    }

    public void populate(){
        Teacher p1 = new Teacher("Perronne");
        Teacher p2 = new Teacher("Hassenforder");
        items.add("Teachers");

        teachers.add(p1);
        teachers.add(p2);
    }
}
