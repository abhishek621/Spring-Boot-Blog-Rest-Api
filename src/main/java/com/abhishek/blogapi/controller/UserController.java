package com.abhishek.blogapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.abhishek.blogapi.model.Album;
import com.abhishek.blogapi.model.Post;
import com.abhishek.blogapi.payload.PagedResponse;
import com.abhishek.blogapi.service.AlbumService;
import com.abhishek.blogapi.service.PostService;
import com.abhishek.blogapi.utils.AppConstants;

@RestController
@RequestMapping("/api/users")
public class UserController {
	

	@Autowired
	private PostService postService;

	@Autowired
	private AlbumService albumService;


	@GetMapping("/{username}/posts")
	public ResponseEntity<PagedResponse<Post>> getPostsCreatedBy(@PathVariable(value = "username") String username,
			@RequestParam(value = "page", required = false, defaultValue = AppConstants.DEFAULT_PAGE_NUMBER) Integer page,
			@RequestParam(value = "size", required = false, defaultValue = AppConstants.DEFAULT_PAGE_SIZE) Integer size) {
		PagedResponse<Post> response = postService.getPostsByCreatedBy(username, page, size);

		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@GetMapping("/{username}/albums")
	public ResponseEntity<PagedResponse<Album>> getUserAlbums(@PathVariable(name = "username") String username,
			@RequestParam(name = "page", required = false, defaultValue = AppConstants.DEFAULT_PAGE_NUMBER) Integer page,
			@RequestParam(name = "size", required = false, defaultValue = AppConstants.DEFAULT_PAGE_SIZE) Integer size) {

		PagedResponse<Album> response = albumService.getUserAlbums(username, page, size);

		return new ResponseEntity<>(response, HttpStatus.OK);
	}

}
