package com.abhishek.blogapi.service;

import com.abhishek.blogapi.model.Todo;
import com.abhishek.blogapi.payload.ApiResponse;
import com.abhishek.blogapi.payload.PagedResponse;

public interface TodoService {

	Todo completeTodo(Long id);

	Todo unCompleteTodo(Long id);

	PagedResponse<Todo> getAllTodos(int page, int size);

	Todo addTodo(Todo todo);

	Todo getTodo(Long id);

	Todo updateTodo(Long id, Todo newTodo);

	ApiResponse deleteTodo(Long id);

}
