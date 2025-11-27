# Study5-API
# A Microservice API provided for a 'Learning foreign languages' platform.

## 1. Giới thiệu
**Study5-API** là hệ thống backend xây dựng theo kiến trúc **Microservices** dùng cho một nền tảng:
- Bán khoá học / học liệu online
- Quản lý user, khoá học, bài học, bài thi, kết quả thi
- Tích hợp thanh toán VNPay, PayOS
- Hệ thống thông báo, upload media, quản lý hồ sơ người dùng

Toàn bộ hệ thống được viết bằng **Java + Spring Boot**, dùng **Spring Cloud** cho API Gateway & Service Discovery, đóng gói chạy bằng **Docker Compose**.

---

## 2. Kiến trúc tổng quan
Hệ thống được chia thành các service độc lập, giao tiếp qua kênh async (Kafka) và  HTTP (REST).

Các service chính:

- `api-gateway` – Cổng vào duy nhất cho frontend
- `eureka-server` – Service Discovery
- `auth-service` – Đăng ký / đăng nhập / JWT / Google OAuth2
- `user-service` – Hồ sơ người dùng, lịch học cá nhân
- `product-service` – Quản lý khoá học(course), bài học(lesson), blog
- `learning-service` – Thi / bài làm / kết quả
- `payment-service` – Thanh toán PayOS, VNPay
- `notification-service` – Thông báo (email / in-app), lưu vào MongoDB
- `upload-service` – Upload & quản lý file (ảnh, video, tài liệu) lưu trữ metadata trên **AWS S3**


Dịch vụ hạ tầng (được khai báo trong `docker-compose.yml`):
- `mysql` – database quan hệ cho phần lớn service (auth, user, product, learning, payment, upload, …)
- `mongodb` – database document cho thông báo (notification-service)
- `redis` – cache / lưu token / session
- `kafka` – message broker để truyền event giữa các service (đăng ký mới, thanh toán thành công, cập nhật dữ liệu sau khi upload, …)

> **Luồng cơ bản**:  
Frontend → `api-gateway` → định tuyến tới các service tương ứng (auth, product, learning, payment, …) thông qua `eureka-server`.

## 3. Công nghệ sử dụng

### Backend

- **Java 17+**
- **Spring Boot** (Web, Security, Data JPA, Validation, …)
- **Spring Cloud**:
    - Spring Cloud Gateway (`api-gateway`)
    - Netflix Eureka (`eureka-server`)
- **Spring Security + JWT**
- **OAuth2 Client** (Google Login)
- **Spring Data JPA** (MySQL)
- **Spring Data MongoDB** (MongoDB cho notification)
- **Kafka** (event-based communication – nếu được bật)

### Cơ sở dữ liệu

- **MySQL** – lưu user, khoá học, bài học, đơn hàng, thanh toán, kết quả thi
- **MongoDB** – lưu thông báo, message (notification-service)
- **Redis** (optional) – cache / token blacklist / rate limiting

### DevOps

- **Docker & Docker Compose**
- Log: Spring Boot Logging (SLF4J + Logback)


---

