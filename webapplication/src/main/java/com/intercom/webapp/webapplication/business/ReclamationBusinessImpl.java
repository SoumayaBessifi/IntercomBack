package com.intercom.webapp.webapplication.business;

import com.intercom.webapp.webapplication.Entities.Reclamation;
import com.intercom.webapp.webapplication.repository.ReclamationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class ReclamationBusinessImpl implements ReclamationBusiness {
    private final ReclamationRepository reclamationRepository;

    @Autowired
    public ReclamationBusinessImpl(ReclamationRepository reclamationRepository) {

        this.reclamationRepository = reclamationRepository;

    }

    @Override
    public Reclamation addReclamation(Reclamation rec) {
        rec.setDate_creation(new Date());
        return reclamationRepository.save(rec);
    }

/*
    @Override
    public Reclamation findById(Integer id) {
        return null;
    }

    @Override
    public Reclamation findByEtat(String etat) {
        return null;
    }

    @Override
    public Reclamation updateReclamation(Reclamation reclamation) {
        return null;
    }

    @Override
    public void removeReclamation(Integer id) {

    }

    @Override
    public List<Reclamation> findAll() {
        return null;
    }

    @Override
    public Reclamation patchReclamation(Integer id, Optional<String> description, Optional<String> urgence, Optional<String> etat) {
        return null;
    }*/
}
