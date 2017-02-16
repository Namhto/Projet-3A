package fr.ensisa.uha.mo.prolog.Model;

import javafx.beans.property.SimpleStringProperty;

/**
 * Created by maxime on 11/12/2016.
 */
public class Course extends Item{

    private SimpleStringProperty name;

    public Course(){
        this.type = new SimpleStringProperty("curse");
        this.name = new SimpleStringProperty("Set Course Name");
    }

    public Course(String name){
        this.type = new SimpleStringProperty("curse");
        this.name = new SimpleStringProperty(name);
    }

    public String getName() {
        return name.get();
    }

    public SimpleStringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }
}
