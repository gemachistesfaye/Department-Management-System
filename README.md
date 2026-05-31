# 🎓 Department Management System (Java OOP)

> **v2.0** — Refactored with professional OOP structure: abstract classes, proper encapsulation, Teacher class, input validation utility, and expanded address model.

![Java](https://img.shields.io/badge/Java-JDK%208%2B-orange?style=flat-square&logo=java)
![OOP](https://img.shields.io/badge/Paradigm-OOP-blue?style=flat-square)
![Status](https://img.shields.io/badge/Status-Active-brightgreen?style=flat-square)
![License](https://img.shields.io/badge/License-MIT-lightgrey?style=flat-square)

---

## 📌 Overview

The **Department Management System** is a console-based Java application built using Object-Oriented Programming (OOP) principles. It simulates an academic management system for handling students, teachers, courses, and grade evaluation in a structured and scalable way.

This project demonstrates real-world system modeling using clean architecture and core Java concepts.

---

## 📸 Screenshots

### 🏠 Main Menu
> _Run the program and you will see this menu:_

```
╔══════════════════════════════════════╗
║   Department Management System v2.0  ║
╚══════════════════════════════════════╝

┌─────────────────────────────────────┐
│           MAIN MENU                 │
├─────────────────────────────────────┤
│  1. Register & Display Course       │
│  2. Register Teacher                │
│  3. Register Student                │
│  4. Display Student Grade           │
│  5. List All Students               │
│  6. List All Teachers               │
│  7. Exit                            │
└─────────────────────────────────────┘
Enter your choice (1-7):
```

### 📊 Student Grade Report
> _After entering marks, the system displays a formatted report:_

```
============================================
          STUDENT FINAL REPORT
============================================
 Name    : Gemachis Tesfaye    ID : 1001
 Course  : Computer Science
--------------------------------------------
 Mid Exam   (max 30) : 27.0
 Project    (max 30) : 26.0
 Final Exam (max 40) : 35.0
--------------------------------------------
 Total Score : 88.00 / 100
 Grade       : A
 Status      : Excellent
 Result      : PASS
============================================
```

### 👥 List All Students
> _View all registered students in a formatted table:_

```
── Registered Students ──
ID     Name                 Age   Department           Course
───────────────────────────────────────────────────────────────────────────
1001   Gemachis Tesfaye     22    Information Science  Java Programming
1002   Bonsa Horsa          21    Computer Science     Data Structures
───────────────────────────────────────────────────────────────────────────
Total: 2 student(s)
```

---

## ✨ Features

### 👨‍🎓 Student Management
- Register students with full profile (ID, name, sex, age, department, address, course)
- Duplicate ID detection — prevents registering the same student twice
- Search student by ID for grade entry
- List all registered students in a formatted table

### 👨‍🏫 Teacher Management
- Register teacher with specialization and years of experience
- Store and list all teachers (was completely missing in v1.0)
- Duplicate ID detection for teachers

### 📚 Course Management
- Register and display course details with instructor name
- Input validation on all course fields

### 📊 Grade Evaluation System
Weighted grading model:

| Component  | Weight | Max Points |
|------------|--------|------------|
| Mid Exam   | 30%    | 30         |
| Project    | 30%    | 30         |
| Final Exam | 40%    | 40         |
| **Total**  | 100%   | **100**    |

Grade scale:

| Score  | Grade | Status       |
|--------|-------|--------------|
| 90–100 | A+    | Excellent    |
| 85–89  | A     | Excellent    |
| 80–84  | A-    | Very Good    |
| 75–79  | B+    | Very Good    |
| 70–74  | B     | Good         |
| 65–69  | B-    | Good         |
| 60–64  | C+    | Satisfactory |
| 50–59  | C     | Satisfactory |
| 45–49  | D     | Weak         |
| 0–44   | F     | Fail         |

### ⚙️ System Features
- Menu-driven console interface with box-drawn UI
- Centralized input validation via `InputHelper` (no duplicate code)
- Range-checked inputs (marks, age, experience)
- Marks-set guard — prevents grading a student before marks are entered
- Scanner properly closed on exit

---

## 🧠 Technologies & OOP Concepts Used

- **Java (Core)** — JDK 8+
- **Object-Oriented Programming (OOP)**
  - **Encapsulation** — all fields private, accessed via getters
  - **Inheritance** — `Student` and `Teacher` extend `Person`
  - **Abstraction** — `Person` is abstract; `displayInfo()` is abstract
  - **Interfaces** — `Displayable` interface implemented by `Person`
  - **Polymorphism** — `displayInfo()` overridden in each subclass
- **Aggregation** — `Person` has-an `Address` object
- **ArrayList** — runtime data storage for students and teachers
- **Scanner** — user input handling via `InputHelper` utility

---

## 🏗️ Project Structure (v2.0)

| File | Role | Description |
|------|------|-------------|
| `Displayable.java` | Interface | Defines `displayCourse()` and `displayInfo()` contracts |
| `Address.java` | Data class | Holds city, region, country with validation and `toString()` |
| `Person.java` | Abstract base | Private fields + getters; shared `displayPersonFields()` |
| `Student.java` | Subclass | Grade tracking, `marksSet` flag, split calc/display logic |
| `Teacher.java` | Subclass | Specialization and experience fields; was missing in v1.0 |
| `InputHelper.java` | Utility | Centralized, reusable validated input methods |
| `Main.java` | Entry point | Menu controller with extracted methods; replaced `Test.java` |

### Class Hierarchy

```
«interface»
Displayable
    │
    ▼
Person (abstract)  ◄───── Address (aggregation)
    │
    ├── Student
    └── Teacher

InputHelper (utility — static methods only)
Main (entry point)
```

---

## ▶️ How to Run the Project

### 📌 Prerequisites
- Java JDK 8 or higher
- Any IDE: IntelliJ IDEA / Eclipse / NetBeans / VS Code

### 🚀 Steps

1. **Clone the repository:**
   ```bash
   git clone https://github.com/gemachistesfaye/Department-Management-System.git
   cd Department-Management-System
   ```

2. **Open in your IDE** and ensure all `.java` files are in the same package (`project1`)

3. **Run `Main.java`** (not `Test.java` — that file no longer exists in v2.0)

4. **Follow the console menu** — enter numbers 1–7 to navigate

### 💡 Quick compile & run via terminal:
```bash
mkdir -p out
javac -d out *.java
java -cp out project1.Main
```

---

## 🔄 What Changed from v1.0 → v2.0

| Area | v1.0 (Original) | v2.0 (Refactored) |
|------|-----------------|-------------------|
| Interface | `Department.java` (misleading name) | `Displayable.java` (accurate) |
| `Person` fields | `protected` (accessible everywhere) | `private` with getters |
| `Person` class | Concrete with hollow `displayStudent()` | Abstract with `abstract displayInfo()` |
| `Address` | City only | City + Region + Country + `toString()` |
| `Student` grade | Accessed parent fields directly | Uses `getName()`, `getCourse()` getters |
| `Student` marks guard | None — zeroes printed silently | `marksSet` flag blocks uninitialized grading |
| `Teacher` class | Missing entirely | Fully implemented with specialization & experience |
| Input validation | Copy-pasted 8+ times in `Test.java` | Centralized in `InputHelper.java` |
| Main class | 293 lines all in `main()` | Extracted into private methods per feature |
| Teacher storage | Discarded after display | Stored in `ArrayList<Teacher>` |
| List all students | Not available | Menu option 5 |
| List all teachers | Not available | Menu option 6 |
| `Scanner` close | Missing | Properly closed on exit |

---

## 📌 Future Improvements

- 🗄️ **File persistence** — save students/teachers to `.txt` or `.csv` so data survives restarts
- 🗄️ **MySQL database** — replace ArrayList with JDBC + MySQL
- 🔐 **Authentication system** — Admin login with role-based access
- ✏️ **Edit & Delete** — update or remove registered students/teachers
- 📄 **Export reports** — generate PDF or Excel grade reports
- 🌐 **GUI** — JavaFX or Swing desktop interface
- 🌍 **Web app** — Spring Boot backend + React frontend

---

## 👥 Project Team

This project was developed as part of an Object-Oriented Programming course assignment at **Haramaya University**:

| Name | Role |
|------|------|
| Gemachis Tesfaye | Team Lead |
| Bonsa Horsa | Member |
| Daniel Alemayehu | Member |
| Gelata Driba | Member |
| Hawi Desalegn | Member |
| Kenenisa Gudeta | Member |
| Sisay Tasew | Member |

---

## 👨‍💻 Author

**Gemachis Tesfaye**
Information Science Student — Haramaya University

### 🛠️ Skills
`Java` `Python` `React` `SQL` `Power BI` `Data Analysis`

| Platform | Link |
|----------|------|
| 🐙 GitHub | [gemachistesfaye](https://github.com/gemachistesfaye) |
| 💼 LinkedIn | [Gemachis Tesfaye](https://www.linkedin.com/in/gemachis-tesfaye-137196318) |
| ✈️ Telegram | [@GemachisTech](https://t.me/GemachisTech) |
| 📧 Email | gemachistesfaye@email.com |

---

## 📌 Purpose of the Project

This project was developed as part of a learning journey in building structured software systems using Java OOP principles, focusing on scalability, clean architecture, and real-world academic use cases. The v2.0 refactor demonstrates professional-level code organization beyond a basic assignment submission.
