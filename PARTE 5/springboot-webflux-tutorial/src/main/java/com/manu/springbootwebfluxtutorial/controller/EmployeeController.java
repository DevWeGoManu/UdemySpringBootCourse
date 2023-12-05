package com.manu.springbootwebfluxtutorial.controller;

import com.manu.springbootwebfluxtutorial.dto.EmployeeDto;
import com.manu.springbootwebfluxtutorial.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/employees")
@AllArgsConstructor

public class EmployeeController {


    private EmployeeService employeeService;


    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public Mono<EmployeeDto> saveEmployee(@RequestBody EmployeeDto employeeDto)
    {
        return employeeService.saveEmployee(employeeDto);
    }

    @GetMapping("{id}")
    public Mono<EmployeeDto> getEmployee(@PathVariable("id") String id)
    {
        return employeeService.getEmployee(id);
    }

    @GetMapping("/all")
    public Flux<EmployeeDto> getAllEmployee()
    {
        return employeeService.getAllEmployee();
    }

    @PutMapping("{id}")
    public Mono<EmployeeDto> updateEmployee(@PathVariable("id") String id, @RequestBody EmployeeDto employeeDto)
    {
        return employeeService.updateEmployee(employeeDto,id);
    }

    @DeleteMapping("{id}")
    public Mono<Void> deleteEmployee(@PathVariable("id") String id)
    {
        return employeeService.deleteEmployee(id);
    }
}
