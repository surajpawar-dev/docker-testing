# Namaste - Spring Boot REST API with Docker

## Project Overview

Namaste is a simple RESTful API built with Spring Boot that allows users to create, read, update, and delete messages. The application is containerized using Docker and includes a MySQL database for data persistence.
Don't Confuse Namaste -> it just a project name for practice
## Technology Stack

- **Backend**: Spring Boot 3.3.2 with Java 17
- **Database**: MySQL 8.0
- **Build Tool**: Maven
- **Containerization**: Docker & Docker Compose
- **API Documentation**: REST Endpoints

## Features

- CRUD operations for "Namaste" messages
- Dockerized application with multi-stage build
- Database persistence with MySQL
- Automatic timestamps for entity creation and updates
- Environment-based configuration

## Project Structure

```
Namaste
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com.suraj.namaste
│   │   │       ├── controller
│   │   │       ├── entity
│   │   │       ├── repository
│   │   │       ├── service
│   │   │       └── NamasteApplication.java
│   │   └── resources
│   │       └── application.properties
│   └── test
├── docker-compose.yml
├── Dockerfile
├── .env
├── pom.xml
└── README.md
```


## API Endpoints

| Method | Endpoint             | Description                  |
|--------|----------------------|------------------------------|
| GET    | /api/v1/namaste      | Get all messages             |
| GET    | /api/v1/namaste/{id} | Get a message by ID          |
| POST   | /api/v1/namaste      | Create a new message         |
| PUT    | /api/v1/namaste/{id} | Update an existing message   |
| DELETE | /api/v1/namaste/{id} | Delete a message             |

### Sample Request Body (POST/PUT):

```json
{
  "message": "Hello, World!",
  "author": "Your Name"
}
```


## Getting Started

### Prerequisites

- Docker & Docker Compose
- JDK 17 (for local development)
- Maven (for local development)

### Running the Application with Docker

1. Clone the repository:
```
git clone <repository-url>
   cd Namaste
```


2. Start the application using Docker Compose:
```
docker-compose up -d
```


3. The API will be available at `http://localhost:8080/api/v1/namaste`

### Environment Variables

The following environment variables can be configured in the `.env` file:

**MySQL Configuration:**
- `MYSQL_DATABASE`: Database name
- `MYSQL_USER`: Database user
- `MYSQL_PASSWORD`: Database password
- `MYSQL_ROOT_PASSWORD`: Root password for MySQL

**Spring Application Configuration:**
- `SPRING_DATASOURCE_URL`: JDBC connection URL
- `SPRING_DATASOURCE_USERNAME`: Database username for application
- `SPRING_DATASOURCE_PASSWORD`: Database password for application

## Development

### Building the Application Locally

```
mvn clean package
```


### Running Tests

```
mvn test
```


### Local Development Setup

1. Configure your MySQL database
2. Update application.properties with your database configuration
3. Run the application:
```
mvn spring-boot:run
```


## Docker Configuration

The application uses a multi-stage Docker build:
- First stage: Build the application with Maven
- Second stage: Create a minimal runtime image with the JAR

Docker Compose sets up:
- A Java application container
- A MySQL database container
- A custom bridge network
- Volume for database persistence
- Health checks to ensure proper startup order

## Contributing

1. Fork the repository
2. Create a feature branch
3. Make your changes
4. Submit a pull request

## License

[Your License Information]

---

*Created by Suraj*