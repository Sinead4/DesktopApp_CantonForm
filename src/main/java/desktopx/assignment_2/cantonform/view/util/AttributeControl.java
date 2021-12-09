package desktopx.assignment_2.cantonform.view.util;

import desktopx.assignment_2.cantonform.presentationmodel.attributes.Attribute;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;



public class AttributeControl extends  StackPane implements ViewMixin{

    private TextField textField;
    private Label readOnlyLabel;

    private Attribute attribute;

    public AttributeControl(Attribute<?,?,?> attribute){
        this.attribute = attribute;
        init();
    }

    @Override
    public void initializeParts() {
        textField = new TextField();
        readOnlyLabel = new Label();

        updateInvalidStyle(attribute.isValid());
        updateMandatoryStyle(attribute.isMandatory());
        updateDirtyStyle(attribute.isChanged());

    }

    @Override
    public void layoutParts() {
      getChildren().addAll(readOnlyLabel,textField);
    }

    @Override
    public void setupValueChangedListeners() {
        attribute.validProperty().addListener((observable, oldValue, newValue) -> updateInvalidStyle(newValue));

//        attribute.validationMessageProperty().addListener((observable, oldValue, newValue) -> setTooltip(newValue));

        attribute.mandatoryProperty().addListener((observable, oldValue, newValue) -> updateMandatoryStyle(newValue));

        attribute.changedProperty().addListener((observable, oldValue, newValue) -> updateDirtyStyle(newValue));
    }

    @Override
    public void setupBindings(){
        textField.textProperty().bindBidirectional(attribute.textValueProperty());
        readOnlyLabel.textProperty().bind(attribute.textValueProperty());

        textField.visibleProperty().bind(attribute.readOnlyProperty().not());
        readOnlyLabel.visibleProperty().bind(attribute.readOnlyProperty());
    }

    private void updateStyle(String style, boolean newValue) {
        if (newValue) {
            textField.getStyleClass().add(style);
        } else {
            textField.getStyleClass().remove(style);
        }
    }

    private void updateInvalidStyle(boolean newValue) {
        updateStyle("invalid", !newValue);
    }

    private void updateMandatoryStyle(boolean newValue) {
        updateStyle("mandatory", newValue);
    }

    private void updateDirtyStyle(boolean newValue) {
        updateStyle("dirty", newValue);
    }

}

