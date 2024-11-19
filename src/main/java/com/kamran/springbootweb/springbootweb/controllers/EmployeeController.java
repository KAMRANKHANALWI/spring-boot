package com.kamran.springbootweb.springbootweb.controllers;

import com.kamran.springbootweb.springbootweb.dto.EmployeeDTO;
import com.kamran.springbootweb.springbootweb.entities.EmployeeEntity;
import com.kamran.springbootweb.springbootweb.repositories.EmployeeRepository;
import com.kamran.springbootweb.springbootweb.services.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping(path = "/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(path = "/")
    public String getMessage() {
        return "Hello Buddy";
    }

    // GET MAPPING : GET A EMPLOYEE BY ID
    @GetMapping(path = "/{id}")
    public EmployeeDTO getEmployeeById(@PathVariable Long id) {
        return employeeService.getEmployeeById(id);
    }

    // GET MAPPING : GET ALL DATA/EMPLOYEES
    @GetMapping
    public List<EmployeeDTO> getAllEmployees(@RequestParam(required = false) Integer age,
                                @RequestParam(required = false) String sortBy) {
        return employeeService.getAllEmployees();
    }

    // POST MAPPING : CREATE THE DATA
    @PostMapping
    public EmployeeDTO createNewEmployee(@RequestBody EmployeeDTO inputEmployees) {
        return employeeService.createNewEmployee(inputEmployees);
    }

    // PUT : CHANGE OR EDIT THE DATA
    @PutMapping(path = "/{id}")
    public EmployeeDTO updateEmployeeById(@RequestBody EmployeeDTO employeeDTO, @PathVariable Long id) {
        return employeeService.updateEmployeeById(employeeDTO, id);
    }

    // DELETE : DELETE THE DATA
    @DeleteMapping(path = "/{id}")
    public boolean deleteEmployeeById(@PathVariable Long id) {
        return employeeService.deleteEmployeeById(id);
    }

    // PATCH : PARTIALLY CHANGE THE DATA
    @PatchMapping(path = "/{id}")
    public EmployeeDTO updatePartialEmployeeById(@RequestBody Map<String, Object> updates, @PathVariable Long id) {
        return employeeService.updatePartialEmployeeById(id, updates);
    }
}

