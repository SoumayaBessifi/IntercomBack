package com.intercom.webapp.webapplication.business;

import com.intercom.webapp.webapplication.Entities.CustomUserDetails;
import com.intercom.webapp.webapplication.Entities.Utilisateurs;
import com.intercom.webapp.webapplication.repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    private final UtilisateurRepository utilisateurRepository;

    @Autowired
    public CustomUserDetailsService(UtilisateurRepository utilisateurRepository) {
        this.utilisateurRepository = utilisateurRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Optional<Utilisateurs> optionalUtilisateur = utilisateurRepository.findByEmail(s);
        optionalUtilisateur
                .orElseThrow(() -> new UsernameNotFoundException("Username not found"));
        return optionalUtilisateur.map(CustomUserDetails::new).get();
    }
}
