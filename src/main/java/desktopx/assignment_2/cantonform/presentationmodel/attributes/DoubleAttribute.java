package desktopx.assignment_2.cantonform.presentationmodel.attributes;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

public class DoubleAttribute extends Attribute<DoubleProperty, Double, DoubleAttribute>{

    public DoubleAttribute(){
        this(0.00);
        //hier wird der eigene zweite Konstruktor aufgerufen
    }

    public DoubleAttribute(double value){
        super(new SimpleDoubleProperty(value), new SimpleDoubleProperty(value));
        setTextValue(String.valueOf(value));
        //Hier wird das Attribute generiert mit Double Values in der Attribute Class

        valueNowProperty().addListener((observable, oldValue, newValue) -> setTextValue(String.valueOf(newValue)));

        //überprüft ob es klappt das ein double eingegeben ist
        textValueProperty().addListener((observable, oldValue, newValue) -> {
            try {
                setValid(true);
                setValueNow(Double.valueOf(newValue));
            } catch (NumberFormatException e) {
                setValid(false);
            }
        });
    }
}
