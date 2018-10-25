package com.intercom.webapp.webapplication;

import java.util.List;

public interface CrudDAO<T> {
	public List<T> getAll () ;
	public void insert(T c);
	public void delete(int id);
	public void update(T c);
	public T findById(int id);
	public T findByModel(String model);
}
