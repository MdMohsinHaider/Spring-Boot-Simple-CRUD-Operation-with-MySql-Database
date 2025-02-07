# Spring-Boot-Simple-CRUD-Operation-with-MySql-Database

## Overview
This is a simple CRUD (Create, Read, Update, Delete) application built using Spring Boot. The project uses Spring Data JPA for database interactions and supports both MySQL and H2 databases.

## Features
- Create, Read, Update, and Delete operations for an entity.
- Uses Spring Boot 3.4.2 with Java 17.
- Integrated with MySQL and H2 for database operations.
- Lombok for reducing boilerplate code.
- REST API endpoints for performing CRUD operations.

## Technologies Used
- Java 17
- Spring Boot 3.4.2
- Spring Data JPA
- Spring Web
- MySQL
- H2 Database (for testing)
- Lombok
- Maven

## Project Setup
### Prerequisites
- JDK 17 or later
- Maven
- MySQL (if using MySQL as the database)

### Clone the Repository
```sh
git clone https://github.com/your-repo/spring_boot_simple_crud_with_sql.git
cd spring_boot_simple_crud_with_sql
```

### Configure the Database
Modify `src/main/resources/application.properties` based on your database preference.
#### For MySQL
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/springboot_crud
spring.datasource.username=root
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
```
#### For H2 (In-Memory Database)
```properties
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
spring.h2.console.enabled=true
```

### Build and Run the Application
```sh
mvn clean install
mvn spring-boot:run
```

## API Endpoints
| Method | Endpoint | Description |
|--------|---------|-------------|
| GET | `/student/getStudent/{id}` | Get student by ID |
| POST | `/addition/{a}/{b}` | Add two numbers |
| POST | `/student/saveStudent` | Create a new student |
| POST | `/student/saveMultipleStudent` | Create multiple students |
| GET | `/student/getAllStudents` | Get all students |
| DELETE | `/student/deleteStudent/{id}` | Delete a student |
| PUT | `/student/updateStudent/{id}` | Update a student |

## Postman API Documentation
### GET Student by ID
```
GET localhost:8090/student/getStudent/1
```

### POST Addition
```
POST localhost:8090/addition/200/300
```

### POST Save Student
```
POST localhost:8090/student/saveStudent
```
**Body (JSON):**
```json
{
    "id": "123",
    "name": "Devil",
    "email": "devil@mohsin.com",
    "phone": "1234567890"
}
```

### POST Save Multiple Students
```
POST localhost:8090/student/saveMultipleStudent
```
**Body (JSON):**
```json
[
    { "name": "Devil", "email": "devil@mohsin.com", "phone": "1234567890" },
    { "name": "Evil", "email": "evil@mohsin.com", "phone": "0987654321" },
    { "name": "Lucifer", "email": "lucifer@mohsin.com", "phone": "1122334455" }
]
```

### DELETE Student
```
GET localhost:8090/student/deleteStudent/124
```

### GET All Students
```
GET localhost:8090/student/getAllStudents
```

### PUT Update Student
```
PUT localhost:8090/student/updateStudent/1
```
**Body (JSON):**
```json
{
    "name": "Md Mohsin Haider",
    "email": "mohsinhaider@mohsin.com",
    "phone": 8084527631
}
```

## Dependencies
This project uses the following dependencies:
```xml
<dependencies>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-data-jpa</artifactId>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>
    <dependency>
        <groupId>com.h2database</groupId>
        <artifactId>h2</artifactId>
        <scope>runtime</scope>
    </dependency>
    <dependency>
        <groupId>com.mysql</groupId>
        <artifactId>mysql-connector-j</artifactId>
        <scope>runtime</scope>
    </dependency>
    <dependency>
        <groupId>org.projectlombok</groupId>
        <artifactId>lombok</artifactId>
        <optional>true</optional>
    </dependency>
</dependencies>
```

## Contributing
Feel free to fork this repository and submit pull requests for improvements.

## License
This project is licensed under the MIT License.

## Contact
For any queries, contact **Md Mohsin Haider** at [mdmohsinhaider6@gmail.com](mailto:mdmohsinhaider6@gmail.com)

Connect on **LinkedIn**: [Md Mohsin Haider](https://www.linkedin.com/in/md-mohsin-haider/)
