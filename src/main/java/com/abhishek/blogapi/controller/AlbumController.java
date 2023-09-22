package com.abhishek.blogapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.abhishek.blogapi.exception.ResponseEntityErrorException;
import com.abhishek.blogapi.model.Album;
import com.abhishek.blogapi.payload.AlbumResponse;
import com.abhishek.blogapi.payload.ApiResponse;
import com.abhishek.blogapi.payload.PagedResponse;
import com.abhishek.blogapi.payload.PhotoResponse;
import com.abhishek.blogapi.payload.request.AlbumRequest;
import com.abhishek.blogapi.service.AlbumService;
import com.abhishek.blogapi.service.PhotoService;
import com.abhishek.blogapi.utils.AppConstants;
import com.abhishek.blogapi.utils.AppUtils;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/api/albums")
public class AlbumController {
	
	@Autowired
	private AlbumService albumService;

	@Autowired
	private PhotoService photoService;

	@ExceptionHandler(ResponseEntityErrorException.class)
	public ResponseEntity<ApiResponse> handleExceptions(ResponseEntityErrorException exception) {
		return exception.getApiResponse();
	}

	@GetMapping
	public PagedResponse<AlbumResponse> getAllAlbums(
			@RequestParam(name = "page", required = false, defaultValue = AppConstants.DEFAULT_PAGE_NUMBER) Integer page,
			@RequestParam(name = "size", required = false, defaultValue = AppConstants.DEFAULT_PAGE_SIZE) Integer size) {
		
		AppUtils.validatePageNumberAndSize(page, size);

		return albumService.getAllAlbums(page, size);
	}

	@PostMapping
	public ResponseEntity<Album> addAlbum(@Valid @RequestBody AlbumRequest albumRequest) {
		return albumService.addAlbum(albumRequest);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Album> getAlbum(@PathVariable(name = "id") Long id) {
		return albumService.getAlbum(id);
	}

	@PutMapping("/{id}")
	public ResponseEntity<AlbumResponse> updateAlbum(@PathVariable(name = "id") Long id, 
			@Valid @RequestBody AlbumRequest newAlbum){
		return albumService.updateAlbum(id, newAlbum);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<ApiResponse> deleteAlbum(@PathVariable(name = "id") Long id) {
		return albumService.deleteAlbum(id);
	}

	@GetMapping("/{id}/photos")
	public ResponseEntity<PagedResponse<PhotoResponse>> getAllPhotosByAlbum(@PathVariable(name = "id") Long id,
			@RequestParam(name = "page", required = false, defaultValue = AppConstants.DEFAULT_PAGE_NUMBER) Integer page,
			@RequestParam(name = "size", required = false, defaultValue = AppConstants.DEFAULT_PAGE_SIZE) Integer size) {

		PagedResponse<PhotoResponse> response = photoService.getAllPhotosByAlbum(id, page, size);

		return new ResponseEntity<>(response, HttpStatus.OK);
	}

}
