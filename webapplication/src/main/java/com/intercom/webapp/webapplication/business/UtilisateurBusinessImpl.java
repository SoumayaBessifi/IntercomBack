package com.intercom.webapp.webapplication.business;

import com.intercom.webapp.webapplication.Entities.Utilisateurs;
import com.intercom.webapp.webapplication.repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UtilisateurBusinessImpl implements UtilisateurBusiness {
    private final UtilisateurRepository utilisateurRepository;

    @Autowired
    public UtilisateurBusinessImpl(UtilisateurRepository utilisateurRepository) {
        this.utilisateurRepository = utilisateurRepository;
    }

    @Override
    public Utilisateurs addUtil(Utilisateurs u) {
        return utilisateurRepository.save(u);
    }

    @Override
    public Utilisateurs findById(Integer id) {
        return utilisateurRepository.findById(id).get();
    }

    @Override
    public void removeUtilisateurs(Integer id) {
        utilisateurRepository.deleteById(id);
    }

    @Override
    public List<Utilisateurs> findAll() {
        return utilisateurRepository.findAll();
    }
}
