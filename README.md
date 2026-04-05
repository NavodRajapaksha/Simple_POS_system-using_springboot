# Point of Sale (POS) System

A RESTful backend API for a Point of Sale system built with Spring Boot, designed to manage customers, items, and orders efficiently.

## 🛠️ Built With

- Java 21
- Spring Boot 3.5.12
- Spring Data JPA
- MySQL
- Lombok
- MapStruct
- ModelMapper
- Springdoc OpenAPI (Swagger UI)

## ✨ Features

- Customer management (CRUD operations)
- Item management with pagination
- Order and order details management
- Standard response wrapper
- Global exception handling
- API documentation with Swagger UI

## 📋 Prerequisites

- Java 21
- Maven
- MySQL

## ⚙️ Setup & Installation

1. Clone the repository
```bash
   git clone https://github.com/NavodRajapaksha/your-repo-name.git
```

2. Create a MySQL database
```sql
   CREATE DATABASE pos_system;
```

3. Update `application.yaml` with your database credentials
```yaml
   spring:
     datasource:
       username: your_username
       password: your_password
```

4. Run the project
```bash
   mvn spring-boot:run
```

## 📡 API Endpoints

| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | `/api/v1/customer/save` | Save a customer |
| PUT | `/api/v1/customer/update` | Update a customer |
| GET | `/api/v1/customer/get-all-customers` | Get all customers |
| DELETE | `/api/v1/customer/delete-customer/{id}` | Delete a customer |
| POST | `/api/v1/item/save` | Save an item |
| GET | `/api/v1/item/get-by-name` | Get item by name |
| POST | `/api/v1/order/save` | Save an order |
| GET | `/api/v1/order/get-order-details` | Get order details |

## 📖 API Documentation

Swagger UI: `http://localhost:8080/swagger-ui.html`

## 📬 Contact

- LinkedIn: [Navod Rajapaksha](https://www.linkedin.com/in/navod-rajapaksha/)
- GitHub: [NavodRajapaksha](https://github.com/NavodRajapaksha)
