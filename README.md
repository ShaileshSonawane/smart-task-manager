Smart Task Manager API:

A backend REST API for managing tasks with Smart priority suggestions.
Built with Java Spring Boot as part of a backend engineering assignment.

Tech Stack:
- Java 17+
- Spring Boot 4.x
- In-memory storage (ArrayList)
- Keyword-based Smart priority engine

Features:
- Create tasks with auto-generated unique IDs
- Smart priority suggestion (low / medium / high) based on task content
- Mark tasks as completed
- List all tasks

Setup & Run:

Prerequisites:
- Java 17 or higher
- Maven

Steps:
1. Clone the repository:
   git clone https://github.com/ShaileshSonawane/smart-task-manager.git
   cd smart-task-manager

2. No external API keys required. 
   The priority engine works locally using keyword detection.

3. Run the application:
   ./mvnw spring-boot:run
   Or run directly from Spring Tools Suite (STS)

4. Server starts at:
   http://localhost:8080

API Endpoints:

Create a Task:
POST /tasks
Content-Type: application/json

Request Body:
{
    "title": "Fix login bug",
    "description": "Users cannot login on mobile"
}

Response:
{
    "id": "uuid-here",
    "title": "Fix login bug",
    "description": "Users cannot login on mobile",
    "status": "pending",
    "priority": "high",
    "reasoning": "Task contains high-priority keyword: 'bug'"
}

Get All Tasks:
GET /tasks

Response:
[
    {
        "id": "uuid-here",
        "title": "Fix login bug",
        "description": "Users cannot login on mobile",
        "status": "pending",
        "priority": "high",
        "reasoning": "Task contains high-priority keyword: 'bug'"
    }
]

Mark Task as Complete:
PATCH /tasks/{id}

Response:
{
    "id": "uuid-here",
    "title": "Fix login bug",
    "description": "Users cannot login on mobile",
    "status": "completed",
    "priority": "high",
    "reasoning": "Task contains high-priority keyword: 'bug'"
}

Smart Priority Logic:
The priority engine analyzes task title and description using keyword detection:

- HIGH: urgent, critical, crash, bug, fix, error, down, broken, 
        fail, security, login, payment, production, asap
- LOW:  docs, documentation, refactor, cleanup, style, rename, 
        typo, comment, readme, cosmetic, design
- MEDIUM: anything that doesn't match high or low keywords

Project Structure:
src/main/java/com/example/demo/
├── SmartTaskManagerApplication.java
├── controller/
│   └── TaskController.java
├── model/
│   └── Task.java
├── repository/
│   └── InMemoryTaskRepository.java
└── service/
    ├── TaskService.java
    └── AiPriorityService.java

Trade-offs:
- In-memory storage: data resets on restart (acceptable for this scope)
- No authentication: out of scope for this assignment
