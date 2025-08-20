# Login-TODO-App
Java Web App using JSP, Servlet, and JDBC with Login authentication and TODO list feature.
Features user **Login** (and soon Registration) plus a TODO dashboard (planned).

## Tech Stack
- Java 8+/11+ (recommended 17)
- JSP, Servlet (Jakarta)
- JDBC + MySQL
- Tomcat 9/10/10.1
- (Optional) Maven

## Current Features (v1)
- Login form (JSP)
- Credential validation via DB (Servlet + JDBC)
- Success → `welcome.jsp`, Failure → `error.jsp`

## Planned (Roadmap)
- Registration page & password hashing
- Session-based dashboard
- TODO CRUD (add/update/delete/mark done)
- Logout + Auth filter
- DAO layer (clean MVC), Bootstrap UI

## Database
Example `users` table:
```sql
CREATE TABLE users (
  id INT AUTO_INCREMENT PRIMARY KEY,
  username VARCHAR(100) UNIQUE NOT NULL,
  password VARCHAR(255) NOT NULL,
  email VARCHAR(150)
);
