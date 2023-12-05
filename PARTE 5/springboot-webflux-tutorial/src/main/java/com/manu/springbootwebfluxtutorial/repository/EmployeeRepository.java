package com.manu.springbootwebfluxtutorial.repository;

import com.manu.springbootwebfluxtutorial.entity.Employee;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends ReactiveCrudRepository<Employee,String> {
}
