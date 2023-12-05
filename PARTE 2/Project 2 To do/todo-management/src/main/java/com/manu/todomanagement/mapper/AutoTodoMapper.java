package com.manu.todomanagement.mapper;
import com.manu.todomanagement.dto.TodoDto;
import com.manu.todomanagement.entity.Todo;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;


@Mapper
public interface AutoTodoMapper {
    AutoTodoMapper MAPPER = Mappers.getMapper(AutoTodoMapper.class);
    TodoDto mapToTodoDto(Todo todo);
    Todo mapToTodo(TodoDto todoDto);
}
