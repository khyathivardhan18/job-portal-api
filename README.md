# Job Portal API

A RESTful API for managing jobs, job seekers, and job applications, built with Spring Boot and MySQL.

---

## Features

- **Job Management:** Post, update, delete, and search for jobs.
- **Job Seeker Management:** Register, update, and view job seekers.
- **Application Management:** Apply for jobs, update application status, and view applications.
- **Validation:** Ensures only valid data is accepted.
- **Error Handling:** Consistent, user-friendly error messages.
- **Authentication:** Basic Auth for protected endpoints.
- **Interactive API Docs:** Swagger UI for easy exploration and testing.

---

## Tech Stack

- Java 17
- Spring Boot 2.7.x
- Spring Data JPA
- Spring Security
- MySQL
- Swagger/OpenAPI

---

## Getting Started

### 1. **Clone the repository**

```bash
git clone https://github.com/khyathivardhan18/job-portal-api.git
cd job-portal-api
```

### 2. **Configure the Database**

Edit `src/main/resources/application.properties` if needed:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/jobportal_db?createDatabaseIfNotExist=true&useSSL=false&allowPublicKeyRetrieval=true
spring.datasource.username=root
spring.datasource.password=anilkumar123
spring.security.user.name=admin
spring.security.user.password={noop}admin
```

### 3. **Run the Application**

```bash
mvn spring-boot:run
```

The API will be available at `http://localhost:8080`.

---

## API Documentation

- **Swagger UI:** [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)
- **OpenAPI Spec:** [http://localhost:8080/v3/api-docs](http://localhost:8080/v3/api-docs)

---

## Authentication

- **Username:** `admin`
- **Password:** `admin`
- Use Basic Auth for protected endpoints (e.g., `/api/applications/**`).

---

## Example Endpoints

- `GET /api/jobs` — List/search jobs
- `POST /api/jobs` — Create a job
- `GET /api/jobseekers` — List job seekers
- `POST /api/jobseekers` — Register a job seeker
- `POST /api/applications` — Apply for a job

---

## Sample Data

You can insert sample data into your MySQL database using the provided SQL scripts in the `/sample-data` folder.

---

## License

[MIT](LICENSE) 
