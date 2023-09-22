package com.abhishek.blogapi.service;

import com.abhishek.blogapi.model.Comment;
import com.abhishek.blogapi.payload.ApiResponse;
import com.abhishek.blogapi.payload.CommentRequest;
import com.abhishek.blogapi.payload.PagedResponse;

public interface CommentService {

	PagedResponse<Comment> getAllComments(Long postId, int page, int size);

	Comment addComment(CommentRequest commentRequest, Long postId);

	Comment getComment(Long postId, Long id);

	Comment updateComment(Long postId, Long id, CommentRequest commentRequest);

	ApiResponse deleteComment(Long postId, Long id);

}
