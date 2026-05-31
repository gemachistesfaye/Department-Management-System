# 📋 Changelog

All notable changes to the **Department Management System** are documented here.
This project follows [Keep a Changelog](https://keepachangelog.com/en/1.0.0/) conventions.

> 🌿 Want to browse or run the original code? Check out the **[v1-original branch](https://github.com/gemachistesfaye/Department-Management-System/tree/v1-original)**

---

## 🚀 [v2.0] — 2026-05-31 · Major Refactor

> Professional OOP restructure — improved encapsulation, added missing classes, eliminated code duplication and expanded the menu system.

### ✨ Added

Three entirely new files were introduced in this version:

- **`Teacher.java`** — A proper `Teacher` class extending `Person`, with `specialization` and `yearsOfExperience` fields. This class was listed in the v1 README as a feature but was never actually implemented.
- **`Displayable.java`** — A correctly named interface replacing `Department.java`, defining two contracts: `displayCourse()` and `displayInfo()`.
- **`InputHelper.java`** — A utility class that centralizes all console input validation. Replaces 8+ identical copy-pasted validation loops that were scattered across `Test.java`.

New capabilities added to existing code:

| What | Where | Why |
|------|-------|-----|
| List All Students (menu option 5) | `Main.java` | Was completely missing in v1 |
| List All Teachers (menu option 6) | `Main.java` | Was completely missing in v1 |
| `marksSet` flag | `Student.java` | Prevents silent 0/0/0 grade display before marks are entered |
| `calculateTotal()` | `Student.java` | Separates grade calculation from display for reusability |
| `getLetterGrade()` / `getStatus()` | `Student.java` | Standalone, independently testable helpers |
| Duplicate ID check for teachers | `Main.java` | Students had this in v1 — teachers didn't |
| Age and experience range validation | `InputHelper.java` | Age 10–99, experience 0–60 enforced |
| `Scanner.close()` on exit | `Main.java` | Resource was leaking silently in v1 |

---

### 🔄 Changed

#### 📄 `Department.java` → `Displayable.java`
- Renamed entirely — `Department` sounded like a domain object, not a behavioral interface
- `Displayable` accurately describes what it does
- Added second abstract method `displayInfo()` to complete the contract

#### 📄 `Address.java`
- Expanded from `city` only → now stores `city`, `region` and `country`
- Added `toString()` — address can be printed directly without always calling `getCity()`
- Added private `isValid()` helper — removes duplicated null/empty checks
- Added single-argument constructor `Address(String city)` kept for convenience

#### 📄 `Person.java`
- All fields changed from `protected` → `private` with public getters (`getName()`, `getCourse()`, etc.)
- Class made `abstract` — prevents the junk instantiation pattern from v1
- Removed hollow `displayStudent()` placeholder
- Added `abstract displayInfo()` — every subclass must genuinely implement it
- Added `protected displayPersonFields()` — shared helper for subclasses

#### 📄 `Student.java`
- `Grade()` renamed to `displayGrade()` — follows Java method naming convention
- Now uses `getName()` and `getCourse()` getters instead of touching parent fields directly
- Grade logic split into `calculateTotal()`, `getLetterGrade()` and `getStatus()`
- `setMarks()` now returns `boolean` and validates before setting
- `displayInfo()` properly overrides the abstract method from `Person`

#### 📄 `Test.java` → `Main.java`
- Renamed from `Test` to `Main` — professional naming convention
- Entire 293-line `main()` broken into private methods — one per menu action
- Teachers now stored in `ArrayList<Teacher>` instead of being printed and discarded
- Menu expanded from 5 to 7 options with box-drawing UI
- All validation replaced with `InputHelper` static method calls
- `findStudentById()` and `teacherIdExists()` extracted as private helper methods

---

### 🗑️ Removed

- `Department.java` — replaced by `Displayable.java`
- `Test.java` — replaced by `Main.java`
- `displayStudent()` placeholder in `Person` — replaced by `abstract displayInfo()`
- All inline validation loops — replaced by `InputHelper`

---

### 🐛 Fixed

- Unset student marks displayed a silent 0/0/0 grade report → `marksSet` flag now blocks this
- `Person` could be instantiated with empty/fake data to call interface methods → `Person` is now abstract
- Teacher data was collected from the user then immediately thrown away → teachers now stored in `ArrayList<Teacher>`
- `Scanner` resource leaked on program exit → `input.close()` now called in `exitProgram()`

---

## 📦 [v1.0] — 2026-05-01 · Initial Release

> Submitted as part of an Object-Oriented Programming course assignment at Haramaya University.
> 🌿 Full source available on the **[v1-original branch](https://github.com/gemachistesfaye/Department-Management-System/tree/v1-original)**

### 📁 Files at v1.0

| File | Description |
|------|-------------|
| `Department.java` | Interface with single method `displayCourse()` |
| `Address.java` | City-only aggregation class |
| `Person.java` | Concrete base class with `protected` fields |
| `Student.java` | Extends `Person`, grade calculation and display |
| `Test.java` | Entry point — all 293 lines inside `main()` |

### ✅ What worked in v1.0

Console menu with 5 options, student registration with duplicate ID detection, grade calculation using a weighted 30/30/40 model, letter grades A+ through F, input validation on all fields and student search by ID.

### ⚠️ Known Issues at v1.0 (all resolved in v2.0)

- `Teacher` class missing despite being documented as a feature
- Teacher input data was collected and then silently discarded
- Input validation was copy-pasted identically 8+ times
- `Person` fields were `protected` — broken encapsulation
- `displayStudent()` in `Person` was a meaningless one-liner placeholder
- `Address` held only city — no region or country
- `Student.Grade()` accessed parent class fields directly instead of via getters
- Entering marks showed 0/0/0 with no warning on uninitialized students
- `Scanner` was never closed on exit
- `Department` interface was confusingly named

---

## 🗺️ Coming in v3.0

| Feature | Description |
|---------|-------------|
| 💾 File persistence | Save records to `.csv` so data survives restarts |
| 🗄️ MySQL integration | Replace `ArrayList` with JDBC + MySQL |
| ✏️ Edit & Delete | Update or remove registered students and teachers |
| 🔐 Authentication | Admin login with role-based access control |
| 📄 Export reports | Generate PDF or Excel grade reports |
| 🌐 GUI | JavaFX or Swing desktop interface |
| 🌍 Web app | Spring Boot backend + React frontend |
