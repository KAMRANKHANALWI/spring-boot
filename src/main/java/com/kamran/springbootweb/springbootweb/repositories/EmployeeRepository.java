package com.kamran.springbootweb.springbootweb.repositories;

import com.kamran.springbootweb.springbootweb.entities.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

//1. Which type of entity you want to handle, 2. Tell me the id type of this entity
@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> {
//    List<EmployeeEntity> findByName(String name);
}
