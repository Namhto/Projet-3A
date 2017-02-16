package fr.ensisa.uha.mo.prolog.Model;

import javafx.beans.property.SimpleStringProperty;

/**
 * Created by maxim on 21/12/2016.
 */
public class Promo extends Item {
    private SimpleStringProperty name;

    public Promo(){
        this.type = new SimpleStringProperty("promo");
        this.name = new SimpleStringProperty("Set a Name");
    }

    public Promo(String name){
        this.type = new SimpleStringProperty("promo");
        this.name = new SimpleStringProperty(name);
    }

    @Override
    public String getName() {
        return name.get();
    }

    @Override
    public SimpleStringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }
}
