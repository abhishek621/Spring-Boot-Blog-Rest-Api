package com.abhishek.blogapi.service;

import com.abhishek.blogapi.payload.ApiResponse;
import com.abhishek.blogapi.payload.PagedResponse;
import com.abhishek.blogapi.payload.PhotoRequest;
import com.abhishek.blogapi.payload.PhotoResponse;

public interface PhotoService {

	PagedResponse<PhotoResponse> getAllPhotos(int page, int size);

	PhotoResponse getPhoto(Long id);

	PhotoResponse updatePhoto(Long id, PhotoRequest photoRequest);

	PhotoResponse addPhoto(PhotoRequest photoRequest);

	ApiResponse deletePhoto(Long id );

	PagedResponse<PhotoResponse> getAllPhotosByAlbum(Long albumId, int page, int size);

}