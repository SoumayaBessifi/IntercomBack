package com.intercom.webapp.webapplication.business;

import com.intercom.webapp.webapplication.Entities.Reclamation;

import java.util.List;

public interface ReclamationBusiness {

    Reclamation addReclamation(Reclamation rec);
    List<Reclamation> findAll();
    Reclamation findById(Integer id);
    /*Reclamation findById(Integer id);
    /*
    Reclamation findByEtat(String etat);

    void removeReclamation(Integer id);



    Reclamation patchReclamation(Integer id, Optional<String> description, Optional<String> urgence,Optional<String> etat);

*/

}
