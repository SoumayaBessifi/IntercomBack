package com.intercom.webapp.webapplication;

import com.intercom.webapp.webapplication.Entities.Equip;
import com.intercom.webapp.webapplication.Entities.Utilisateurs;
import com.intercom.webapp.webapplication.business.EquipBusiness;
import com.intercom.webapp.webapplication.controller.MaterielController;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class MaterielControllerTest {

    private static final String EQUIPEMENT_NUMSERIE = "X541U";
    @Mock
    EquipBusiness equipBusiness=mock(EquipBusiness.class);
    @InjectMocks
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
        // Arrange
        when(equipBusiness.addEquip(equipement1)).thenReturn(equipement1);
        //act
        Equip actual_equipement=materielController.addEquip(equipement1);
        //Assert
        verify(equipBusiness).addEquip(equipement1);
        assertEquals(equipement1,actual_equipement);
    }

    @Test
    public void updateNoEquipementWhenUpdateEquipementThenEquipement()
    {
        // Arrange
        when(equipBusiness.updateEquip(equipement2)).thenReturn(equipement2);
        // Act
        materielController.updateEquip(1,equipement2);
        // Assert
        verify(equipBusiness).updateEquip(equipement2);
    }

    @Test
    public void deleteNothingWhenDeleteEquipement() {

        /* Manque de la méthode delete dans le controlleur */

    }

    @Test
    public void shouldReturnEquipement_whenGetEquipementByIdIsCalled() {

        //arrange
        when(equipBusiness.findById(1)).thenReturn(equipement1);
        //act
        Equip actual = materielController.findById(1);
        // Assert
        assertEquals(equipement1,actual);

    }






}
