# 🧑‍💼 Employee Management System (Spring Boot + Thymeleaf + MySQL)

This project is a full-stack **Employee Management System** built using **Spring Boot** for backend and **Thymeleaf + Bootstrap** for frontend. It allows efficient employee CRUD operations, integrated search, caching for performance, and proper validation and exception handling.

---

## 🔧 Tech Stack

- **Backend**: Spring Boot, Spring MVC, Spring Data JPA, MySQL, Ehcache
- **Frontend**: Thymeleaf, Bootstrap 5 (via CDN)
- **Others**: Bean Validation, Global Exception Handling

---

## 📌 Features

### ✅ Backend (Spring Boot)

1. **Add Employee**
   - `POST /employees`
   - Adds new employee with validation

2. **Get All Employees**
   - `GET /employees`
   - Fetches and displays all employees using Thymeleaf

3. **Update Employee**
   - `GET /employees/edit/{id}` – Load form with current data  
   - `POST /employees/{id}` – Update with submitted form data

4. **Delete Employee**
   - `GET /employees/delete/{id}`
   - Removes an employee by ID

5. **Search Employees**
   - `GET /employees/search?keyword=`
   - Search by **name**, **email**, or **department**

6. **Ehcache Integration**
   - Caches employee list for faster repeated access

7. **Validation**
   - Form-level validations using `@Valid` and custom messages

8. **Exception Handling**
   - Global exception handler for common errors (`@ControllerAdvice`)

---

### ✅ Frontend (Thymeleaf + Bootstrap)

1. **Responsive UI**
   - Styled using Bootstrap 5 with mobile-first responsive design

2. **Employee Table**
   - Displays employee data (name, email, department, etc.)
   - Actions: **Edit**, **Delete**, **Details**

3. **Search Box**
   - Dynamically filters employee list using search input

4. **Add/Edit Form**
   - Clean, validated employee form for create and update

5. **Details View**
   - View complete employee profile in a styled card/modal

---

## ▶️ How to Run

### 🔹 Backend (Spring Boot)

1. Clone the repository:
   ```bash
   git clone https://github.com/vishnu-vardhan-chary/Projects.git
   cd employee-management
