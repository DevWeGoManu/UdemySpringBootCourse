package com.manu.todomanagement.service;

import com.manu.todomanagement.dto.TodoDto;
import com.manu.todomanagement.entity.Todo;
import com.manu.todomanagement.mapper.AutoTodoMapper;
import com.manu.todomanagement.repository.TodoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class TodoImpl implements TodoService{

    private TodoRepository todoRepository;
    @Override
    public TodoDto addTodo(TodoDto todoDto) {

        //convert Todo into Todo Jpa entity
        Todo todo =  AutoTodoMapper.MAPPER.mapToTodo(todoDto);
        Todo savedTodo = todoRepository.save(todo);

        //Convert saved Todo Jpa entity obj into TodoDto obj
        return AutoTodoMapper.MAPPER.mapToTodoDto(savedTodo);
    }

    @Override
    public TodoDto getTodoById(Long id) {
        Optional<Todo> optionalTodo = todoRepository.findById(id);
        Todo todo = optionalTodo.orElse(null);
        assert todo != null;
        return AutoTodoMapper.MAPPER.mapToTodoDto(optionalTodo.get());
    }

    @Override
    public List<TodoDto> getAllTodo() {
        List<Todo> userList = todoRepository.findAll();
        return userList.stream().map((AutoTodoMapper.MAPPER::mapToTodoDto))
                .collect(Collectors.toList());
    }

    @Override
    public TodoDto updateTodo(TodoDto todoDto) {
        Todo newTodo = todoRepository.findById(todoDto.getId()).orElse(null);
        assert newTodo != null;
        newTodo.setTitle(todoDto.getTitle());
        newTodo.setDescription(todoDto.getDescription());
        newTodo.setCompleted(todoDto.isCompleted());
        Todo updatedTodo = todoRepository.save(newTodo);

        return AutoTodoMapper.MAPPER.mapToTodoDto(updatedTodo);
    }

    @Override
    public void deleteTodo(Long id) {
        todoRepository.deleteById(id);
    }

    @Override
    public TodoDto completeDto(Long id) {
        Todo todo = todoRepository.findById(id).orElse(null);
        assert todo != null;
        todo.setCompleted(Boolean.FALSE);
        Todo updatedTodo = todoRepository.save(todo);
        return  AutoTodoMapper.MAPPER.mapToTodoDto(updatedTodo);
    }
}
