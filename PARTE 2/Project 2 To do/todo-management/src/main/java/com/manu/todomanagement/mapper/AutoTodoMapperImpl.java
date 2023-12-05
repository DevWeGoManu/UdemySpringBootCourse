package com.manu.todomanagement.mapper;

import com.manu.todomanagement.dto.TodoDto;
import com.manu.todomanagement.entity.Todo;

public class AutoTodoMapperImpl {

    public static TodoDto mapToTodoDto(Todo todo) {
        return new TodoDto(
                todo.getId(),
                todo.getTitle(),
                todo.getDescription(),
                todo.isCompleted()
        );
    }


    public static Todo mapToTodo(TodoDto todoDto) {
        return new Todo(
                todoDto.getId(),
                todoDto.getTitle(),
                todoDto.getDescription(),
                todoDto.isCompleted()
        );
    }
}
