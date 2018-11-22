package com.intercom.webapp.webapplication;

import com.intercom.webapp.webapplication.Entities.Equip;
import com.intercom.webapp.webapplication.Entities.Utilisateurs;
import com.intercom.webapp.webapplication.business.EquipBusiness;
import com.intercom.webapp.webapplication.controller.MaterielController;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class MaterielControllerTest {

    private static final String EQUIPEMENT_NUMSERIE = "X541U";

    EquipBusiness equipBusiness=mock(EquipBusiness.class);

    MaterielController materielController=new MaterielController(equipBusiness);

    Date datemisservice=new Date(17,02,01);
    Date datefingarantie=new Date(18,02,01);

    Utilisateurs user1=new Utilisateurs("Bennour","Adib",123,"adib@gmail.com","1456321","informatique");

    Equip equipement1 =new Equip(EQUIPEMENT_NUMSERIE, "Asus",false,datemisservice,datefingarantie,user1);
    Equip equipement2=new Equip(EQUIPEMENT_NUMSERIE, "Acer",false,datemisservice,datefingarantie,user1);

    List<Equip> equipements=new ArrayList<Equip>();

    @Before
    public void setUp() throws Exception {
        equipements.add(equipement1);
        equipements.add(equipement2);
    }

/*
    @Test
    public void givenNothingWhenGetEquipementThenList() {

        //Arrange
        when(equipBusiness.findAll()).thenReturn(equipements);
        //Act
        List<Equip> actual = materielController.findAll();

        //Assert
        assertEquals(EQUIPEMENT_NUMSERIE,actual.get(0).getNumserie());




    }
    */

    @Test
    public void saveNothingWhenAddEquipementThenEquipement() {
        materielController.addEquip(equipement1);
        verify(equipBusiness).addEquip(equipement1);
    }

    @Test
    public void updateNoEquipementWhenUpdateEquipementThenEquipement()
    {
        when(equipBusiness.addEquip(equipement2)).thenReturn(equipement2);
        materielController.updateEquip(1,equipement2);
        verify(equipBusiness).updateEquip(equipement2);
    }

    @Test
    public void deleteNothingWhenDeleteEquipement() {

        /* Manque de la méthode delete dans le controlleur */

    }

    @Test
    public void NoEquipementFoundWhenIDEquipementThenReferencesToEquipement() {

        when(equipBusiness.addEquip(equipement2)).thenReturn(equipement2);
        materielController.findById(1);
        verify(equipBusiness).findById(1);
        assertEquals(materielController.findById(1),equipBusiness.findById(1));
    }






}
