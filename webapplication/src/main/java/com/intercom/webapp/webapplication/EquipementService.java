package com.intercom.webapp.webapplication;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EquipementService implements CrudDAO{

	@Autowired
	private EquipementRepository equipementRepository;
	
	
	public EquipementService()
	{
		
	}
	@Override
	public List<Equipement> getAll() {
		// TODO Auto-generated method stub
		List<Equipement> mList=new ArrayList<>();
		equipementRepository.findAll()
		.forEach(mList::add);
		return mList;
	}

	@Override
	public void insert(Object c) {
		// TODO Auto-generated method stub
		equipementRepository.save((Equipement)c);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		equipementRepository.deleteById(id);
		
	}

	@Override
	public void update(Object c) {
		// TODO Auto-generated method stub
		equipementRepository.save((Equipement)c);
	}

	@Override
	public Object findById(int id) {
		// TODO Auto-generated method stub
		return equipementRepository.findById(id);
	}

	@Override
	public Object findByModel(String model) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}
