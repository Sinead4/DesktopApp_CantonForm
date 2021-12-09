package desktopx.assignment_2.cantonform.presentationmodel.attributes;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class IntegerAttribute extends Attribute<IntegerProperty, Integer, IntegerAttribute>{

    public IntegerAttribute(){
        this(0);
    }

    public IntegerAttribute(Integer value){
        super(new SimpleIntegerProperty(value), new SimpleIntegerProperty(value));
        setTextValue(String.valueOf(value));

        valueNowProperty().addListener((observable, oldValue, newValue) -> setTextValue(String.valueOf(newValue)));

        //überprüft ob es klappt das ein int eingegeben ist
        textValueProperty().addListener((observable, oldValue, newValue) -> {
            try {
                setValid(true);
                setValueNow(Integer.valueOf(newValue));
            } catch (NumberFormatException e) {
                setValid(false);
            }
        });
    }
}
