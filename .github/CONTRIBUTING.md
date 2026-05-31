# 🤝 Contributing to Department Management System

Thank you for your interest in contributing! This project was built as part of an OOP course assignment at **Haramaya University** and is open to improvements, bug fixes and new features.

---

## 📌 Before You Start

- Read the [README](./README.md) to understand the project structure
- Check the [Changelog](./docs/CHANGELOG.md) to see what has already changed
- Look at existing [Issues](https://github.com/gemachistesfaye/Department-Management-System/issues) before opening a new one

---

## 🐛 Reporting Bugs

If you find a bug, open an issue with:

- A clear title describing the problem
- Steps to reproduce it
- What you expected to happen
- What actually happened
- Your Java version and OS

---

## 💡 Suggesting Features

Open an issue with the label `enhancement` and describe:

- What the feature does
- Why it would be useful
- How it fits the existing OOP structure

Good feature ideas based on the roadmap:
- File persistence (save to `.csv`)
- MySQL database integration
- Edit and delete functionality
- JavaFX GUI

---

## 🔧 Submitting Code Changes

1. **Fork** the repository
2. **Create a branch** from `main`:
   ```bash
   git checkout -b feature/your-feature-name
   ```
3. **Make your changes** — follow the existing code style
4. **Test thoroughly** before submitting
5. **Commit** with a clear message:
   ```bash
   git commit -m "Add: brief description of what you added"
   ```
6. **Push** to your fork:
   ```bash
   git push origin feature/your-feature-name
   ```
7. **Open a Pull Request** against `main` with a description of your changes

---

## 📐 Code Style Guidelines

| Rule | Detail |
|------|--------|
| Fields | Always `private` — use getters/setters |
| Methods | Lowercase verb names — `displayInfo()` not `DisplayInfo()` |
| Classes | One responsibility per class |
| Validation | Use `InputHelper` for all console input — don't add new raw Scanner loops |
| Comments | Add Javadoc to all public methods |
| Naming | Descriptive names — `calculateTotal()` not `calc()` |

---

## 🌿 Branch Structure

| Branch | Purpose |
|--------|---------|
| `main` | Current stable version (v2.0) |
| `v1-original` | Original assignment submission (v1.0) |
| `feature/*` | Your new feature branches |

---

## ✅ Pull Request Checklist

Before submitting your PR, confirm:

- [ ] Code compiles without errors
- [ ] Follows the OOP structure (no logic dumped into `Main`)
- [ ] Input validation uses `InputHelper`
- [ ] No raw `protected` fields added to `Person`
- [ ] Commit messages are descriptive
- [ ] No `.class` files committed

---

---

## 👥 Core Contributors

This project was originally built by the following team as part of an OOP course assignment at **Haramaya University**:

| Name | Role | Contribution |
|------|------|-------------|
| Gemachis Tesfaye | Team Lead | Architecture, OOP design, v2.0 refactor |
| Bonsa Horsa | Member | Student management logic |
| Daniel Alemayehu | Member | Grade evaluation system |
| Gelata Driba | Member | Input validation |
| Hawi Desalegn | Member | Teacher management |
| Kenenisa Gudeta | Member | Address & data classes |
| Sisay Tasew | Member | Menu system & testing |

---

All contributions, big or small, are welcome and appreciated.
