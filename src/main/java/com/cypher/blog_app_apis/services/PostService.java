package com.cypher.blog_app_apis.services;

import com.cypher.blog_app_apis.payloads.Dtos.PostDto;
import com.cypher.blog_app_apis.payloads.PostResponse;

import java.util.List;

public interface PostService {
    //create
    PostDto createPost(PostDto postDto, Integer userId, Integer categoryId);

    //update
    PostDto updatePost(PostDto postDto,Integer postId);
    //delete
    void deletePost(Integer postId);
    //get Single Post
    PostDto getPostById(Integer postId);
    //get All posts
    PostResponse getAllPosts(Integer pageNumber, Integer pageSize, String sortBy, String sortDir);
    //get Post by Category
    List<PostDto> getPostByCategory(Integer categoryId);
    //get Post by Users
    List<PostDto> getPostByUser(Integer userId);
    //search post by keyword
    List<PostDto> searchPosts(String keyword);
}
