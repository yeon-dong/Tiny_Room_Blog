package com.tinyroom.spring.category.service;

import com.tinyroom.spring.category.domain.Category;
import com.tinyroom.spring.category.dto.CategoryDto;
import com.tinyroom.spring.post.domain.Post;
import com.tinyroom.spring.post.dto.PostDto;

public interface CategoryService {
	public CategoryDto get(int category_id);
	
	default CategoryDto entityCategoryDto(Category category) {
		CategoryDto categoryDto = CategoryDto.builder()
				.category_id(category.getCategory_id())
				.category_name(category.getCategory_name())
				.build();
		return categoryDto;
	}
	
	default Category dtoToEntity(CategoryDto categoryDto) {
		Category category = Category.builder()
				.category_id(categoryDto.getCategory_id())
				.category_name(categoryDto.getCategory_name())
				.build();
		return category;
	}
}
