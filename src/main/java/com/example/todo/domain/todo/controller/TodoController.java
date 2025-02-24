package com.example.todo.domain.todo.controller;

import com.example.todo.domain.global.common.CommonResponse;
import com.example.todo.domain.todo.dto.TodoCreationRequestDto;
import com.example.todo.domain.todo.dto.TodoCreationResponseDto;
import com.example.todo.domain.todo.dto.TodoUpdateRequestDto;
import com.example.todo.domain.todo.dto.TodoUpdateResponseDto;
import com.example.todo.domain.todo.entity.Todo;
import com.example.todo.domain.todo.service.TodoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Todo Controller", description = "할 일 관리 API")
@RestController
@RequestMapping("/api/todos")
public class TodoController {

    private final TodoService todoService;

    @Autowired
    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @Operation(summary = "할일 생성", description = "새로운 할 일을 생성합니다.")
    @PostMapping
    public ResponseEntity<CommonResponse<TodoCreationResponseDto>> createTodo(
            @RequestBody TodoCreationRequestDto requestDto) {

        TodoCreationResponseDto todoCreationResponseDto = todoService.createTodo(requestDto);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(CommonResponse.of("할일 생성 성공", todoCreationResponseDto));
    }

    @Operation(summary = "전체 할일 조회", description = "전체 할 일을 조회합니다.")
    @GetMapping("/today")
    public List<Todo> getTodos() {

        return todoService.getAllTodos();
    }

    @Operation(summary = "할일 단일 조회", description = "ID를 통해 단일 할 일을 조회합니다.")
    @GetMapping("/today/{id}")
    public ResponseEntity<CommonResponse<TodoCreationResponseDto>> getTodoById(
            @PathVariable Long id) {

        TodoCreationResponseDto responseDto = todoService.getTodo(id);

        return ResponseEntity.ok().body(CommonResponse.of("할일 단일 조회 성공", responseDto));
    }

    @Operation(summary = "할일 수정", description = "ID를 기반으로 할일 내용을 수정합니다.")
    @PutMapping("/today/{id}")
    public ResponseEntity<CommonResponse<TodoUpdateResponseDto>> updateTodo(
            @PathVariable Long id,
            @RequestBody TodoUpdateRequestDto todoRequest) {

        TodoUpdateResponseDto updatedTodo = todoService.updateTodo(id, todoRequest);

        return ResponseEntity.ok().body(CommonResponse.of("할일 수정 성공", updatedTodo));
    }

    @Operation(summary = "할일 상태 변경", description = "ID를 기반으로 할 일의 완료 상태를 변경합니다.")
    @PatchMapping("/{id}")
    public ResponseEntity<CommonResponse<TodoUpdateResponseDto>> updateTodoState(
            @PathVariable Long id) {

        TodoUpdateResponseDto updatedTodo = todoService.updateTodoState(id);

        return ResponseEntity.ok(CommonResponse.of("할일 상태 변경 성공", updatedTodo));
    }

    @Operation(summary = "할일 삭제", description = "ID를 기반으로 할 일을 삭제합니다.")
    @DeleteMapping("/today/{id}")
    public ResponseEntity<CommonResponse<TodoUpdateResponseDto>> deleteTodo(
            @PathVariable Long id) {

        todoService.deleteTodo(id);

        return ResponseEntity.ok().body(CommonResponse.of("할일 삭제 성공", null));
    }
}
