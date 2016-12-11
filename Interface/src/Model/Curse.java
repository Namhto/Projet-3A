package Model;

import javafx.beans.property.SimpleStringProperty;

/**
 * Created by maxime on 11/12/2016.
 */
public class Curse extends Item{

    private SimpleStringProperty curse;

    public Curse(String curse){
        this.curse = new SimpleStringProperty(curse);
    }

    public String getCurse() {
        return curse.get();
    }

    public SimpleStringProperty curseProperty() {
        return curse;
    }

    public void setCurse(String curse) {
        this.curse.set(curse);
    }
}
