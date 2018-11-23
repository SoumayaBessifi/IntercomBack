package com.intercom.webapp.webapplication;


import com.intercom.webapp.webapplication.Entities.Routeur;
import com.intercom.webapp.webapplication.Entities.Utilisateurs;
import com.intercom.webapp.webapplication.business.EquipBusiness;
import com.intercom.webapp.webapplication.controller.RouteurController;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static junit.framework.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class RouteurControllerTest {
    private static final String ROUTEUR_NUMSERIE = "123456789";
    @Mock
    EquipBusiness equipBusiness=mock(EquipBusiness.class);
    @InjectMocks
    RouteurController routeurController=new RouteurController(equipBusiness);

    Date datemisservice=new Date(17,02,01);
    Date datefingarantie=new Date(18,02,01);

    Utilisateurs user1=new Utilisateurs("Bennour","Adib",123,"adib@gmail.com","1456321","informatique");

    Routeur rout1 =new Routeur(ROUTEUR_NUMSERIE, "epison",false,datemisservice,datefingarantie,user1);
    Routeur rout2 =new Routeur("2153658", "dell",true,datemisservice,datefingarantie,user1);


    List<Routeur> routeurs=new ArrayList<Routeur>();

    @Before
    public void setUp() throws Exception {
        routeurs.add(rout1);
        routeurs.add(rout2);
    }

    @Test
    public void givenNothingWhenGetRouteurThenList() {

        //Arrange
        when(equipBusiness.findRouteur()).thenReturn(routeurs);
        //Act
        List<Routeur> actual = routeurController.findRouteur();

        //Assert
        assertEquals(ROUTEUR_NUMSERIE,actual.get(0).getNumserie());




    }
}
