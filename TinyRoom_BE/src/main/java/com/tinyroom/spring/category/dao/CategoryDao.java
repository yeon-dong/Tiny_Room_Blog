package com.tinyroom.spring.category.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tinyroom.spring.category.domain.Category;

public interface CategoryDao extends JpaRepository<Category, Integer>{

}
