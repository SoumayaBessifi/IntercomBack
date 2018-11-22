package com.intercom.webapp.webapplication;

import com.intercom.webapp.webapplication.Entities.Reclamation;
import com.intercom.webapp.webapplication.business.ReclamationBusiness;
import com.intercom.webapp.webapplication.controller.ReclamationController;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class ReclamationControllerTest {

    ReclamationBusiness reclamationBusiness=mock(ReclamationBusiness.class);
    ReclamationController reclamationController =new ReclamationController(reclamationBusiness);

    private static final String DESCRIPTION_PANNE = "Coupure brusque";

    User user1=new User("Adibbn","25632","Adib");
    Reclamation reclamation=new Reclamation(DESCRIPTION_PANNE,"haute","en attente",1,user1);

    @Test
    public void saveNothingWhenAddReclamationThenReclamation() {
        reclamationController.addReclamation(reclamation);
        verify(reclamationBusiness).addReclamation(reclamation);
    }




}