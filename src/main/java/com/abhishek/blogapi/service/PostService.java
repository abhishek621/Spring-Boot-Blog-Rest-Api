package com.abhishek.blogapi.service;

import com.abhishek.blogapi.model.Post;
import com.abhishek.blogapi.payload.ApiResponse;
import com.abhishek.blogapi.payload.PagedResponse;
import com.abhishek.blogapi.payload.PostRequest;
import com.abhishek.blogapi.payload.PostResponse;

public interface PostService {

	PagedResponse<Post> getAllPosts(int page, int size);

	PagedResponse<Post> getPostsByCreatedBy(String username, int page, int size);

	PagedResponse<Post> getPostsByCategory(Long id, int page, int size);

	PagedResponse<Post> getPostsByTag(Long id, int page, int size);

	Post updatePost(Long id, PostRequest newPostRequest);

	ApiResponse deletePost(Long id);

	PostResponse addPost(PostRequest postRequest);

	Post getPost(Long id);

}
