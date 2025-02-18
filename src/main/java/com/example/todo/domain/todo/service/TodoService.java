package com.example.todo.domain.todo.service;

import com.example.todo.domain.todo.dto.TodoCreationRequestDto;
import com.example.todo.domain.todo.dto.TodoCreationResponseDto;
import com.example.todo.domain.todo.entity.Todo;
import com.example.todo.domain.todo.repository.TodoRepository;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class TodoService {

    private final TodoRepository todoRepository;

    @Transactional
    public TodoCreationResponseDto createTodo(TodoCreationRequestDto requestDto) {

        Todo todo = Todo.builder()
                .description(requestDto.getDescription())
                .build();

        Todo savedTodo = todoRepository.save(todo);

        return new TodoCreationResponseDto(
                savedTodo.getId(),
                savedTodo.getDescription(),
                savedTodo.isCompleted(),
                savedTodo.getCreatedAt()
        );
    }

    @Transactional
    public List<Todo> getAllTodos() {

        return todoRepository.findAll();
    }

    @Transactional
    public TodoCreationResponseDto getTodo(Long id) {

        Todo todo = todoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Todo not found"));

        return new TodoCreationResponseDto(
                todo.getId(),
                todo.getDescription(),
                todo.isCompleted(),
                todo.getCreatedAt()
        );
    }
}
