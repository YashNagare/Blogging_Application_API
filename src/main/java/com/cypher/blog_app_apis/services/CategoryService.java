package com.cypher.blog_app_apis.services;

import com.cypher.blog_app_apis.payloads.Dtos.CategoryDto;
import com.cypher.blog_app_apis.payloads.CategoryResponse;


public interface CategoryService {
    //Create
    CategoryDto createCategory(CategoryDto categoryDto);
    //Update
    CategoryDto updateCategory(CategoryDto categoryDto,Integer id);
    //Delete
    void deleteCategory(Integer catId);
    //Get
    CategoryDto getCategory(Integer id);
    //Get All
    CategoryResponse getAllCategories(Integer pageNumber, Integer pageSize);

}
