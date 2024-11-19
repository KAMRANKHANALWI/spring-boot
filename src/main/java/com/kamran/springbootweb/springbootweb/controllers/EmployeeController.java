package com.kamran.springbootweb.springbootweb.controllers;

import com.kamran.springbootweb.springbootweb.dto.EmployeeDTO;
import com.kamran.springbootweb.springbootweb.entities.EmployeeEntity;
import com.kamran.springbootweb.springbootweb.repositories.EmployeeRepository;
import com.kamran.springbootweb.springbootweb.services.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
//@RequestMapping(path = "/api") // Parent Path
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(path = "/")
    public String getMessage() {
        return "Hello Buddy";
    }

    // 1. PATH VARIABLE, 2. REQUEST PARAM

    // PART 1
//    @GetMapping(path = "/employees/{id}")
////    public String getEmployeeById(@PathVariable(name = "employeeId") Long id) {
//    public String getEmployeeById(@PathVariable Long id) {
//        return new EmployeeDTO(id, "Kamran", "kamran@gmail.com", "21", LocalDate.of(2024, 11, 19), true);
//    }

    // PART 2 : GET EMPLOYEE BY ID - SINGLE DATA
    @GetMapping(path = "/employees/{id}")
    public EmployeeEntity getEmployeeById(@PathVariable Long id) {
        return employeeService.getEmployeeById(id);
    }

    // PART 1
//    @GetMapping(path = "/employees")
//    public String getAllEmployees(@RequestParam(required = false) Integer age,
//                                  @RequestParam(required = false) String sortBy) {
//        return "Hii, I am " + age + " year old " + sortBy;
//    }

    // PART 2 : GET THE DATA
    @GetMapping(path = "/employees")
    public List<EmployeeEntity> getAllEmployees(@RequestParam(required = false) Integer age,
                                @RequestParam(required = false) String sortBy) {
        return employeeService.getAllEmployees();
    }

//    @PostMapping(path = "/employees")
//    public String createNewEmployee() {
//        return "Hello from POST";
//    }

    // PART 1
//    @PostMapping(path = "/employees")
//    public EmployeeDTO createNewEmployee(@RequestBody EmployeeDTO inputEmployees) {
//        inputEmployees.setId(100L);
//        return  inputEmployees;
//    }
//}

    // PART 2 : CREATE THE DATA
    @PostMapping(path = "/employees")
    public EmployeeEntity createNewEmployee(@RequestBody EmployeeEntity inputEmployees) {
        return employeeService.createNewEmployee(inputEmployees);
    }
}

