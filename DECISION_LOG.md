DECISION_LOG.md

1. Time Breakdown
| Phase | Time Spent |
|---|---|
| Project setup (Spring Initializr, dependencies) | 15 min |
| Task model + InMemoryRepository | 20 min |
| TaskService + TaskController (3 endpoints) | 35 min |
| AI Priority Service (Gemini attempt + fallback) | 30 min |
| Debugging (Lombok, package issues, API key) | 25 min |
| Testing with Postman | 15 min |
| README + DECISION_LOG | 20 min |

2. Where AI Was Used — and Why
- Used AI to generate boilerplate code for Controller, Service, and Repository layers
- Used AI to structure the Gemini API call format and JSON parsing logic
- Used AI to suggest the keyword list for priority detection
- Reason: These are repetitive patterns where AI accelerates output without losing understanding

3. Where AI Was NOT Used — and Why
- Did NOT use AI for debugging package import errors — needed to understand the actual project structure myself
- Did NOT blindly accept the Gemini integration — tested it, found it failing, and replaced it with a more reliable solution
- Did NOT use AI for application.properties configuration — straightforward and error-prone if misunderstood

4. Bad AI Outputs (Required)

Bad Output 1 — Wrong Gemini Model
AI suggested using `gemini-2.0-flash` model URL which returned a 404 NOT_FOUND error.
Then suggested `gemini-1.5-flash` which also failed.
Fix: Replaced the entire Gemini integration with a keyword-based priority engine that works reliably without external API dependencies.

Bad Output 2 — Lombok Dependency Issue
AI assumed Lombok would work out of the box with Spring Tools Suite.
In reality, Lombok requires a separate installer to be run against the IDE.
Fix: Removed Lombok entirely and wrote explicit getters/setters manually to avoid wasting time on IDE configuration.

5. Trade-offs Made
- **No Gemini API** — Attempted Gemini integration but hit quota and suspension issues. Replaced with keyword-based logic. The smart feature still works correctly and deterministically.
- **In-memory storage** — Used ArrayList instead of a database. Data is lost on restart but perfectly acceptable for this scope.
- **No input validation beyond title** — Did not add extensive validation to keep the solution minimal and focused.
- **No unit tests** — Given the 2-3 hour constraint, skipped tests in favor of working endpoints.

6. What I Would Improve With More Time
- Integrate a working LLM API (Gemini or OpenAI) for real AI-based priority suggestions
- Add proper exception handling with custom error responses
- Add input validation for all fields
- Write unit tests for TaskService and AiPriorityService
- Add pagination to GET /tasks for large datasets
- Persist data using SQLite or H2 database