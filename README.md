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

## 4. Các microservice chi tiết

### 4.1. API Gateway (`api-gateway`)

Vai trò:
- Cổng vào của toàn bộ hệ thống.
- Định tuyến request đến các service tương ứng thông qua Eureka.
- Áp dụng filter (validate JWT, thêm header, logging, CORS, …).

Ví dụ route (mô tả):
- `/auth/**` → `auth-service`
- `/users/**` → `user-service`
- `/products/**` → `product-service`
- `/learning/**` → `learning-service`
- `/payments/**` → `payment-service`
- `/notifications/**` → `notification-service`
- `/uploads/**` → `upload-service`

### 4.2. Eureka Server (`eureka-server`)

- Là service registry, nơi các microservice khác **register** & **discover**.
- Giúp gateway tự động tìm địa chỉ service mà không cần hard-code host/port.

Truy cập UI (ví dụ):
- `http://localhost:8761` – danh sách service đã đăng ký.

### 4.3. Auth Service (`auth-service`)

Chức năng:
- Đăng ký tài khoản (sign up)
- Đăng nhập (username/password)
- Đăng nhập Google OAuth2 (nhận code từ FE, gọi Google, tạo tài khoản nếu chưa tồn tại)
- Sinh & verify **JWT access token** + **refresh token**
- Quản lý loại đăng nhập (`login_type`), vai trò (`role`)

Các endpoint tiêu biểu (ví dụ):
- `POST /auth/register`
- `POST /auth/login`
- `POST /auth/refresh-token`
- `GET  /auth/me`
- `GET  /auth/oauth2/callback/google?code=...&state=...`

Dữ liệu:
- Bảng `users` trong MySQL (`study5_auth` hoặc tương tự):
    - `id`, `email`, `password`, `full_name`, `role`, `login_type`, …
- Ràng buộc CHECK cho trường `role`, `login_type` (0–2).

Có thể có Kafka producer để gửi event `UserInfoCreateEvent` cho `user-service` sau khi đăng ký thành công.

### 4.4. User Service (`user-service`)

Chức năng:
- Quản lý hồ sơ người dùng:
    - thông tin cá nhân
    - avatar
    - số điện thoại, địa chỉ, …
- Đồng bộ dữ liệu user từ `auth-service` qua Kafka event.

Ví dụ endpoint:
- `GET  /users/{id}`
- `PUT  /users/{id}`
- `GET  /users/me` (lấy theo token)
- `GET  /users` (admin, phân trang)

### 4.5. Product Service (`product-service`)

Chức năng:
- Quản lý:
    - `Subject` (môn học / lĩnh vực)
    - `Course` (khoá học)
    - `Lesson` (bài học thuộc khoá)
- Lưu các thông tin:
    - `courseName`, `courseDescription`
    - `initialPrice`, `finalPrice`
    - `thumbnailId`, `thumbnailUrl`
    - `teacherDescription`, `introductionVideo`
    - `assignment`, `registeredStudent`, `expireTime`, `studyTime`
    - Subject liên kết qua `subject_id`
    - Danh sách `Lesson` (OneToMany)
    - (Optional) danh sách `users` đã mua khoá học

Ví dụ endpoint:
- `GET  /products/courses`
- `GET  /products/courses/{id}`
- `GET  /products/courses/search?keyword=...&subjectId=...`
- `POST /products/courses` (admin)
- `PUT  /products/courses/{id}`
- `DELETE /products/courses/{id}`

### 4.6. Learning Service (`learning-service`)

Chức năng:
- Quản lý:
    - `Exam` – đề thi / bài kiểm tra
    - `Question`, `Answer`
    - `ExamAttempt` – lượt làm bài của user
    - `ExamResult` – kết quả chấm
- Logic:
    - Tạo đề thi
    - User bắt đầu làm bài (tạo `ExamAttempt`)
    - Nộp bài → chấm điểm → lưu `ExamResult`
    - Tính điểm, số câu đúng, thời gian làm bài, …

