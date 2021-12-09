package desktopx.assignment_2.cantonform.presentationmodel.attributes;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.util.regex.Pattern;

public class StringAttribute extends Attribute<StringProperty, String, StringAttribute> {

    public StringAttribute(){
        this("");
    }

    public StringAttribute(String value){
        super(new SimpleStringProperty(value), new SimpleStringProperty(value));
        setTextValue(value);

        textValueProperty().bindBidirectional(valueNowProperty());

        //überprüft ob es klappt das ein string eingegeben ist
        textValueProperty().addListener((observable, oldValue, newValue) -> {

                if (Pattern.matches("(\\p{L}|\\p{M}|[,-.]|\s)+",newValue)){
                    setValid(true);
                }else{
                    setValid(false);
                }

        });
    }


}
