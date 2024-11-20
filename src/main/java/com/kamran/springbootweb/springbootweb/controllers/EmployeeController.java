package com.kamran.springbootweb.springbootweb.controllers;

import com.kamran.springbootweb.springbootweb.dto.EmployeeDTO;
import com.kamran.springbootweb.springbootweb.entities.EmployeeEntity;
import com.kamran.springbootweb.springbootweb.exceptions.ResourceNotFoundException;
import com.kamran.springbootweb.springbootweb.repositories.EmployeeRepository;
import com.kamran.springbootweb.springbootweb.services.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.*;

@RestController
@RequestMapping(path = "/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    // GET MAPPING : GET A EMPLOYEE BY ID
    @GetMapping(path = "/{id}")
    public ResponseEntity<EmployeeDTO> getEmployeeById(@PathVariable Long id) {
        Optional<EmployeeDTO> employeeDTO = employeeService.getEmployeeById(id);
        return employeeDTO
                .map(employeeDTO1 -> ResponseEntity.ok(employeeDTO1))
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found with id: " + id));
    }

    // REPLACED IT WITH GLOBAL EXCEPTION HANDLER
//    @ExceptionHandler(NoSuchElementException.class)
//    public ResponseEntity<String> handleEmployeeNotFound(NoSuchElementException exception) {
//        return new ResponseEntity<>("Employee was not found", HttpStatus.NOT_FOUND);
//    }

    // GET MAPPING : GET ALL DATA/EMPLOYEES
    @GetMapping
    public ResponseEntity<List<EmployeeDTO>> getAllEmployees(@RequestParam(required = false) Integer age,
                                @RequestParam(required = false) String sortBy) {
        return ResponseEntity.ok(employeeService.getAllEmployees());
    }

    // POST MAPPING : CREATE THE DATA
    @PostMapping
    public ResponseEntity<EmployeeDTO> createNewEmployee(@RequestBody @Valid EmployeeDTO inputEmployees) {
        EmployeeDTO savedEmployee = employeeService.createNewEmployee(inputEmployees);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

    // PUT : CHANGE OR EDIT THE DATA
    @PutMapping(path = "/{id}")
    public ResponseEntity<EmployeeDTO> updateEmployeeById(@RequestBody @Valid EmployeeDTO employeeDTO, @PathVariable Long id) {
        return ResponseEntity.ok(employeeService.updateEmployeeById(employeeDTO, id));
    }

    // DELETE : DELETE THE DATA
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Boolean> deleteEmployeeById(@PathVariable Long id) {
        boolean gotDeleted = employeeService.deleteEmployeeById(id);
        if(gotDeleted) return ResponseEntity.ok(true);
        return ResponseEntity.notFound().build();
    }

    // PATCH : PARTIALLY CHANGE THE DATA
    @PatchMapping(path = "/{id}")
    public ResponseEntity<EmployeeDTO> updatePartialEmployeeById(@RequestBody Map<String, Object> updates, @PathVariable Long id) {
        EmployeeDTO employeeDTO = employeeService.updatePartialEmployeeById(id, updates);
        if(employeeDTO == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(employeeDTO);
    }
}

