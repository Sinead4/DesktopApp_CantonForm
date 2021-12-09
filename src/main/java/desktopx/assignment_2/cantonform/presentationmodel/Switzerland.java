package desktopx.assignment_2.cantonform.presentationmodel;

import java.util.Locale;
import java.util.Random;

import javafx.beans.property.*;

import desktopx.assignment_2.cantonform.service.CantonService;

public class Switzerland {
    private final StringProperty applicationTitle           = new SimpleStringProperty("Canton Form");
    private final CantonService  service;
    private final ObjectProperty<Locale> currentLocale      = new SimpleObjectProperty<>();
    private final BooleanProperty changed                   = new SimpleBooleanProperty();

    private CantonPM currentCanton;


    public Switzerland(CantonService service) {
        this.service = service;

        long id = new Random().nextInt(26) + 1;
        currentCanton = CantonPM.of(service.get(id));

        setupBindings();
        setupValueChangedListeners();

        currentLocale.set(Locale.GERMANY);
    }

    private void setupValueChangedListeners() {
        currentLocale.addListener((observable, oldValue, newValue) -> translateEverything());
    }

    private void translateEverything(){
        currentCanton.setLanguage(getCurrentLocale());
    }

    private void setupBindings(){
        changed.bind(currentCanton.isChangedProperty());
    }

    public void save(){
        currentCanton.rebase();
    }

    public void revert(){
        currentCanton.revert();
    }

    //getter und setter
    public CantonPM getCurrentCanton() {
        return currentCanton;
    }

    public String getApplicationTitle() {
        return applicationTitle.get();
    }

    public StringProperty applicationTitleProperty() {
        return applicationTitle;
    }

    public void setApplicationTitle(String applicationTitle) {
        this.applicationTitle.set(applicationTitle);
    }

    public Locale getCurrentLocale() {
        return currentLocale.get();
    }

    public ObjectProperty<Locale> currentLocaleProperty() {
        return currentLocale;
    }

    public void setCurrentLocale(Locale currentLocale) {
        this.currentLocale.set(currentLocale);
    }
}
