# Project Annotations Documentation

This file documents all the annotations used in the **ProfileHub** Spring Boot project, their purpose, and the files where they are applied.

---

## 🏗️ Core & Spring Boot Annotations

### `@SpringBootApplication`
- **Definition**: A convenience annotation that adds all of the following: `@Configuration`, `@EnableAutoConfiguration`, and `@ComponentScan`.
- **Purpose**: Marks the main class of a Spring Boot application.
- **Used In**:
    - [ProfileHubApplication.java](file:///d:/SpringBootPractice/ProfileHub/src/main/java/com/livingston/ProfileHub/ProfileHubApplication.java)

### `@Service`
- **Definition**: Marks a class as a service layer component.
- **Purpose**: Indicates that the class performs some business logic.
- **Used In**:
    - [StudentService.java](file:///d:/SpringBootPractice/ProfileHub/src/main/java/com/livingston/ProfileHub/service/StudentService.java)

### `@Configuration`
- **Definition**: Indicates that a class declares one or more `@Bean` methods and may be processed by the Spring container to generate bean definitions and service requests for those beans at runtime.
- **Purpose**: Used for setting up bean configurations.
- **Used In**:
    - [SecurityConfig.java](file:///d:/SpringBootPractice/ProfileHub/src/main/java/com/livingston/ProfileHub/security/SecurityConfig.java)
    - [FileUploadConfig.java](file:///d:/SpringBootPractice/ProfileHub/src/main/java/com/livingston/ProfileHub/config/FileUploadConfig.java)
    - [CorsConfig.java](file:///d:/SpringBootPractice/ProfileHub/src/main/java/com/livingston/ProfileHub/config/CorsConfig.java)

### `@Bean`
- **Definition**: Indicates that a method produces a bean to be managed by the Spring container.
- **Purpose**: Marks a factory method for a Spring bean.
- **Used In**:
    - [SecurityConfig.java](file:///d:/SpringBootPractice/ProfileHub/src/main/java/com/livingston/ProfileHub/security/SecurityConfig.java)
    - [CorsConfig.java](file:///d:/SpringBootPractice/ProfileHub/src/main/java/com/livingston/ProfileHub/config/CorsConfig.java)

### `@Autowired`
- **Definition**: Marks a constructor, field, setter method, or config method as to be autowired by Spring's dependency injection facilities.
- **Purpose**: Enables automatic dependency injection.
- **Used In**:
    - [StudentService.java](file:///d:/SpringBootPractice/ProfileHub/src/main/java/com/livingston/ProfileHub/service/StudentService.java)
    - [StudentController.java](file:///d:/SpringBootPractice/ProfileHub/src/main/java/com/livingston/ProfileHub/controller/StudentController.java)

---

## 🌐 Web & REST Annotations

### `@RestController`
- **Definition**: A specialized version of the controller. It includes the `@Controller` and `@ResponseBody` annotations.
- **Purpose**: Used for creating RESTful web services.
- **Used In**:
    - [StudentController.java](file:///d:/SpringBootPractice/ProfileHub/src/main/java/com/livingston/ProfileHub/controller/StudentController.java)

### `@RequestMapping`
- **Definition**: Maps HTTP requests to handler methods of MVC and REST controllers.
- **Purpose**: Defines the base path for API endpoints in a controller.
- **Used In**:
    - [StudentController.java](file:///d:/SpringBootPractice/ProfileHub/src/main/java/com/livingston/ProfileHub/controller/StudentController.java)

### `@GetMapping`
- **Definition**: Specialized version of `@RequestMapping` for HTTP GET requests.
- **Purpose**: Maps GET requests to specific handler methods.
- **Used In**:
    - [StudentController.java](file:///d:/SpringBootPractice/ProfileHub/src/main/java/com/livingston/ProfileHub/controller/StudentController.java)

### `@PostMapping`
- **Definition**: Specialized version of `@RequestMapping` for HTTP POST requests.
- **Purpose**: Maps POST requests to specific handler methods.
- **Used In**:
    - [StudentController.java](file:///d:/SpringBootPractice/ProfileHub/src/main/java/com/livingston/ProfileHub/controller/StudentController.java)

### `@PutMapping`
- **Definition**: Specialized version of `@RequestMapping` for HTTP PUT requests.
- **Purpose**: Maps PUT requests to specific handler methods.
- **Used In**:
    - [StudentController.java](file:///d:/SpringBootPractice/ProfileHub/src/main/java/com/livingston/ProfileHub/controller/StudentController.java)

### `@DeleteMapping`
- **Definition**: Specialized version of `@RequestMapping` for HTTP DELETE requests.
- **Purpose**: Maps DELETE requests to specific handler methods.
- **Used In**:
    - [StudentController.java](file:///d:/SpringBootPractice/ProfileHub/src/main/java/com/livingston/ProfileHub/controller/StudentController.java)

### `@RequestBody`
- **Definition**: Maps the HttpRequest body to a transfer or domain object, enabling automatic deserialization.
- **Purpose**: Binds the web request body with the object.
- **Used In**:
    - [StudentController.java](file:///d:/SpringBootPractice/ProfileHub/src/main/java/com/livingston/ProfileHub/controller/StudentController.java)

### `@PathVariable`
- **Definition**: Indicates that a method parameter should be bound to a URI template variable.
- **Purpose**: Extracts values from the URI path.
- **Used In**:
    - [StudentController.java](file:///d:/SpringBootPractice/ProfileHub/src/main/java/com/livingston/ProfileHub/controller/StudentController.java)

### `@RequestParam`
- **Definition**: Indicates that a method parameter should be bound to a web request parameter.
- **Purpose**: Extracts query parameters from the URL.
- **Used In**:
    - [StudentController.java](file:///d:/SpringBootPractice/ProfileHub/src/main/java/com/livingston/ProfileHub/controller/StudentController.java)

---

## 💾 Persistance (JPA) Annotations

### `@Entity`
- **Definition**: Specifies that the class is an entity and is mapped to a database table.
- **Purpose**: Marks a class as a JPA entity.
- **Used In**:
    - [Student.java](file:///d:/SpringBootPractice/ProfileHub/src/main/java/com/livingston/ProfileHub/entity/Student.java)

### `@Id`
- **Definition**: Specifies the primary key of an entity.
- **Purpose**: Marks the field as the primary key.
- **Used In**:
    - [Student.java](file:///d:/SpringBootPractice/ProfileHub/src/main/java/com/livingston/ProfileHub/entity/Student.java)

### `@GeneratedValue`
- **Definition**: Provides for the specification of generation strategies for the values of primary keys.
- **Purpose**: Configures how the primary key values are generated.
- **Used In**:
    - [Student.java](file:///d:/SpringBootPractice/ProfileHub/src/main/java/com/livingston/ProfileHub/entity/Student.java)

---

## ⚠️ Exception Handling Annotations

### `@ControllerAdvice`
- **Definition**: A specialization of `@Component` for classes that declare `@ExceptionHandler`, `@InitBinder`, or `@ModelAttribute` methods to be shared across multiple `@Controller` classes.
- **Purpose**: Global exception handling.
- **Used In**:
    - [GlobalExceptionHandler.java](file:///d:/SpringBootPractice/ProfileHub/src/main/java/com/livingston/ProfileHub/exception/GlobalExceptionHandler.java)

### `@ExceptionHandler`
- **Definition**: Annotation for handling exceptions in specific handler classes and/or handler methods.
- **Purpose**: Specific handler for exceptions.
- **Used In**:
    - [GlobalExceptionHandler.java](file:///d:/SpringBootPractice/ProfileHub/src/main/java/com/livingston/ProfileHub/exception/GlobalExceptionHandler.java)

---

## ✅ Validation Annotations

### `@NotBlank`
- **Definition**: The annotated element must not be null and must contain at least one non-whitespace character.
- **Purpose**: Field-level validation.
- **Used In**:
    - [StudentDTO.java](file:///d:/SpringBootPractice/ProfileHub/src/main/java/com/livingston/ProfileHub/dto/StudentDTO.java)

---

## ⚙️ Standard Java Annotations

### `@Override`
- **Definition**: Indicates that a method declaration is intended to override a method declaration in a supertype.
- **Purpose**: Safety check for method overriding.
- **Used In**:
    - [CorsConfig.java](file:///d:/SpringBootPractice/ProfileHub/src/main/java/com/livingston/ProfileHub/config/CorsConfig.java)
