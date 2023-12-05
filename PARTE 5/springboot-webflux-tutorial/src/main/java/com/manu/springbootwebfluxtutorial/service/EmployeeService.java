package com.manu.springbootwebfluxtutorial.service;

import com.manu.springbootwebfluxtutorial.dto.EmployeeDto;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public interface EmployeeService {
    Mono<EmployeeDto> saveEmployee(EmployeeDto employeeDto);
    Mono<EmployeeDto> getEmployee(String id);
    Flux<EmployeeDto> getAllEmployee();
    Mono<EmployeeDto> updateEmployee(EmployeeDto employeeDto,String id);
    Mono<Void> deleteEmployee(String id);
}
