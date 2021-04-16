package com.epam.phonerental.model.dao;

import java.util.List;

public interface GenericDao<T> {
	
	//CRUD

	//CREATE
	int insertItem(T item);
	
	//READ
	List<T>getAllItems();
	
	T getItemById(long id);
	
	//UPDATE
	int updateItem(T item);
	
	//DELETE
	int deleteItem(long id);
}
