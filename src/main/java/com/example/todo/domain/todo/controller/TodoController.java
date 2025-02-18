package com.example.todo.domain.todo.controller;

import com.example.todo.domain.global.common.CommonResponse;
import com.example.todo.domain.todo.dto.TodoCreationRequestDto;
import com.example.todo.domain.todo.dto.TodoCreationResponseDto;
import com.example.todo.domain.todo.entity.Todo;
import com.example.todo.domain.todo.service.TodoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/todos")
public class TodoController {

    private final TodoService todoService;

    @Autowired
    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @PostMapping
    public ResponseEntity<TodoCreationResponseDto> createTodo(
            @RequestBody TodoCreationRequestDto requestDto) {

        TodoCreationResponseDto todoCreationResponseDto = todoService.createTodo(requestDto);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(todoCreationResponseDto);
    }

    @GetMapping("/today")
    public List<Todo> getTodos() {

        return todoService.getAllTodos();
    }

    @GetMapping("/today/{id}")
    public ResponseEntity<CommonResponse<TodoCreationResponseDto>> getTodoById(
            @PathVariable Long id) {

        TodoCreationResponseDto responseDto = todoService.getTodo(id);

        return ResponseEntity.ok(CommonResponse.of("할일 단일 조회 성공", responseDto));
    }
}
