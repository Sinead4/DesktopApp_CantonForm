package desktopx.presentationmodel;

import desktopx.assignment_2.cantonform.presentationmodel.CantonPM;
import desktopx.assignment_2.cantonform.service.CantonDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class CantonPMTest {

    @Test
    void setAttributesTest(){
        //given
        CantonDTO adto = new CantonDTO("Aargau", "AG", "123", "4.56", "1715", "Aarau","896453", "845.45","5632.25","65.56", "98465","DE");
        CantonPM pm = CantonPM.of(adto);



        //when


        //then
        Assertions.assertEquals("Aargau", pm.getKanton().getTextValue());


    }


}
