package com.intercom.webapp.webapplication.repository;

import com.intercom.webapp.webapplication.Entities.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EquipReposirtory extends JpaRepository<Equip, Integer> {
    @Query(value = "SELECT * from Equip u WHERE u.type_equipement='Ordinateur'", nativeQuery = true)
    List<Ordinateur> findOrdi();

    @Query(value = "SELECT * from Equip u WHERE u.type_equipement='Imprimante'", nativeQuery = true)
    List<Imprimante> findImpr();

    @Query(value = "SELECT * from Equip u WHERE u.type_equipement='Routeur'", nativeQuery = true)
    List<Routeur> findRouteur();

    @Query(value = "SELECT * from Equip u WHERE u.type_equipement='Serveur'", nativeQuery = true)
    List<Serveur> findServeur();
}
