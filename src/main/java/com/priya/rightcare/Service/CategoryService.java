package com.priya.rightcare.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.priya.rightcare.Entity.Category;
import com.priya.rightcare.Repository.CategoryRepository;


@Service
public class CategoryService {
	@Autowired
    private CategoryRepository categoryRepository;

    public Category saveOrUpdateACategory(Category category) {
        return categoryRepository.save(category);
    }


    public List<Category> findAll() {
        return categoryRepository.findAll();
    }


	public List<Category> saveCategories(List<Category> categories) {

		return categoryRepository.saveAll(categories);
	}

	
	public List<Category> getCategories() {

		return categoryRepository.findAll();
		
	}

	 public Category getByName(String name) {
		
		return categoryRepository.findByName(name);
	}


	public List<Category> getById(int categoryId) {
		// TODO Auto-generated method stub
		return categoryRepository.findById(categoryId);
	}


	
	
	
	
}
