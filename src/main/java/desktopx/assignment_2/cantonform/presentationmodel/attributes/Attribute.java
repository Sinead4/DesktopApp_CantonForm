package desktopx.assignment_2.cantonform.presentationmodel.attributes;

import javafx.beans.binding.Bindings;
import javafx.beans.property.*;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class Attribute<P extends Property, E, A extends  Attribute> {

    // alle Attribute die ein TextFeld braucht

    //diese Map wird benötigt um für jede Sprache die einzelne Beschreibung zu hinterlegen
    private final Map<Locale, String> captions = new HashMap<>();

    private final StringProperty textValue = new SimpleStringProperty();
    private final BooleanProperty mandatory = new SimpleBooleanProperty(false);
    private final BooleanProperty valid = new SimpleBooleanProperty(true);
    private final BooleanProperty changed = new SimpleBooleanProperty(false);
    private final BooleanProperty readOnly = new SimpleBooleanProperty(false);

    //für die Labels pro Textfeld damit die Sprache geändert werden kann
    private StringProperty caption = new SimpleStringProperty();
    private Locale language = new Locale("de");

    private P valueNow;
    private P valuePast;

    public Attribute(P valueProperty, P pastValueProperty){
        this.valueNow = valueProperty;
        this.valuePast = pastValueProperty;

        //überprüft ob valueNow und valuePost unterschiedlich sind oder nicht.
        changedProperty().bind(Bindings.createBooleanBinding(() -> !valuePastProperty().getValue().equals(valueNowProperty().getValue()),
                valueNowProperty(), valuePastProperty()));
    }

    public A setCaptionWLang(Locale lang, String caption){
        captions.put(lang, caption);
        return (A)this;
    }

    public A mandatory(boolean mandatory) {
        setMandatory(mandatory);

        return (A) this;
    }

    //das ValuePast wird mit dem neuen Wert überschrieben somit wird das changedProperty wieder false
    public void rebase() {
        valuePast.setValue(valueNow.getValue());
    }


    public void revert(){
        valueNow.setValue(valuePast.getValue());
        textValue.setValue(String.valueOf(getValueNow()));
    }
//
//    public A readOnly(boolean readOnly) {
//        setReadOnly(readOnly);
//
//        return (A) this;
//    }

    //getter und setter

    public void setLanguage(Locale language) {
        setCaption(captions.getOrDefault(language, "..."));
    }

    public Locale getLanguage() {
        return language;
    }

    public String getCaption() {
        return caption.get();
    }

    public StringProperty captionProperty() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption.set(caption);
    }

    public E getValueNow() {
        return (E) valueNow.getValue();
    }

    public P valueNowProperty() {
        return valueNow;
    }

    public void setValueNow(Object valueNow) {
        this.valueNow.setValue(valueNow);
    }

    public E getValuePast() {
        return (E) valuePast.getValue();
    }

    public P valuePastProperty() {
        return valuePast;
    }

    public void setValuePast(Object valuePast) {
        this.valuePast.setValue(valuePast);
    }

    public boolean isReadOnly() {
        return readOnly.get();
    }

    public BooleanProperty readOnlyProperty() {
        return readOnly;
    }

    public void setReadOnly(boolean readOnly) {
        this.readOnly.set(readOnly);
    }

    public String getTextValue() {
        return textValue.get();
    }

    public StringProperty textValueProperty() {
        return textValue;
    }

    public void setTextValue(String textValue) {
        this.textValue.set(textValue);
    }

    public boolean isMandatory() {
        return mandatory.get();
    }

    public BooleanProperty mandatoryProperty() {
        return mandatory;
    }

    public void setMandatory(boolean mandatory) {
        this.mandatory.set(mandatory);
    }

    public boolean isValid() {
        return valid.get();
    }

    public BooleanProperty validProperty() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid.set(valid);
    }

    public boolean isChanged() {
        return changed.get();
    }

    public BooleanProperty changedProperty() {
        return changed;
    }

    public void setChanged(boolean changed) {
        this.changed.set(changed);
    }


}
