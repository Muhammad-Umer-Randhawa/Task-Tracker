# Task Tracker CLI

A lightweight, terminal-based Task Tracker Command Line Interface (CLI) application written in Java. It allows users to create, update, delete, and track their daily tasks efficiently. The task data is persisted locally in a structured JSON file (`tasks.json`) utilizing the Google Gson library.

This project is a solution to the [Task Tracker challenge from roadmap.sh](https://roadmap.sh/projects/task-tracker).

---

## 🚀 Features

- **Add Tasks**: Create new tasks with a description. They are assigned a unique auto-incrementing ID, a default status of `todo`, and creation timestamps.
- **Update Tasks**: Modify the description of existing tasks. It also automatically updates the modification timestamp.
- **Delete Tasks**: Remove tasks by their unique ID.
- **Change Status**: Mark tasks as `in-progress` or `done` using their ID.
- **List Tasks**: 
  - List all tasks.
  - Filter and list tasks by their status (`todo`, `in-progress`, or `done`).
- **Data Persistence**: Automatically stores and loads tasks from a local `tasks.json` file in real-time.
- **Robust Parsing**: Includes a custom LocalDateTime adapter for Gson to cleanly format timestamps.

---

## 🛠️ Prerequisites

- **Java Development Kit (JDK)**: Version 8 or higher.
- **Gson Library**: Included in the `lib/` directory (`gson-2.10.1.jar`).

---

## ⚙️ Compilation and Execution

First, navigate to the root directory of the project in your terminal.

### 1. Compilation
Compile all Java source files with the Gson dependency included in the classpath:

**Windows (PowerShell / CMD):**
```bash
javac -cp ".;lib/*" Main.java TaskManager.java Task.java LocalDateTimeAdapter.java
```

**Linux / macOS:**
```bash
javac -cp ".:lib/*" Main.java TaskManager.java Task.java LocalDateTimeAdapter.java
```

### 2. Execution
Run the application by passing commands and arguments:

**Windows (PowerShell / CMD):**
```bash
java -cp ".;lib/*" Main <command> [arguments]
```

**Linux / macOS:**
```bash
java -cp ".:lib/*" Main <command> [arguments]
```

---

## 💻 Commands & Usage Examples

Below are all the commands supported by the Task Tracker CLI:

### Add a New Task
Add a task by providing its description in quotes:
```bash
java -cp ".;lib/*" Main add "Buy groceries"
# Output: Task added successfully (ID: 1)
```

### Update a Task Description
Update the description of an existing task by specifying its ID:
```bash
java -cp ".;lib/*" Main update 1 "Buy groceries and milk"
# Output: Task updated successfully
```

### Delete a Task
Delete a task by specifying its ID:
```bash
java -cp ".;lib/*" Main delete 1
# Output: Task deleted successfully
```

### Mark a Task Status
Mark a task as either `in-progress` or `done` using its ID:
```bash
# Mark as In Progress
java -cp ".;lib/*" Main mark in-progress 1
# Output: Task 1 marked as in-progress

# Mark as Done
java -cp ".;lib/*" Main mark done 1
# Output: Task 1 marked as done
```

### List Tasks
List tasks based on status, or view all tasks:
```bash
# List all tasks
java -cp ".;lib/*" Main list all

# List only 'todo' tasks
java -cp ".;lib/*" Main list todo

# List only 'in-progress' tasks
java -cp ".;lib/*" Main list in-progress

# List only 'done' tasks
java -cp ".;lib/*" Main list done
```

---

## 📄 JSON Data Schema (`tasks.json`)

The tasks are saved in a pretty-printed format in `tasks.json` inside the root directory. Below is an example of what the file structure looks like:

```json
[
  {
    "id": 1,
    "description": "Buy groceries",
    "status": "in-progress",
    "createdAt": "2026-06-08T10:14:26.0893616",
    "updatedAt": "2026-06-08T10:14:26.0943656"
  },
  {
    "id": 2,
    "description": "Play Football",
    "status": "todo",
    "createdAt": "2026-06-08T10:14:52.6409824",
    "updatedAt": "2026-06-08T10:14:52.6479825"
  }
]
```

---

## 📁 Project Structure

```text
├── lib/
│   └── gson-2.10.1.jar          # Google Gson JSON library
├── LocalDateTimeAdapter.java    # GSON TypeAdapter for LocalDateTime serialization
├── Main.java                    # Entry point & CLI argument parser
├── Task.java                    # Task entity model
├── TaskManager.java             # Task operations & file persistence logic
├── tasks.json                   # Tasks database (automatically created)
└── README.md                    # Project documentation
```
