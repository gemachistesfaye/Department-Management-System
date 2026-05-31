# 🔒 Security Policy

This document outlines the security policy for the **Department Management System** — 
a Java OOP console application developed at Haramaya University.

---

## 📦 Supported Versions

Only the latest version receives security attention and updates.

| Version | Status      | Notes                        |
|---------|-------------|------------------------------|
| 2.0     | ✅ Supported | Current stable version       |
| 1.0     | ❌ No longer supported | Original assignment submission — see [v1-original](https://github.com/gemachistesfaye/Department-Management-System/tree/v1-original) branch |

---

## 🐛 Reporting a Vulnerability

If you discover a security issue, please **do not open a public GitHub issue.**
Contact the author privately so the issue can be investigated and fixed before disclosure.

**Contact channels:**

| Platform | Link |
|----------|------|
| 📧 Email | gemachistesfaye@email.com |
| ✈️ Telegram | [@GemachisTech](https://t.me/GemachisTech) |
| 💼 LinkedIn | [Gemachis Tesfaye](https://www.linkedin.com/in/gemachis-tesfaye-137196318) |

**When reporting, please include:**
- A clear description of the vulnerability
- Steps to reproduce it
- The version affected (v1.0 or v2.0)
- Any suggested fix if you have one

All reports will be reviewed and responded to within **7 days.**

---

## 🛡️ Current Security Scope

This is an academic console application. Understanding its current scope helps 
identify what security concerns are relevant:

| Area | Status | Detail |
|------|--------|--------|
| Network access | ❌ None | Fully offline — no HTTP requests |
| Database | ❌ None | Data stored in memory only (ArrayList) |
| Authentication | ❌ None | No login system in current version |
| File I/O | ❌ None | No files read or written to disk |
| User input | ✅ Validated | All inputs validated via `InputHelper` |
| Data persistence | ❌ None | All data lost on program exit |

---

## 🔮 Future Security Considerations

As the project evolves toward v3.0 with database and authentication features, 
the following will need to be addressed:

- 🔐 Password hashing for any authentication system
- 🗄️ SQL injection prevention when MySQL is integrated
- 📄 File path validation when file persistence is added
- 🌐 Input sanitization if a web interface is built

---

## ⚖️ Disclosure Policy

- Vulnerabilities reported privately will be fixed before any public disclosure
- Credit will be given to the reporter in the changelog if desired
- This policy follows responsible disclosure best practices

---

*For general questions or contributions, see [CONTRIBUTING](./.github/CONTRIBUTING.md).*
