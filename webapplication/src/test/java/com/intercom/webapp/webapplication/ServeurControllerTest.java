package com.intercom.webapp.webapplication;

import com.intercom.webapp.webapplication.Entities.Serveur;
import com.intercom.webapp.webapplication.Entities.Utilisateurs;
import com.intercom.webapp.webapplication.business.EquipBusiness;
import com.intercom.webapp.webapplication.controller.ServeurController;
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

public class ServeurControllerTest {
    private static final String SERVEUR_NUMSERIE = "123456789";
    @Mock
    EquipBusiness equipBusiness=mock(EquipBusiness.class);
    @InjectMocks
    ServeurController serveurController=new ServeurController(equipBusiness);

    Date datemisservice=new Date(17,02,01);
    Date datefingarantie=new Date(18,02,01);

    Utilisateurs user1=new Utilisateurs("Bennour","Adib",123,"adib@gmail.com","1456321","informatique");

    Serveur serv1 =new Serveur(SERVEUR_NUMSERIE, "epison",false,datemisservice,datefingarantie,user1);
    Serveur serv2 =new Serveur("2153658", "dell",true,datemisservice,datefingarantie,user1);


    List<Serveur> serveurs=new ArrayList<Serveur>();

    @Before
    public void setUp() throws Exception {
        serveurs.add(serv1);
        serveurs.add(serv2);
    }

    @Test
    public void givenNothingWhenGetRouteurThenList() {

        //Arrange
        when(equipBusiness.findServ()).thenReturn(serveurs);
        //Act
        List<Serveur> actual = serveurController.findServeur();

        //Assert
        assertEquals(SERVEUR_NUMSERIE,actual.get(0).getNumserie());




    }
}