Ví dụ endpoint:
- `POST /learning/exams` – tạo đề
- `GET  /learning/exams/{id}`
- `POST /learning/exams/{id}/start` – tạo attempt
- `POST /learning/exams/{id}/submit` – nộp bài, chấm điểm
- `GET  /learning/exam-results/{attemptId}`

### 4.7. Payment Service (`payment-service`)

Chức năng:
- Tích hợp **VNPay Sandbox**
- Tạo URL thanh toán
- Xử lý callback / return URL từ VNPay
- Lưu đơn hàng và trạng thái thanh toán
- Sau khi thanh toán thành công:
    - gửi event cho `product-service`/`user-service` để cộng khoá học vào tài khoản user
    - gửi notification qua `notification-service`

Luồng cơ bản:
1. FE gọi `POST /payments/vnpay/create-payment` với thông tin đơn hàng
2. Backend dựng URL:
    - `vnp_Amount`, `vnp_TxnRef`, `vnp_IpAddr`, `vnp_OrderInfo`, `vnp_ReturnUrl`, …
    - Ký **HMAC-SHA512** với `vnp_HashSecret` → `vnp_SecureHash`
3. FE redirect user tới trang thanh toán VNPay
4. VNPay redirect về `vnp_ReturnUrl` (Payment service/Gateway)
5. Payment service verify chữ ký, cập nhật trạng thái đơn hàng.

Các endpoint tiêu biểu:
- `POST /payments/vnpay/create-order`
- `GET  /payments/vnpay_return` – VNPay callback / redirect
- `GET  /payments/orders/{id}`
- `GET  /payments/users/{userId}/orders`

Cấu hình quan trọng (qua `application.yml` hoặc env):
- `vnpay.tmnCode`
- `vnpay.hashSecret`
- `vnpay.payUrl`
- `vnpay.returnUrl`
- `vnpay.version`, `vnpay.command`, …


# **B. PayOS Integration — (NEW)**

PayOS hỗ trợ:
- Tạo link thanh toán
- Redirect sau khi user thanh toán
- Gửi **webhook** để backend kiểm tra giao dịch real-time
- Verify chữ ký bằng **HMAC-SHA256**

### 🔧 Cấu hình PayOS (`application.yml`)
```yaml
payos:
  clientId: YOUR_CLIENT_ID
  apiKey: YOUR_API_KEY
  checksumKey: YOUR_CHECKSUM_KEY
  returnUrl: http://localhost:8080/payments/payos/return
  cancelUrl: http://localhost:8080/payments/payos/cancel
  ```
### 4.8. Notification Service (`notification-service`)

Chức năng:
- Lưu & gửi thông báo cho người dùng:
    - Khi đăng ký thành công
    - Khi thanh toán thành công
    - Khi khoá học mới được mở
- Lưu trong **MongoDB**:
    - `userId`, `title`, `content`, `type`, `isRead`, `createdAt`

Ví dụ endpoint:
- `GET  /notifications/me`
- `POST /notifications` (nhận event từ các service khác / admin tạo thông báo)
- `PUT  /notifications/{id}/read`

### 4.9. Upload Service (`upload-service`)

Chức năng:
- Upload file:
    - Ảnh thumbnail khoá học
    - Avatar người dùng
    - Video giới thiệu
- Lưu file và thông tin vào DB (MySQL) + lưu trên disk hoặc dịch vụ lưu trữ (local/Cloud).

Ví dụ endpoint:
- `POST /uploads/images`
- `GET  /uploads/images/{id}`
- `DELETE /uploads/images/{id}`

Log service thường ở port `8085` (theo log `upload-service [nio-8085-exec-1]`).

---

## 5. Cách chạy dự án

### 5.1. Yêu cầu

- **Java 17+**
- **Maven 3.8+**
- **Docker & Docker Compose**
- (Optional) Node.js + frontend app để gọi API

### 5.2. Clone source

```bash
git clone https://github.com/MCK564/Study5-API.git
cd Study5-API