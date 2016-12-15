package Model;

import javafx.beans.property.SimpleStringProperty;

/**
 * Created by maxime on 11/12/2016.
 */
public class Item {
    protected SimpleStringProperty type;
    private SimpleStringProperty name;

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
