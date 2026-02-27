# 🔗 URL Shortener Web Application  
A simple, fast, and functional **URL Shortener** built using **Java, JSP, Servlets, JDBC, MySQL, and Apache Tomcat**.  
This project converts long URLs into short codes and provides redirect functionality similar to Bitly.



## 🚀 Features
- Convert **long URLs → short URLs** using a unique hash generator  
- Redirect from short URL to the original URL  
- Store URL mappings in **MySQL database**  
- Servlet + JSP based **MVC architecture**  
- Analytics page to list all shortened URLs  
- Deployed locally using **Apache Tomcat 9**  
- Clean DAO layer using JDBC

---

## 🛠️ Tech Stack
- **Java 17**  
- **JSP & Servlets**  
- **JDBC (MySQL Connector)**  
- **MySQL Database**  
- **Apache Tomcat 9**  
- **Eclipse IDE**

---

## 📂 Project Structure

URLShortener/
│
├── src/main/java/com/shortener/
│ ├── DBConnection.java
│ ├── HashGenerator.java
│ ├── UrlDao.java
│ ├── UrlData.java
│ ├── UrlShortenServlet.java
│ └── UrlRedirectServlet.java
│
├── WebContent/
│ ├── index.jsp
│ ├── analytics.jsp
│ └── WEB-INF/
│ └── web.xml
│
└── README.md

---

## 🧩 How It Works

### 1️⃣ User enters a long URL  
Input is taken in `index.jsp`.

### 2️⃣ Servlet generates a short code  
`UrlShortenServlet` → uses `HashGenerator` to create a unique 6-char code.

### 3️⃣ Mapping stored in MySQL  
`UrlDao` saves:  
`long_url`, `short_code`, and timestamp.

### 4️⃣ User gets a short link  
Example:  
http://localhost:8080/URLShortener/r/abcd12


### 5️⃣ Redirect  
`UrlRedirectServlet` receives the code → fetches long URL → redirects the user.

---

## 🗄️ Database Setup

Create database:

```sql
CREATE DATABASE url_shortener;
USE url_shortener;

CREATE TABLE urls (
    id INT PRIMARY KEY AUTO_INCREMENT,
    long_url TEXT NOT NULL,
    short_code VARCHAR(20) NOT NULL UNIQUE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
Running the Project

Import project into Eclipse

Add Tomcat 9 server

Add MySQL Connector JAR to WEB-INF/lib

Start Tomcat

Open browser:

http://localhost:8080/URLShortener/index.jsp

📈 Future Enhancements

User login & dashboard

URL click analytics

Expiry date for URLs

API version (REST)

Frontend redesign using Bootstrap
Author

Sanjyot Dawkar
Java Developer | Backend Enthusiast
GitHub: https://github.com/sanjyotdawkar
