package com.intercom.webapp.webapplication;

import com.intercom.webapp.webapplication.Entities.Imprimante;
import com.intercom.webapp.webapplication.Entities.Utilisateurs;
import com.intercom.webapp.webapplication.business.EquipBusiness;
import com.intercom.webapp.webapplication.controller.ImprimanteController;
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

public class ImprimanteContollerTest {
    private static final String IMPRIMANTE_NUMSERIE = "123456789";
    @Mock
    EquipBusiness equipBusiness=mock(EquipBusiness.class);
    @InjectMocks
    ImprimanteController imprimanteController=new ImprimanteController(equipBusiness);

    Date datemisservice=new Date(17,02,01);
    Date datefingarantie=new Date(18,02,01);

    Utilisateurs user1=new Utilisateurs("Bennour","Adib",123,"adib@gmail.com","1456321","informatique");

    Imprimante imp1 =new Imprimante(IMPRIMANTE_NUMSERIE, "epison",false,datemisservice,datefingarantie,user1,"cartouche1");
    Imprimante imp2 =new Imprimante("2153658", "dell",true,datemisservice,datefingarantie,user1,"cartouche2");


    List<Imprimante> imprimantes=new ArrayList<Imprimante>();

    @Before
    public void setUp() throws Exception {
        imprimantes.add(imp1);
        imprimantes.add(imp2);
    }

    @Test
    public void givenNothingWhenGetImprimanteThenList() {

        //Arrange
        when(equipBusiness.findImpr()).thenReturn(imprimantes);
        //Act
        List<Imprimante> actual = imprimanteController.findAllImprimante();

        //Assert
        assertEquals(IMPRIMANTE_NUMSERIE,actual.get(0).getNumserie());




    }
}
