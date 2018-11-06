package com.intercom.webapp.webapplication.Controller;

import com.intercom.webapp.webapplication.Business.ReclamationBusiness;
import com.intercom.webapp.webapplication.Entities.Reclamation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/Reclamations")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class ReclamationController {

    private final ReclamationBusiness reclamationBusiness;

    @Autowired
    public ReclamationController(ReclamationBusiness reclamationBusiness) {
        this.reclamationBusiness = reclamationBusiness;
    }

    @RequestMapping(method = RequestMethod.POST)
    Reclamation addReclamation(@RequestBody Reclamation reclamation) {
        return reclamationBusiness.addReclamation(reclamation);
    }

}
