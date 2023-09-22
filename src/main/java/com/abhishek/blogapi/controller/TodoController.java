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

import com.abhishek.blogapi.model.Todo;
import com.abhishek.blogapi.payload.ApiResponse;
import com.abhishek.blogapi.payload.PagedResponse;
import com.abhishek.blogapi.service.TodoService;
import com.abhishek.blogapi.utils.AppConstants;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/todos")
public class TodoController {

	@Autowired
	private TodoService todoService;

	@GetMapping
	public ResponseEntity<PagedResponse<Todo>> getAllTodos(
			@RequestParam(value = "page", required = false, defaultValue = AppConstants.DEFAULT_PAGE_NUMBER) Integer page,
			@RequestParam(name = "size", required = false, defaultValue = AppConstants.DEFAULT_PAGE_SIZE) Integer size) {

		PagedResponse<Todo> response = todoService.getAllTodos(page, size);

		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Todo> addTodo(@Valid @RequestBody Todo todo) {
		Todo newTodo = todoService.addTodo(todo);

		return new ResponseEntity<>(newTodo, HttpStatus.CREATED);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Todo> getTodo(@PathVariable(value = "id") Long id) {
		Todo todo = todoService.getTodo(id);

		return new ResponseEntity<>(todo, HttpStatus.OK);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Todo> updateTodo(@PathVariable(value = "id") Long id, @Valid @RequestBody Todo newTodo) {
		Todo updatedTodo = todoService.updateTodo(id, newTodo);

		return new ResponseEntity<>(updatedTodo, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<ApiResponse> deleteTodo(@PathVariable(value = "id") Long id) {
		ApiResponse apiResponse = todoService.deleteTodo(id);

		return new ResponseEntity<>(apiResponse, HttpStatus.OK);
	}

	@PutMapping("/{id}/complete")
	public ResponseEntity<Todo> completeTodo(@PathVariable(value = "id") Long id) {

		Todo todo = todoService.completeTodo(id);

		return new ResponseEntity<>(todo, HttpStatus.OK);
	}

	@PutMapping("/{id}/unComplete")
	public ResponseEntity<Todo> unCompleteTodo(@PathVariable(value = "id") Long id) {

		Todo todo = todoService.unCompleteTodo(id);

		return new ResponseEntity<>(todo, HttpStatus.OK);
	}
}
