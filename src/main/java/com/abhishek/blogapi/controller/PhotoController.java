package com.abhishek.blogapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.abhishek.blogapi.payload.ApiResponse;
import com.abhishek.blogapi.payload.PagedResponse;
import com.abhishek.blogapi.payload.PhotoRequest;
import com.abhishek.blogapi.payload.PhotoResponse;
import com.abhishek.blogapi.service.PhotoService;
import com.abhishek.blogapi.utils.AppConstants;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/photos")
public class PhotoController {
	
	@Autowired
	private PhotoService photoService;

	@GetMapping
	public PagedResponse<PhotoResponse> getAllPhotos(
			@RequestParam(name = "page", required = false, defaultValue = AppConstants.DEFAULT_PAGE_NUMBER) Integer page,
			@RequestParam(name = "size", required = false, defaultValue = AppConstants.DEFAULT_PAGE_SIZE) Integer size) {
		return photoService.getAllPhotos(page, size);
	}

	@PostMapping
	public ResponseEntity<PhotoResponse> addPhoto(@Valid @RequestBody PhotoRequest photoRequest) {
		PhotoResponse photoResponse = photoService.addPhoto(photoRequest);

		return new ResponseEntity<>(photoResponse, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<PhotoResponse> getPhoto(@PathVariable(name = "id") Long id) {
		PhotoResponse photoResponse = photoService.getPhoto(id);

		return new ResponseEntity<>(photoResponse, HttpStatus.OK);
	}

	@PutMapping("/{id}")
	public ResponseEntity<PhotoResponse> updatePhoto(@PathVariable(name = "id") Long id,
			@Valid @RequestBody PhotoRequest photoRequest) {

		PhotoResponse photoResponse = photoService.updatePhoto(id, photoRequest);

		return new ResponseEntity<>(photoResponse, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<ApiResponse> deletePhoto(@PathVariable(name = "id") Long id) {
		ApiResponse apiResponse = photoService.deletePhoto(id);

		return new ResponseEntity<>(apiResponse, HttpStatus.OK);
	}
}
