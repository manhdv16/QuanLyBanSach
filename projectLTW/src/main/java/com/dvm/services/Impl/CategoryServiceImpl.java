package com.dvm.services.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dvm.entity.Category;
import com.dvm.repositories.CategoryRepository;
import com.dvm.services.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService{
	@Autowired
	CategoryRepository categoryRepository;

	@Override
	public Category save(Category entity) {
		return categoryRepository.save(entity);
	}

	@Override
	public List<Category> findAll() {
		return categoryRepository.findAll();
	}

	@Override
	public Category findById(Integer id) {
		return categoryRepository.findById(id).get();
	}

	@Override
	public long count() {
		return categoryRepository.count();
	}

	@Override
	public void delete(Category entity) {
		categoryRepository.delete(entity);
	}
	
	@Override
	public Category findByName(String name) {
		List<Category> list = findAll();
		for(Category x: list) {
			if(x.getName().equals(name)) {
				return x;
			}
		}
		return null;
	} 
	
	
}
