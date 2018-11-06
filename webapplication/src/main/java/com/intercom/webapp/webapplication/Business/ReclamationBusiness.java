package com.intercom.webapp.webapplication.Business;

import com.intercom.webapp.webapplication.Entities.Reclamation;

import java.util.List;
import java.util.Optional;

public interface ReclamationBusiness {

    Reclamation addReclamation(Reclamation rec);
    /*Reclamation findById(Integer id);
    Reclamation findByEtat(String etat);

    void removeReclamation(Integer id);

    List<Reclamation> findAll();

    Reclamation patchReclamation(Integer id, Optional<String> description, Optional<String> urgence,Optional<String> etat);

*/

}
