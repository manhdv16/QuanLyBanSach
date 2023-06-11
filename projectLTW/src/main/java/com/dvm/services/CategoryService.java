package com.dvm.services;

import java.util.List;

import com.dvm.entity.Category;

public interface CategoryService {

	Category findByName(String name);

	void delete(Category entity);

	long count();

	Category findById(Integer id);

	List<Category> findAll();

	Category save(Category entity);

}
