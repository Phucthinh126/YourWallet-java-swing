## APP YOUR WALLET

## Giới thiệu

- Ứng dụng **YourWallet** được xây dựng dựa trên **java swing**
- Cho phép theo dõi chi tiêu cá nhân, cập nhật những khoảng chi tiêu và theo dõi số tiền đã chi cho từng việc

## Chức năng chính

- Các chức năng:

* Hiển thị số dư hiện tại.
* Thêm giao dịch mới.
  - Số tiền đã chi.
  - Nội dung của giao dịch.
  - Ngày thực hiện.
* Nạp tiền vào tài khoản
* Xem tổng đã chi tiêu
* Bảng hiển thị tất cả các chi tiêu:
  |stt|số tiền|nội dung|ngày|

## Cấu trúc của project

**Dựa theo mô hình MVC**

**_🖥️App_** -- Mô phỏng hệ thống - `App`:
**_📂Controller_** -- Xử lý logic - `ExpenceController`: xử lý logic về button - `LoginController`: xử lý logic đăng nhập
**_📁model_** -- Chứa Thông tin - `User`: thông tin đăng nhập của người dùng
**_🗂️View_** -- Giao diện người dùng - `LoginFrame`: Giao diện đăng nhập - `MainFrame`: giao diện chính của ứng dụng

## Hướng dẫn chạy

1. Mở project trong VS code.
2. Mở App và chạy.
3. Đăng nhập:
   tên đăng nhập admin
   mật khẩu admin126
4. Nạp tiền vào tài khoản --> nhấn button 'cập nhật'
5. Thực hiện thêm giao dịch --> nhấn button 'thêm giao dịch'
6. Nhấn button 'Xem tổng đã chi tiêu' để xem số tiền còn lại 