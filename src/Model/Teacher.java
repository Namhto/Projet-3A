package Model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Created by maxime on 01/12/2016.
 */
public class Teacher extends Item {

    private SimpleStringProperty name;
    private Course enseigne;

    public Teacher(){
        this.type = new SimpleStringProperty("teacher");
        this.name = new SimpleStringProperty("Set Teacher Name");
    }

    public Teacher(String name){
        this.type = new SimpleStringProperty("teacher");
        this.name = new SimpleStringProperty(name);
    }

    public Teacher(String name, Course enseigne){
        this.type = new SimpleStringProperty("teacher");
        this.name = new SimpleStringProperty(name);
        this.enseigne = enseigne;
    }

    public Teacher(SimpleStringProperty name) {
        this.name = name;
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

    public Course getEnseigne() {
        return enseigne;
    }

    public void setEnseigne(Course enseigne) {
        this.enseigne = enseigne;
    }
}
