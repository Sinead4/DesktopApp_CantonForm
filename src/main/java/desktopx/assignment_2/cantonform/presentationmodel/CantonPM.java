package desktopx.assignment_2.cantonform.presentationmodel;

import desktopx.assignment_2.cantonform.presentationmodel.attributes.DoubleAttribute;
import desktopx.assignment_2.cantonform.presentationmodel.attributes.IntegerAttribute;
import desktopx.assignment_2.cantonform.presentationmodel.attributes.LongAttribute;
import desktopx.assignment_2.cantonform.presentationmodel.attributes.StringAttribute;


import desktopx.assignment_2.cantonform.service.CantonDTO;

import java.util.Locale;

public class CantonPM  extends PMBasis<CantonDTO>{
    private  StringAttribute  kanton          = createStringAttribute()
                                                .setCaptionWLang(Locale.GERMANY, "Kanton")
                                                .setCaptionWLang(Locale.UK, "Canton")
                                                .mandatory(true);

    private  StringAttribute  kuerzel         = createStringAttribute()
                                                .setCaptionWLang(Locale.GERMANY, "Kürzel")
                                                .setCaptionWLang(Locale.UK, "Code")
                                                .mandatory(true);

    private  LongAttribute    kantonsnummer   = createLongAttribute()
                                                .setCaptionWLang(Locale.GERMANY, "Kantonsnummer")
                                                .setCaptionWLang(Locale.UK, "Cantonnumber")
                                                .mandatory(true);

    private  DoubleAttribute  standesstimme   = createDoubleAttribute()
                                                .setCaptionWLang(Locale.GERMANY, "Standesstimme")
                                                .setCaptionWLang(Locale.UK,"Professional votes");

    private  IntegerAttribute beitritt        = createIntegerAttribute()
                                                .setCaptionWLang(Locale.GERMANY, "Beitritt")
                                                .setCaptionWLang(Locale.UK, "Entry");

    private  StringAttribute  hauptort        = createStringAttribute()
                                                .setCaptionWLang(Locale.GERMANY, "Hauptort")
                                                .setCaptionWLang(Locale.UK, "Capital");

    private  IntegerAttribute einwohner       = createIntegerAttribute()
                                                .setCaptionWLang(Locale.GERMANY, "Einwohner")
                                                .setCaptionWLang(Locale.UK, "Population");

    private  DoubleAttribute  auslaender      = createDoubleAttribute()
                                                .setCaptionWLang(Locale.GERMANY, "Ausländer")
                                                .setCaptionWLang(Locale.UK, "Foreigner");

    private  DoubleAttribute  flaeche         = createDoubleAttribute()
                                                .setCaptionWLang(Locale.GERMANY, "Fläche")
                                                .setCaptionWLang(Locale.UK, "Area");

    private  DoubleAttribute  einwohnerdichte = createDoubleAttribute()
                                                .setCaptionWLang(Locale.GERMANY, "Einwohnerdichte")
                                                .setCaptionWLang(Locale.UK, "population density");

    private  IntegerAttribute gemeinden       = createIntegerAttribute()
                                                .setCaptionWLang(Locale.GERMANY, "Gemeinden")
                                                .setCaptionWLang(Locale.UK, "Commune");

    private  StringAttribute  amtssprache     = createStringAttribute()
                                                .setCaptionWLang(Locale.GERMANY, "Amtssprache")
                                                .setCaptionWLang(Locale.UK, "Language");



    public static CantonPM of(CantonDTO dto) {
        CantonPM pm = new CantonPM();
        pm.apply(dto);
        pm.rebase();

        return pm;
    }

    public void apply(CantonDTO dto){

        getKanton().setValueNow(dto.getKanton());
        getKuerzel().setValueNow(dto.getKuerzel());
        getKantonsnummer().setValueNow(dto.getKantonsnummer());
        getStandesstimme().setValueNow(dto.getStandesstimme());
        getBeitritt().setValueNow(dto.getBeitritt());
        getHauptort().setValueNow(dto.getHauptort());
        getEinwohner().setValueNow(dto.getEinwohner());
        getAuslaender().setValueNow(dto.getAuslaender());
        getFlaeche().setValueNow(dto.getFlaeche());
        getEinwohnerdichte().setValueNow(dto.getEinwohnerdichte());
        getGemeinden().setValueNow(dto.getGemeinden());
        getAmtssprache().setValueNow(dto.getAmtssprache());

    }

    // eine Instanz von CantonPM kriegt man nur ueber die 'of'-Methode
    private CantonPM() {
        init();
        setupAttributeChangedListeners();
    }


    void setupAttributeChangedListeners(){
        //todo einwohnerdichte nur readonly wenn beide werte einwohner und fläche angegeben sind

        einwohner.textValueProperty().addListener((observable) -> {
            if (!einwohner.getTextValue().isEmpty() && !flaeche.getTextValue().isEmpty()){
                einwohnerdichte.setReadOnly(true);

            }else
                einwohnerdichte.setReadOnly(false);
        });

        flaeche.textValueProperty().addListener((observable) -> {
            if (!einwohner.getTextValue().isEmpty() && !flaeche.getTextValue().isEmpty()){
                einwohnerdichte.setReadOnly(true);

            }else
                einwohnerdichte.setReadOnly(false);
        });

    }

    public StringAttribute getKanton() {
        return kanton;
    }

    public StringAttribute getKuerzel() {
        return kuerzel;
    }

    public LongAttribute getKantonsnummer() {
        return kantonsnummer;
    }

    public DoubleAttribute getStandesstimme() {
        return standesstimme;
    }

    public IntegerAttribute getBeitritt() {
        return beitritt;
    }

    public StringAttribute getHauptort() {
        return hauptort;
    }

    public IntegerAttribute getEinwohner() {
        return einwohner;
    }

    public DoubleAttribute getAuslaender() {
        return auslaender;
    }

    public DoubleAttribute getFlaeche() {
        return flaeche;
    }

    public DoubleAttribute getEinwohnerdichte() {
        return einwohnerdichte;
    }

    public IntegerAttribute getGemeinden() {
        return gemeinden;
    }

    public StringAttribute getAmtssprache() {
        return amtssprache;
    }
}
