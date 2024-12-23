
# Hospital Management System - Backend

This document provides an overview of the backend system for the **Hospital Management System**. The backend is built using **Java** with **Spring Boot**, and it includes features for managing visitors, complaints, and bills. The backend uses in-memory storage (Java collections) for simplicity and can be expanded to support persistent storage with a database.

---

## **Features**

### **Visitor Management**
- Register a visitor with their personal details, illness, and auto-assignment of doctors.
- View all visitors.
- Update visitor information.
- Delete visitors.

### **Complaint Management**
- Visitors can generate complaints that are marked as "Pending" by default.
- Admin can view, resolve, or delete complaints.

### **Bill Management**
- Generate a bill for a visitor based on room charges, pharmacy charges, and diagnostic charges.
- Calculate the total bill amount.
- View all generated bills.

### **Admin Authentication**
- Simple admin login functionality with hardcoded credentials (can be extended to use database or JWT for authentication).

---

## **Project Structure**

```
HospitalManagementSystemBackend/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── com/
│   │   │   │   ├── hospital/
│   │   │   │   │   ├── controller/
│   │   │   │   │   │   ├── VisitorController.java
│   │   │   │   │   │   ├── AdminController.java
│   │   │   │   │   │   ├── ComplaintController.java
│   │   │   │   │   │   ├── BillController.java
│   │   │   │   │   ├── model/
│   │   │   │   │   │   ├── Visitor.java
│   │   │   │   │   │   ├── Admin.java
│   │   │   │   │   │   ├── Complaint.java
│   │   │   │   │   │   ├── Bill.java
│   │   │   │   │   ├── service/
│   │   │   │   │   │   ├── VisitorService.java
│   │   │   │   │   │   ├── ComplaintService.java
│   │   │   │   │   │   ├── BillService.java
│   │   │   │   │   ├── HospitalManagementSystemApplication.java
```

---

## **Endpoints**

### **Visitor Management**

1. **Register Visitor**
   - **Method:** `POST`
   - **URL:** `/visitors`
   - **Body:**
     ```json
     {
         "fullname": "John Doe",
         "email": "john.doe@example.com",
         "password": "password123",
         "illness": "Fever"
     }
     ```
   - **Response:**
     ```json
     {
         "id": 1,
         "fullname": "John Doe",
         "email": "john.doe@example.com",
         "illness": "Fever",
         "doctorAssigned": "Dr. Smith"
     }
     ```

2. **Get All Visitors**
   - **Method:** `GET`
   - **URL:** `/visitors`

3. **Update Visitor**
   - **Method:** `PUT`
   - **URL:** `/visitors/{id}`
   - **Body:**
     ```json
     {
         "fullname": "John Smith",
         "email": "john.smith@example.com",
         "illness": "Cough"
     }
     ```

4. **Delete Visitor**
   - **Method:** `DELETE`
   - **URL:** `/visitors/{id}`

---

### **Complaint Management**

1. **Generate Complaint**
   - **Method:** `POST`
   - **URL:** `/complaints`
   - **Body:**
     ```json
     {
         "visitorId": 1,
         "description": "The room was not clean."
     }
     ```
   - **Response:**
     ```json
     {
         "id": 1,
         "visitorId": 1,
         "description": "The room was not clean.",
         "status": "Pending"
     }
     ```

2. **Get All Complaints**
   - **Method:** `GET`
   - **URL:** `/complaints`

3. **Resolve Complaint**
   - **Method:** `PUT`
   - **URL:** `/complaints/{id}/resolve`
   - **Response:**
     ```json
     {
         "message": "Complaint resolved successfully."
     }
     ```

4. **Delete Complaint**
   - **Method:** `DELETE`
   - **URL:** `/complaints/{id}`
   - **Response:**
     ```json
     {
         "message": "Complaint deleted successfully."
     }
     ```

---

### **Bill Management**

1. **Generate Bill**
   - **Method:** `POST`
   - **URL:** `/bills`
   - **Params:**
     - `visitorId`: 1
     - `roomCharges`: 2000
     - `pharmacyCharges`: 500
     - `diagnosticCharges`: 1000
   - **Response:**
     ```json
     {
         "id": 1,
         "visitorId": 1,
         "roomCharges": 2000.0,
         "pharmacyCharges": 500.0,
         "diagnosticCharges": 1000.0,
         "totalAmount": 3500.0
     }
     ```

2. **Get All Bills**
   - **Method:** `GET`
   - **URL:** `/bills`

---

### **Admin Authentication**

1. **Admin Login**
   - **Method:** `POST`
   - **URL:** `/admin/login`
   - **Body:**
     ```json
     {
         "username": "admin",
         "password": "admin123"
     }
     ```
   - **Response:**
     ```json
     {
         "message": "Login successful! Welcome, Admin."
     }
     ```

---

## **How to Run the Backend**

1. Clone the repository.
2. Open the project in your preferred IDE (e.g., Eclipse, IntelliJ IDEA).
3. Make sure you have Java and Maven installed.
4. Run the application using:
   ```bash
   mvn spring-boot:run
   ```
5. The backend server will start at `http://localhost:8080`.

---

## **Testing with Postman**

1. **Install Postman**: Download and install [Postman](https://www.postman.com/).
2. **Create Requests**: Use the endpoints listed above to create and test requests.
3. **Verify Responses**: Check the status codes and response bodies to ensure everything works as expected.

---

## **Future Enhancements**

1. **Database Integration**: Replace in-memory storage with a relational database like MySQL or PostgreSQL.
2. **Authentication**: Implement JWT or OAuth for secure admin and visitor authentication.
3. **Pagination**: Add pagination for large datasets (e.g., visitors, complaints, bills).
4. **Logging**: Add logging for better debugging and monitoring.
5. **Unit Tests**: Write unit and integration tests to ensure code quality.

---

This backend system provides the foundation for managing a hospital's operations and can be extended further based on requirements.

