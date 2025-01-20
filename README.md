# Spring Boot Concepts

This repository contains various **Spring Boot concepts** that cover essential features and functionalities commonly used in 80% of real-world applications. It includes concepts such as **RESTful API development**, **validation**, **database interactions**, and **application configuration**.

## **Features and Concepts Covered**

- **Spring Boot Web**: Build RESTful web applications with ease.
- **Validation**: Data validation using `javax.validation` and Spring Boot Starter Validation.
- **Database Management**: Use of JPA with H2 in-memory database.
- **Model Mapping**: Efficient object mapping with ModelMapper.
- **Lombok**: Simplifies Java code by reducing boilerplate.
- **Testing**: Unit and integration testing with Spring Boot Starter Test.

---

## **Project Setup**

### **Prerequisites**
- Java 11 or higher
- Maven (for dependency management)
- IDE (IntelliJ/VS Code/Eclipse)

### **Installation**

1. Clone the repository:
   ```bash
   git clone https://github.com/KAMRANKHANALWI/spring-boot.git
   ```
   

2. Build the project using Maven:
   ```bash
   mvn clean install
   ```

3. Run the application:
   ```bash
   mvn spring-boot:run
   ```

The application will start on `http://localhost:8080`.

---

## **Project Structure**

```
spring-boot-concepts/
├── src/
│   ├── main/
│   │   ├── java/com/kamran/springbootweb/
│   │   │   ├── controllers/   # Handles API requests
│   │   │   ├── services/      # Business logic layer
│   │   │   ├── repositories/  # Data access layer (JPA Repositories)
│   │   │   ├── models/        # Data models/entities
│   │   │   ├── advices/       # Exception handling
│   │   │   ├── SpringbootwebApplication.java  # Main application entry point
│   ├── test/                  # Test cases for components
├── pom.xml                    # Maven dependencies
├── README.md                   # Documentation
```

---

## **Concepts Learned**

### **1. Spring Boot Starter Web**
- **What is it?**  
  A starter dependency to build web applications and REST APIs.
- **Why used?**  
  Provides auto-configuration for Spring MVC and embedded Tomcat server.
- **Key Features:**  
  - RESTful controllers (`@RestController`)
  - Request handling with `@GetMapping`, `@PostMapping`, etc.
  - Exception handling with `@ControllerAdvice`.

---

### **2. Spring Boot Validation**
- **What is it?**  
  Validates request data using annotations like `@NotNull`, `@Size`, etc.
- **Why used?**  
  Ensures data integrity before processing requests.
- **Key Features:**  
  - `@Valid` annotation to trigger validation.
  - Custom error messages via `@ExceptionHandler`.

**Example:**
```java
@Valid
public ResponseEntity<User> createUser(@RequestBody @Valid User user) {
   return ResponseEntity.ok(userService.save(user));
}
```

---

### **3. Spring Data JPA**
- **What is it?**  
  An abstraction layer for database interactions.
- **Why used?**  
  Simplifies database access with repository interfaces.
- **Key Features:**  
  - `CrudRepository` and `JpaRepository` for CRUD operations.
  - Query methods like `findById`, `findAll`, etc.

**Example:**
```java
public interface UserRepository extends JpaRepository<User, Long> {
   Optional<User> findByEmail(String email);
}
```

---

### **4. H2 Database**
- **What is it?**  
  A lightweight in-memory database for testing and development.
- **Why used?**  
  Allows testing without the need for an external database.
- **Key Features:**  
  - Auto-configuration in `application.properties`
  - Web console for inspecting data (`http://localhost:8080/h2-console`).

**Example Configuration:**
```properties
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=
```

---

### **5. Lombok**
- **What is it?**  
  A library to reduce boilerplate code in Java (e.g., getters, setters).
- **Why used?**  
  Makes code cleaner and easier to maintain.
- **Key Annotations:**  
  - `@Data` - Generates getters, setters, toString, and equals methods.
  - `@NoArgsConstructor` and `@AllArgsConstructor` - Generates constructors.

**Example:**
```java
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
   private Long id;
   private String name;
   private String email;
}
```

---

### **6. ModelMapper**
- **What is it?**  
  A library for object-to-object mapping.
- **Why used?**  
  Converts DTOs to entities and vice versa without manual mapping.
- **Example:**
```java
ModelMapper modelMapper = new ModelMapper();
UserDTO userDTO = modelMapper.map(user, UserDTO.class);
```

---

### **7. Exception Handling**
- **What is it?**  
  A mechanism to handle application errors gracefully.
- **Why used?**  
  Provides user-friendly error messages and logs.
- **Key Components:**  
  - `@ControllerAdvice` for centralized error handling.
  - `@ExceptionHandler` for specific exception handling.

**Example:**
```java
@ControllerAdvice
public class GlobalExceptionHandler {
   @ExceptionHandler(ResourceNotFoundException.class)
   public ResponseEntity<String> handleNotFound(ResourceNotFoundException ex) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
   }
}
```

---

## **Running Tests**

To run unit tests, use the following command:

```bash
mvn test
```

Test cases are written to validate controllers and services.

---




