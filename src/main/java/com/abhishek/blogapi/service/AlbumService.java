package com.abhishek.blogapi.service;

import org.springframework.http.ResponseEntity;

import com.abhishek.blogapi.model.Album;
import com.abhishek.blogapi.payload.AlbumResponse;
import com.abhishek.blogapi.payload.ApiResponse;
import com.abhishek.blogapi.payload.PagedResponse;
import com.abhishek.blogapi.payload.request.AlbumRequest;

public interface AlbumService {

	PagedResponse<AlbumResponse> getAllAlbums(int page, int size);

	ResponseEntity<Album> addAlbum(AlbumRequest albumRequest);

	ResponseEntity<Album> getAlbum(Long id);

	ResponseEntity<AlbumResponse> updateAlbum(Long id, AlbumRequest newAlbum);

	ResponseEntity<ApiResponse> deleteAlbum(Long id);

	PagedResponse<Album> getUserAlbums(String username, int page, int size);

}
