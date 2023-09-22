package com.abhishek.blogapi.service;

import org.springframework.http.ResponseEntity;

import com.abhishek.blogapi.exception.UnauthorizedException;
import com.abhishek.blogapi.model.Category;
import com.abhishek.blogapi.payload.ApiResponse;
import com.abhishek.blogapi.payload.PagedResponse;

public interface CategoryService {

	PagedResponse<Category> getAllCategories(int page, int size);

	ResponseEntity<Category> getCategory(Long id);

	ResponseEntity<Category> addCategory(Category category);

	ResponseEntity<Category> updateCategory(Long id, Category newCategory)
			throws UnauthorizedException;

	ResponseEntity<ApiResponse> deleteCategory(Long id) throws UnauthorizedException;

}
