package com.manu.springbootwebfluxtutorial.service;

import com.manu.springbootwebfluxtutorial.dto.EmployeeDto;
import com.manu.springbootwebfluxtutorial.entity.Employee;
import com.manu.springbootwebfluxtutorial.mapper.EmployeeMapper;
import com.manu.springbootwebfluxtutorial.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Service
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;
    @Override
    public Mono<EmployeeDto> saveEmployee(EmployeeDto employeeDto) {
        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
        Mono<Employee> savedEmployee = employeeRepository.save(employee);
        return savedEmployee.map(EmployeeMapper::mapToEmployeeDto);
    }

    @Override
    public Mono<EmployeeDto> getEmployee(String id) {
        Mono<Employee> getEmploye = employeeRepository.findById(id);
        return getEmploye.map(EmployeeMapper::mapToEmployeeDto);
    }

    @Override
    public Flux<EmployeeDto> getAllEmployee() {
        Flux<Employee> employeeList = employeeRepository.findAll();
        return employeeList.map(EmployeeMapper::mapToEmployeeDto).switchIfEmpty(Flux.empty());
    }

    @Override
    public Mono<EmployeeDto> updateEmployee(EmployeeDto employeeDto, String id) {
        Mono<Employee> employeeId = employeeRepository.findById(id);

        Mono<Employee> updatingEmployee = employeeId.flatMap((existEmployee)-> {
            existEmployee.setFirstName(employeeDto.getFirstName());
            existEmployee.setLastName(employeeDto.getLastName());
            existEmployee.setEmail(employeeDto.getEmail());

            return employeeRepository.save(existEmployee);
        });
        return updatingEmployee.map(EmployeeMapper::mapToEmployeeDto);
    }

    @Override
    public Mono<Void> deleteEmployee(String id) {
        return employeeRepository.deleteById(id);

    }
}