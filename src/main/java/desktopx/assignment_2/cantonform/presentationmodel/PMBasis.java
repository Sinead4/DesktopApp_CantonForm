package desktopx.assignment_2.cantonform.presentationmodel;

import desktopx.assignment_2.cantonform.presentationmodel.attributes.*;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ChangeListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.function.Consumer;

public abstract class PMBasis<DTO> {

    private List<Attribute<?,?,?>> allAttributes = new ArrayList<>();

    private BooleanProperty isValid = new SimpleBooleanProperty(true);
    private BooleanProperty isChanged = new SimpleBooleanProperty(false);

    private final ChangeListener<Boolean> validStateListener = (observable, oldValue, newValue) -> checkValidState();
    private final ChangeListener<Boolean> changedStateListener = (observable, oldValue, newValue) -> checkDirtyState();


    //protected damit es nur von den Subklassen verwendet werden kann
    protected void init(){

        forAllAttributes(attribute -> attribute.changedProperty().addListener(changedStateListener));
        forAllAttributes(attribute -> attribute.validProperty().addListener(validStateListener));
    }


    protected void forAllAttributes(Consumer<Attribute<?, ?, ?>> consumer) {
        allAttributes.forEach(consumer);
    }



    //all methods to create specific attributes. Here because I can but them all in the List to check if the whole form is valid
    //es braucht zwei Methoden mit dem gleichen Namen damit es einen initialen Wert setzen kann in der Übergangsphase im PM

    public StringAttribute createStringAttribute(){
        return createStringAttribute("");
    }

    public StringAttribute createStringAttribute(String value){
        StringAttribute stringAttribute = new StringAttribute(value);
        allAttributes.add(stringAttribute);

        return stringAttribute;
    }

    public LongAttribute createLongAttribute(){
        return createLongAttribute(0L);
    }

    public LongAttribute createLongAttribute(Long value){
        LongAttribute longAttribute = new LongAttribute(value);
        allAttributes.add(longAttribute);

        return longAttribute;
    }

    public DoubleAttribute createDoubleAttribute(){
        return createDoubleAttribute(0.0);
    }

    public DoubleAttribute createDoubleAttribute(Double value){
        DoubleAttribute doubleAttribute = new DoubleAttribute(value);
        allAttributes.add(doubleAttribute);

        return doubleAttribute;
    }

    public IntegerAttribute createIntegerAttribute(){
        return createIntegerAttribute(0);
    }

    public IntegerAttribute createIntegerAttribute(Integer value){
        IntegerAttribute intAttribute = new IntegerAttribute(value);
        allAttributes.add(intAttribute);

        return intAttribute;
    }

    // bei den nächsten beiden Methoden geht es die Liste durch und schaut ob sich entweder was geändert hat oder ob es noch valid ist
    private boolean didSomeAttributeChange(){
        return allAttributes.stream().anyMatch(Attribute::isChanged);
    }

    private boolean areAllAttributesValid() {
        return allAttributes.stream().allMatch(Attribute::isValid);
    }

    //bei diesen beiden werden die Properties geändert falls sich etwas geändert hat.

    private void checkDirtyState(){
        isChanged.set(didSomeAttributeChange());
    }

    private void checkValidState(){
        isValidProperty().set(areAllAttributesValid());
    }

    public void setLanguage(Locale locale) {
        forAllAttributes(attribute -> attribute.setLanguage(locale));
    }

    public void rebase() {
        forAllAttributes(Attribute::rebase);
    }

    public void revert() {
        forAllAttributes(Attribute::revert);
    }


//getter und setter

    public boolean isIsValid() {
        return isValid.get();
    }

    public BooleanProperty isValidProperty() {
        return isValid;
    }

    public void setIsValid(boolean isValid) {
        this.isValid.set(isValid);
    }

    public boolean isIsChanged() {
        return isChanged.get();
    }

    public BooleanProperty isChangedProperty() {
        return isChanged;
    }

    public void setIsChanged(boolean isChanged) {
        this.isChanged.set(isChanged);
    }
}
