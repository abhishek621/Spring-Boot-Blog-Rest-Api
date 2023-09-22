package com.abhishek.blogapi.service.impl;

import static com.abhishek.blogapi.utils.AppConstants.CREATED_AT;
import static com.abhishek.blogapi.utils.AppConstants.ID;
import static com.abhishek.blogapi.utils.AppConstants.TODO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.abhishek.blogapi.exception.BadRequestException;
import com.abhishek.blogapi.exception.ResourceNotFoundException;
import com.abhishek.blogapi.model.Todo;
import com.abhishek.blogapi.payload.ApiResponse;
import com.abhishek.blogapi.payload.PagedResponse;
import com.abhishek.blogapi.repository.TodoRepository;
import com.abhishek.blogapi.service.TodoService;
import com.abhishek.blogapi.utils.AppConstants;

@Service
public class TodoServiceImpl implements TodoService {

	@Autowired
	private TodoRepository todoRepository;


	@Override
	public Todo completeTodo(Long id ) {
		Todo todo = todoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(TODO, ID, id));

			todo.setCompleted(Boolean.TRUE);
			return todoRepository.save(todo);
	
	}

	@Override
	public Todo unCompleteTodo(Long id) {
		Todo todo = todoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(TODO, ID, id));
	
	
			todo.setCompleted(Boolean.FALSE);
			return todoRepository.save(todo);

	}

	@Override
	public PagedResponse<Todo> getAllTodos(int page, int size) {
		
		validatePageNumberAndSize(page, size);
		
		Pageable pageable = PageRequest.of(page, size, Sort.Direction.DESC, CREATED_AT);
		
		Page<Todo> todoPage = todoRepository.findAll(pageable);

        List<Todo> todos = todoPage.getContent();
        long totalElements = todoPage.getTotalElements();
        int totalPages = todoPage.getTotalPages();
        boolean isLast = todoPage.isLast();

        return new PagedResponse<>(todos, page, size, totalElements, totalPages, isLast);
	
	}

	@Override
	public Todo addTodo(Todo todo) {
		
		return todoRepository.save(todo);
	}

	@Override
	public Todo getTodo(Long id) {
	
		Todo todo = todoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(TODO, ID, id));

		
			return todo;

	}

	@Override
	public Todo updateTodo(Long id, Todo newTodo) {
		
		Todo todo = todoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(TODO, ID, id));
	
			todo.setTitle(newTodo.getTitle());
			todo.setCompleted(newTodo.getCompleted());
			return todoRepository.save(todo);
	
	}

	@Override
	public ApiResponse deleteTodo(Long id) {
		
	todoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(TODO, ID, id));

			todoRepository.deleteById(id);
			return new ApiResponse(Boolean.TRUE, "You successfully deleted todo");

	}

	private void validatePageNumberAndSize(int page, int size) {
		if (page < 0) {
			throw new BadRequestException("Page number cannot be less than zero.");
		}

		if (size < 0) {
			throw new BadRequestException("Size number cannot be less than zero.");
		}

		if (size > AppConstants.MAX_PAGE_SIZE) {
			throw new BadRequestException("Page size must not be greater than " + AppConstants.MAX_PAGE_SIZE);
		}
	}
}
