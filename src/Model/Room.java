package Model;

import javafx.beans.property.SimpleStringProperty;

/**
 * Created by maxim on 21/12/2016.
 */
public class Room extends Item {

    private SimpleStringProperty name;

    public Room(){
        this.type = new SimpleStringProperty("room");
        this.name = new SimpleStringProperty("Set a name for the Room");
    }

    public Room(String name){
        this.type = new SimpleStringProperty("room");
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
