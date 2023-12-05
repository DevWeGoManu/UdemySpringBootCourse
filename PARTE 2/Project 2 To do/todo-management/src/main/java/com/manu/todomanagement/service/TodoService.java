package com.manu.todomanagement.service;

import com.manu.todomanagement.dto.TodoDto;
import com.manu.todomanagement.entity.Todo;

import java.util.List;

public interface TodoService {

    TodoDto addTodo(TodoDto  todoDto);
    TodoDto getTodoById(Long id);
    List<TodoDto> getAllTodo();
    TodoDto updateTodo(TodoDto todoDto);
    void deleteTodo(Long id);

    TodoDto completeDto(Long id);
}
