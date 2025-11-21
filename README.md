# 🧑‍💼 Employee Management System (EMS) 🚀

A **Spring Boot** and **JPA** based Employee Management System for managing employees in an organization. This project provides RESTful APIs to **create**, **read**, **update**, and **delete** employee records with validation and filtering options.

---

## ✨ Features

### Employee Operations
- 🆕 Create a new employee with validation checks (email uniqueness, phone uniqueness, field constraints)
- 📋 Get all employees
- 🔎 Get employee by ID
- ✏️ Update employee details
- 🗑️ Delete employee
- 🏢 Filter employees by department
- 💼 Filter employees by position

### Validation
- `firstName` and `lastName`: Only letters and spaces, 2–50 characters
- `email`: Valid email format, unique
- `gender`: Only Male, Female, or Other
- `phoneNumber`: 10–15 characters, unique
- `department` and `position`: Required
- `salary`: Must be greater than 0
- `address`: Maximum 255 characters

### Tech Stack
- ⚙️ **Backend:** Spring Boot
- 🗄️ **Database:** MySQL / H2 (can be configured)
- 📝 **Persistence:** JPA / Hibernate
- ✅ **Validation:** Jakarta Bean Validation
- 🌐 **REST API:** Spring Web

---

## 📁 Project Structure

```
com.ems
├── controller
│   └── EmployeeController.java       # REST APIs for employee management
├── model
│   └── Employee.java                 # Employee entity with validations
├── repository
│   └── EmployeeRepository.java       # JPA Repository for Employee
└── service
    └── EmployeeService.java          # Service layer with business logic
```

---

## 🌐 Endpoints

### Base URL: `/ems/employees`

| HTTP Method | Endpoint                     | Description                                      |
|------------|-------------------------------|-------------------------------------------------|
| POST       | `/`                           | Create a new employee                           |
| GET        | `/`                           | Get all employees                               |
| GET        | `/{id}`                       | Get employee by ID                              |
| PUT        | `/{id}`                       | Update employee by ID                           |
| DELETE     | `/{id}`                       | Delete employee by ID                           |
| GET        | `/department/{department}`    | Get employees by department                     |
| GET        | `/position/{position}`        | Get employees by position                       |

---

## 🛡️ Validation Rules

- **First Name / Last Name:** 2–50 characters, letters and spaces only
- **Email:** Valid format, unique
- **Gender:** Male, Female, or Other
- **Phone Number:** 10–15 characters, unique
- **Department & Position:** Cannot be blank
- **Salary:** Greater than 0
- **Address:** Max 255 characters

---

## 🚀 How to Run

1. **Clone the repository**
```bash
git clone <repository-url>
cd employee-management-system
```

2. **Configure Database**
- Update `application.properties` with your MySQL or H2 configuration.

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/ems_db
spring.datasource.username=root
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

3. **Build & Run**
```bash
./mvnw spring-boot:run
```

4. **Access API**
- Base URL: `http://localhost:8080/ems/employees`
- Use Postman or any API client to interact with endpoints.

---

## 📦 Example JSON Payload

```json
{
  "firstName": "John",
  "lastName": "Doe",
  "email": "john.doe@example.com",
  "gender": "Male",
  "phoneNumber": "9876543210",
  "department": "IT",
  "position": "Developer",
  "salary": 50000,
  "address": "123, Main Street"
}
```

---

## ⚠️ Error Handling

- Duplicate email or phone: Returns **400 BAD REQUEST**
- Employee not found: Returns **404 NOT FOUND**
- Invalid input validation: Returns **400 BAD REQUEST** with detailed message

---

## 👤 Author

**Jasphin Vijay J**  
📧 Email: jasphinvijayj@gmail.com
