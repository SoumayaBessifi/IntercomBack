package com.intercom.webapp.webapplication.repository;

import com.intercom.webapp.webapplication.Entities.Equip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EquipReposirtory extends JpaRepository<Equip, Integer> {

}
