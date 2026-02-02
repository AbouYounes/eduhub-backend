# EduHub - Professional Course Management API

EduHub is a robust Spring Boot backend designed for educational platforms to manage students, courses, and enrollments. This project demonstrates modern Java development standards and clean architecture principles.

## 🚀 Key Features
- **Many-to-Many Relationships:** Complex data mapping between Students and Courses using JPA.
- **DTO Pattern:** Decoupling of the persistence layer from the presentation layer to ensure security and API stability.
- **Automated Mapping:** Using **MapStruct** for efficient and type-safe object transformations.
- **Global Exception Handling:** Centralized error management for consistent and user-friendly API responses.
- **Data Validation:** Strict input validation using Jakarta Bean Validation.
- **Interactive API Documentation:** Integrated **Swagger UI** for real-time API exploration.

## 🛠 Tech Stack
- **Java 21** & **Spring Boot 3**
- **Spring Data JPA** (Hibernate)
- **H2 Database** (In-Memory for development)
- **MapStruct** & **Lombok**
- **Maven**

## 🏗 Architecture
The project follows a classic **Layered Architecture**:
1. **Controller Layer:** Handles HTTP requests and returns DTOs.
2. **Service Layer:** Contains business logic and handles entity-DTO transformations.
3. **Repository Layer:** Manages database interaction via JpaRepository.
4. **Exception Handling:** Centralized `@ControllerAdvice` for robust error management.

## 🚦 How to Run
1. Clone the repository: `git clone https://github.com/AbouYounes/eduhub-backend.git`
2. Run the application: `./mvnw spring-boot:run`
3. Access Swagger UI: `http://localhost:8080/swagger-ui/index.html`
4. Access H2 Console: `http://localhost:8080/h2-console` (JDBC URL: `jdbc:h2:mem:edudb`)