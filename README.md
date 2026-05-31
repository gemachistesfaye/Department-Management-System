# 🎓 Department Management System (Java OOP)

> Console-based Java application for managing students, teachers, courses and grade evaluation — built with clean OOP architecture.

![Java](https://img.shields.io/badge/Java-JDK%208%2B-orange?style=flat-square&logo=java)
![OOP](https://img.shields.io/badge/Paradigm-OOP-blue?style=flat-square)
![Status](https://img.shields.io/badge/Status-Active-brightgreen?style=flat-square)
![License](https://img.shields.io/badge/License-MIT-lightgrey?style=flat-square)
![Version](https://img.shields.io/badge/Version-2.0-purple?style=flat-square)
![University](https://img.shields.io/badge/University-Haramaya-red?style=flat-square)

---

<div align="center">

| 🎓 Students | 👨‍🏫 Teachers | 📊 Grades | 🗂️ Classes | 🌿 Branches |
|:-----------:|:------------:|:---------:|:----------:|:-----------:|
| Register, search & list | Register & list | Weighted 30/30/40 | 7 files | main · v1-original |

</div>

---

## 📌 What This Project Does

- 🎓 Register students with full profiles and search by ID
- 👨‍🏫 Register teachers with specialization and experience
- 📊 Evaluate grades — mid exam, project and final — with letter grade output
- 📋 List all students or teachers in a formatted table
- ✅ Validated inputs throughout — no crashes from bad data

---

## ⚡ Quick Start

```bash
git clone https://github.com/gemachistesfaye/Department-Management-System.git
cd Department-Management-System
mkdir -p out
javac -d out src/*.java
java -cp out project1.Main
```

> **IDE users:** Open project → run `src/Main.java` → follow the console menu (1–7)

---

## 🏗️ Architecture

```
          «interface»
          Displayable
               │
               ▼
     Person (abstract)  ◄─────  Address (aggregation)
               │
       ┌───────┴───────┐
    Student          Teacher

  InputHelper (utility)   Main (entry point)
```

---

## 🗂️ Project Structure

```
├── .github/        → CONTRIBUTING.md, CODE_OF_CONDUCT.md
├── docs/           → CHANGELOG.md, DOCUMENTATION.md
├── src/            → 7 Java source files
├── LICENSE
├── README.md
└── SECURITY.md
```

---

## 👨‍💻 Author

**Gemachis Tesfaye** — Full Stack & AI Engineer · Haramaya University

`Java` `Python` `TypeScript` `React` `Node.js` `MySQL` `Gemini` `GPT-4` `Power BI`

| Platform | Contact |
|----------|---------|
| 🐙 GitHub | [gemachistesfaye](https://github.com/gemachistesfaye) |
| 💼 LinkedIn | [Gemachis Tesfaye](https://www.linkedin.com/in/gemachis-tesfaye-137196318) |
| ✈️ Telegram | [GemachisTech](https://t.me/GemachisTech) |
| 📧 Email | gemachistesfaye@email.com |

---

<div align="center">

📖 [Documentation](./docs/DOCUMENTATION.md) &nbsp;·&nbsp; 📋 [Changelog](./docs/CHANGELOG.md) &nbsp;·&nbsp; 🌿 [v1-original](https://github.com/gemachistesfaye/Department-Management-System/tree/v1-original)

</div>
