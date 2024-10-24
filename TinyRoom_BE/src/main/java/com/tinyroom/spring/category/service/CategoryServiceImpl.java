package com.tinyroom.spring.category.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tinyroom.spring.category.dao.CategoryDao;
import com.tinyroom.spring.category.domain.Category;
import com.tinyroom.spring.category.dto.CategoryDto;
import com.tinyroom.spring.post.dto.PostDto;
import com.tinyroom.spring.post.service.PostService;

@Service
public class CategoryServiceImpl implements CategoryService{
	@Autowired
	CategoryDao categoryDao;
	
	@Override
	public CategoryDto get(int category_id) {
		
		Optional<Category> result = categoryDao.findById(category_id);
		Category category = result.orElseThrow();

		return entityCategoryDto(category);

	}

}
