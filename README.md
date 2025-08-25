# Login-TODO-App
Java Web App using JSP, Servlet, and JDBC with Login authentication and TODO list feature.
Features user **Login** (and soon Registration) plus a TODO dashboard (planned).

## Tech Stack
- Java 8+/11+ (recommended 17)
- JSP, Servlet (Jakarta)
- JDBC + MySQL
- Tomcat 9/10/10.1
- (Optional) Maven(This is dynamic web project)

## 🚀 Features
- User Registration with unique username and password  
- Secure Login using session management  
- Personalized To-Do page after login  
- Logout functionality with session invalidation  
- Database connectivity using JDBC  

---

## 🛠️ Tech Stack
- **Backend**: Java Servlets, JSP  
- **Frontend**: JSP + HTML + CSS (basic styling)  
- **Database**: MySQL  
- **Server**: Apache Tomcat 10.1  

---

## 🗄️ Database Schema

CREATE TABLE users (
  id INT AUTO_INCREMENT PRIMARY KEY,
  username VARCHAR(100) UNIQUE NOT NULL,
  password VARCHAR(255) NOT NULL,
  email VARCHAR(150)
);

2. Todos Table
CREATE TABLE todos (
  id INT AUTO_INCREMENT PRIMARY KEY,
  username VARCHAR(50) NOT NULL,
  task VARCHAR(255) NOT NULL,
  FOREIGN KEY (username) REFERENCES users(username)
);

📂 Project Structure
LoginProj/
│── src/
│   ├── RegisterServlet.java
│   ├── LoginServlet.java
│   ├── TodoServlet.java
│   ├── LogoutServlet.java
│   └── DBConnection.java
│
│── WebContent/
│   ├── registration.jsp
│   ├── login.jsp
│   ├── todos.jsp
│   ├── logout.jsp
│   └── WEB-INF/web.xml

Author:ErRehanAnsari1
