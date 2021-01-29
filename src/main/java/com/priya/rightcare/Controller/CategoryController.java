package com.priya.rightcare.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.priya.rightcare.Entity.Category;
import com.priya.rightcare.Service.CategoryService;



@RestController
@RequestMapping("api/v1")
@CrossOrigin(origins="http://localhost:4200")
public class CategoryController {
	@Autowired
	private CategoryService service;
	
	@GetMapping("/category/{categoryId}")
	public List<Category> findById(@PathVariable int categoryId) {
		
		return service.getById(categoryId);
	}

}
