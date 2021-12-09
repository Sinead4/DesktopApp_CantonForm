package desktopx.assignment_2.cantonform.presentationmodel.attributes;

import javafx.beans.property.LongProperty;
import javafx.beans.property.SimpleLongProperty;

public class LongAttribute extends Attribute<LongProperty, Long, LongAttribute> {

    public LongAttribute(){
        this((long) 0.00);
    }

    public LongAttribute(Long value){
        super(new SimpleLongProperty(value), new SimpleLongProperty(value));
        setTextValue(value.toString());

        valueNowProperty().addListener((observable, oldValue, newValue) -> setTextValue(String.valueOf(newValue)));

        //überprüft ob es klappt das ein Long eingegeben ist
        textValueProperty().addListener((observable, oldValue, newValue) -> {
            try {
                setValid(true);
                setValueNow(Long.valueOf(newValue));
            } catch (NumberFormatException e) {
                setValid(false);
            }
        });
    }
}
