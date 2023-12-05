package com.manu.todomanagement.controller;

import com.manu.todomanagement.dto.TodoDto;
import com.manu.todomanagement.service.TodoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/todo")
@AllArgsConstructor
public class TodoController {
    private TodoService todoService;


    @PostMapping("/create")
    public ResponseEntity<TodoDto> addTodo(@RequestBody  TodoDto todoDto)
    {
        TodoDto savedTodo = todoService.addTodo(todoDto);
        return  new ResponseEntity<>(savedTodo, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<TodoDto> getTodoById(@PathVariable("id") Long id)
    {
        TodoDto todoDto = todoService.getTodoById(id);
        return  new ResponseEntity<>(todoDto,HttpStatus.OK);
    }

    @GetMapping("/allTodos")
    public  ResponseEntity<List<TodoDto>> getAllTodo()
    {
        List<TodoDto> todos = todoService.getAllTodo();
        return new ResponseEntity<>(todos,HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public  ResponseEntity<TodoDto> updateTodo(@PathVariable("id") Long todoId, @RequestBody TodoDto todo)
    {
        todo.setId(todoId);
        TodoDto todoUpdate = todoService.updateTodo(todo);
        return new ResponseEntity<>(todoUpdate,HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteTodo(@PathVariable("id") Long id)
    {
        todoService.deleteTodo(id);
        return new ResponseEntity<>("Todo has been deleted",HttpStatus.OK);
    }


    @PatchMapping("/complete/{id}")
    public ResponseEntity<TodoDto> completeDto(@PathVariable("id") Long id)
    {
        try
        {
            TodoDto todo = todoService.completeDto(id);
            return new ResponseEntity<>(todo,HttpStatus.OK);
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
