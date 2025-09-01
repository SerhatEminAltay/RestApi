# ☕ Spring Boot CRUD Projesi (TR)

Bu proje, **Java Spring Boot** ile geliştirilmiş basit bir **REST API** uygulamasıdır.  
Çalışanlar (Employee) üzerinde CRUD (Create, Read, Update, Delete) işlemleri yapılabilir.  
Postman veya benzeri araçlarla kolayca test edilebilir.

## 📁 Proje Yapısı
- **controller/** → REST endpoint’leri  
- **service/** → İş mantığını barındıran servis katmanı  
- **repository/** → Veritabanı işlemleri için Spring Data JPA  
- **entity/** → Veritabanı tablolarını temsil eden sınıflar  
- **dto/** → Veri transfer nesneleri  
- **exception/** → Özel hata sınıfları  

## 🔧 Çalıştırma
# Projeyi çalıştırmak için:
mvn spring-boot:run

Uygulama varsayılan olarak **http://localhost:8080** adresinde çalışır.

## 📌 Örnek Endpoint’ler
- `GET /employees` → Tüm çalışanları getir  
- `POST /employees` → Yeni çalışan ekle  
- `GET /employees/{id}` → ID’ye göre çalışan getir  
- `PUT /employees/{id}` → Çalışan güncelle  
- `DELETE /employees/{id}` → Çalışan sil  

---

# ☕ Spring Boot CRUD Project (EN)

This project is a simple **REST API** built with **Java Spring Boot**.  
It allows CRUD (Create, Read, Update, Delete) operations on employees.  
It can be tested using Postman or similar tools.

## 📁 Project Structure
- **controller/** → REST endpoints handling HTTP requests  
- **service/** → Business logic layer  
- **repository/** → Database operations with Spring Data JPA  
- **entity/** → Classes representing database tables  
- **dto/** → Data Transfer Objects  
- **exception/** → Custom exception classes  

## 🔧 How to Run
# Run the project
mvn spring-boot:run

The application runs on **http://localhost:8080** by default.

## 📌 Example Endpoints
- `GET /employees` → Get all employees  
- `POST /employees` → Add a new employee  
- `GET /employees/{id}` → Get employee by ID  
- `PUT /employees/{id}` → Update employee  
- `DELETE /employees/{id}` → Delete employee  
