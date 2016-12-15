package Model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Created by maxime on 01/12/2016.
 */
public class Teacher extends Item {

    private SimpleStringProperty name;

    public Teacher(){
        this.type = new SimpleStringProperty("teacher");
        this.name = new SimpleStringProperty("Set Teacher Name");
    }

    public Teacher(String name){
        this.type = new SimpleStringProperty("teacher");
        this.name = new SimpleStringProperty(name);
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


}
