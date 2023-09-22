package com.abhishek.blogapi.service;

import com.abhishek.blogapi.model.Tag;
import com.abhishek.blogapi.payload.ApiResponse;
import com.abhishek.blogapi.payload.PagedResponse;

public interface TagService {

	PagedResponse<Tag> getAllTags(int page, int size);

	Tag getTag(Long id);

	Tag addTag(Tag tag);

	Tag updateTag(Long id, Tag newTag);

	ApiResponse deleteTag(Long id);

}
