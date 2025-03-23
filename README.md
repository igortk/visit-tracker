# Visit Tracker

## 📌 Description  
Visit Tracker is a system for managing doctor appointments. It allows users to create and track patient visits, ensuring that scheduling conflicts are avoided.

## 🛠 Tech Stack  
- **Backend:** Java, Spring Boot  
- **Database:** MySQL 8  

## 🚀 Features  
- 📅 Create a visit for a patient with a doctor  
- 🔄 Prevent double booking for the same doctor at the same time  
- 📋 Retrieve a list of patients with their latest visits  
- 🔍 Filter patients by name and doctors they have visited  

## 🏗 Installation & Running  

### 1️⃣ Clone the repository
```sh
git clone https://gitlab.com/igortk76/visit-tracker.git
cd visit-tracker

```
### 2️⃣ Build application
```sh
mvn clean install -DskipTests
```
### 3️⃣ Run the application
```sh
java -DPORT=${PORT} -DDB_PASSWORD=${DB_PASSWORD} -DDB_USERNAME=${DB_USERNAME} -DDB_JDBC_URL=${DB_JDBC_URL} -jar ./target/visit-tracker-0.0.1-SNAPSHOT.jar
```

## 📡 API Endpoints

### ➕ Create a visit
Request:
POST /visit/create
```sh
{
    "start": "2025-03-01T10:00:00",
    "end": "2025-03-01T10:30:00",
    "patientId": 1,
    "doctorId": 2
}
```
Response:
```sh
{
    "id": 1001,
    "start": "2025-03-01T10:00:00",
    "end": "2025-03-01T10:30:00",
    "patient": {
        "id": 1,
        "firstName": "John",
        "lastName": "Doe"
    },
    "doctor": {
        "id": 2,
        "firstName": "Alice",
        "lastName": "Smith",
        "timezone": "UTC"
    }
}
```

### 📋 Get patients with visits
Request:

GET /patients?page=1&size=10&search=John&doctorIds=1,2

Response:
```sh
{
    "data": [
        {
            "firstName": "John",
            "lastName": "Doe",
            "lastVisits": [
                {
                    "start": "2025-03-01T10:00:00",
                    "end": "2025-03-01T10:30:00",
                    "doctor": {
                        "firstName": "Alice",
                        "lastName": "Smith",
                        "totalPatients": 50
                    }
                }
            ]
        }
    ],
    "count": 1
}
```
