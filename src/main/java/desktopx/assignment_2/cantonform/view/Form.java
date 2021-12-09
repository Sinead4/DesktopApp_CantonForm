package desktopx.assignment_2.cantonform.view;

import desktopx.assignment_2.cantonform.presentationmodel.CantonPM;
import desktopx.assignment_2.cantonform.presentationmodel.Switzerland;
import desktopx.assignment_2.cantonform.view.util.AttributeControl;
import desktopx.assignment_2.cantonform.view.util.ViewMixin;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;



public class Form extends GridPane implements ViewMixin {

    private Switzerland switzerlandPM;
    private CantonPM cantonPM;

    private Label cantonLabel;
    private Label kuerzelLabel;
    private Label kantonsnummerLabel;
    private Label standesstimmeLabel;
    private Label beitrittsLabel;
    private Label hauptortLabel;
    private Label einwohnerLabel;
    private Label auslaenderLabel;
    private Label flaecheLabel;
    private Label einwohnerDichteLabel;
    private Label gemeindenLabel;
    private Label amtsspracheLabel;

    private AttributeControl cantonControl;
    private AttributeControl kuerzelControl;
    private AttributeControl kantonsnummerControl;
    private AttributeControl standesstimmeControl;
    private AttributeControl beitrittsControl;
    private AttributeControl hauptortControl;
    private AttributeControl einwohnerControl;
    private AttributeControl auslaenderControl;
    private AttributeControl flaecheControl;
    private AttributeControl einwohnerDichteControl;
    private AttributeControl gemeindenControl;
    private AttributeControl amtsspracheControl;



    public Form(Switzerland switzerlandPM){
        this.switzerlandPM = switzerlandPM;

        init();

    }


    @Override
    public void initializeParts() {
        cantonLabel          = new Label();
        kuerzelLabel         = new Label();
        kantonsnummerLabel   = new Label();
        standesstimmeLabel   = new Label();
        beitrittsLabel       = new Label();
        hauptortLabel        = new Label();
        einwohnerLabel       = new Label();
        auslaenderLabel      = new Label();
        flaecheLabel         = new Label();
        einwohnerDichteLabel = new Label();
        gemeindenLabel       = new Label();
        amtsspracheLabel     = new Label();

        cantonPM = switzerlandPM.getCurrentCanton();

        cantonControl = new AttributeControl(cantonPM.getKanton());
        kuerzelControl = new AttributeControl(cantonPM.getKuerzel());
        kantonsnummerControl = new AttributeControl(cantonPM.getKantonsnummer());
        standesstimmeControl = new AttributeControl(cantonPM.getStandesstimme());
        beitrittsControl = new AttributeControl(cantonPM.getBeitritt());
        hauptortControl = new AttributeControl(cantonPM.getHauptort());
        einwohnerControl = new AttributeControl(cantonPM.getEinwohner());
        auslaenderControl = new AttributeControl(cantonPM.getAuslaender());
        flaecheControl = new AttributeControl(cantonPM.getFlaeche());
        einwohnerDichteControl = new AttributeControl(cantonPM.getEinwohnerdichte());
        gemeindenControl = new AttributeControl(cantonPM.getGemeinden());
        amtsspracheControl = new AttributeControl(cantonPM.getAmtssprache());
    }

    @Override
    public void initializeSelf() {
        getStyleClass().add("form");
    }

    @Override
    public void layoutParts() {

        setConstraints(cantonLabel, 0,0);
        setConstraints(cantonControl, 1, 0);
        setConstraints(kuerzelLabel, 2,0);
        setConstraints(kuerzelControl, 3,0);
        setConstraints(kantonsnummerLabel, 0,1);
        setConstraints(kantonsnummerControl, 1,1);
        setConstraints(standesstimmeLabel, 2,1);
        setConstraints(standesstimmeControl, 3,1);
        setConstraints(beitrittsLabel,0,2);
        setConstraints(beitrittsControl,1,2);
        setConstraints(hauptortLabel, 2,2);
        setConstraints(hauptortControl,3,2);
        setConstraints(einwohnerLabel, 0,3);
        setConstraints(einwohnerControl,1,3);
        setConstraints(einwohnerDichteLabel, 2,3);
        setConstraints(einwohnerDichteControl,3,3);
        setConstraints(auslaenderLabel,0,4);
        setConstraints(auslaenderControl,1,4);
        setConstraints(flaecheLabel,2,4);
        setConstraints(flaecheControl,3,4);
        setConstraints(gemeindenLabel,0,5);
        setConstraints(gemeindenControl,1,5);
        setConstraints(amtsspracheLabel, 2,5);
        setConstraints(amtsspracheControl,3,5);



        getChildren().addAll(cantonLabel, cantonControl, kuerzelLabel, kuerzelControl, kantonsnummerLabel, kantonsnummerControl, standesstimmeLabel, standesstimmeControl,
                            beitrittsLabel, beitrittsControl, hauptortLabel, hauptortControl, einwohnerLabel, einwohnerControl, einwohnerDichteLabel, einwohnerDichteControl,
                            auslaenderLabel, auslaenderControl, flaecheLabel, flaecheControl, gemeindenLabel, gemeindenControl, amtsspracheLabel, amtsspracheControl);
    }

    @Override
    public void setupBindings() {
        cantonLabel.textProperty().bind(cantonPM.getKanton().captionProperty());
        kuerzelLabel.textProperty().bind(cantonPM.getKuerzel().captionProperty());
        kantonsnummerLabel.textProperty().bind(cantonPM.getKantonsnummer().captionProperty());
        standesstimmeLabel.textProperty().bind(cantonPM.getStandesstimme().captionProperty());
        beitrittsLabel.textProperty().bind(cantonPM.getBeitritt().captionProperty());
        hauptortLabel.textProperty().bind(cantonPM.getHauptort().captionProperty());
        einwohnerLabel.textProperty().bind(cantonPM.getEinwohner().captionProperty());
        einwohnerDichteLabel.textProperty().bind(cantonPM.getEinwohnerdichte().captionProperty());
        auslaenderLabel.textProperty().bind(cantonPM.getAuslaender().captionProperty());
        flaecheLabel.textProperty().bind(cantonPM.getFlaeche().captionProperty());
        gemeindenLabel.textProperty().bind(cantonPM.getGemeinden().captionProperty());
        amtsspracheLabel.textProperty().bind(cantonPM.getAmtssprache().captionProperty());



    }
}
