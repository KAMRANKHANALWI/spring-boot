package com.kamran.springbootweb.springbootweb.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

// define validation and req-res entity in this layer
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTO {
    private Long Id;
    @NotBlank(message = "Name of the employee can't be blank")
    @Size(min = 3, max = 15, message = "Number of char in name should be in range : [3 - 15")
    private String name;

    @Email(message = "Email should be a valid email")
    private String email;

    @Max(value = 80, message = "Age of employee can't be greater than 80")
    @Min(value = 18, message = "Age of employee can't be less than 18")
    private Integer age;

    @NotNull(message = "Salary of employee should not null")
    @Positive(message = "Salary of employee should be positive")
    @Digits(integer = 6,fraction = 2, message = "The salary should be in the form XXXXXX.YY")
    @DecimalMax(value = "100000.99")
    @DecimalMin(value = "100.50")
    private Double salary;

    @PastOrPresent(message = "DateOfJoining field of Employee cannot be in the future")
    private LocalDate dateOfJoining;

    @AssertTrue(message = "Employee should be active")
    @JsonProperty("isActive")
    private Boolean isActive;
}
