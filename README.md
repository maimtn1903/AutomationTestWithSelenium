# Selenium Automation Test for Product Management System

## 📌 Giới thiệu
Dự án này được xây dựng nhằm tự động hóa kiểm thử (Automation Test) cho hệ thống bằng Selenium WebDriver.
Mục tiêu:
- Giảm thời gian kiểm thử thủ công
- Tăng độ chính xác và ổn định
- Dễ bảo trì và mở rộng test case

## 🛠 Công nghệ sử dụng
- Ngôn ngữ: Java
- Selenium WebDriver
- TestNG
- Maven
- Page Object Model (POM)
- IntelliJ IDEA
- ChromeDriver

## 📂 Cấu trúc thư mục
AutomationTestWithSelenium
├── src
│   ├── main
│   │
│   └── test
│       ├── java
│       │   └── com.testek
│       │       ├── finalExam
│       │       │   ├── locator        # Locator (XPath, CSS, ID…)
│       │       │   ├── objects        # Model / POJO
│       │       │   ├── pages          # Page Object (actions)
│       │       │   ├── testscript     # Test scripts
│       │       │
│       │       └── projects
│       │           ├── client.rest    # API / REST client
│       │           ├── common         # Common / Base classes
│       │           ├── dataprovider   # DataProvider (json, datapath)
│       │           ├── pages          # Page Object theo module
│       │           ├── testscript     # Test cases
│       │
│       └── resources
│           └── testdata               # Test data (json, csv…)
│
├── target                             # Report & build output
├── .gitignore
├── pom.xml                            # Maven configuration
└── README.md


## ⚙️ Cài đặt môi trường
- Java JDK 8+
- Maven
- Chrome Browser

## 🧪 Phạm vi kiểm thử
- Login
- Create / Update / Delete Customer
- Create Category
- Create Product
- Create Supplier
- Validate dữ liệu input
- Regression Test

## 👤 Tác giả
Mai Thị Ngọc Mai – Automation Tester
