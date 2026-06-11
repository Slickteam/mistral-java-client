## Output
- Return code first. Explanation after, only if non-obvious.
- No inline prose. Use comments sparingly - only where logic is unclear.
- No boilerplate unless explicitly requested.

## Code Rules
- Simplest working solution. No over-engineering.
- No abstractions for single-use operations.
- No speculative features or "you might also want..."
- Read the file before modifying it. Never edit blind.
- No docstrings or type annotations on code not being changed.
- No error handling for scenarios that cannot happen.
- Three similar lines is better than a premature abstraction.

## Review Rules
- State the bug. Show the fix. Stop.
- No suggestions beyond the scope of the review.
- No compliments on the code before or after the review.

## Debugging Rules
- Never speculate about a bug without reading the relevant code first.
- State what you found, where, and the fix. One pass.
- If cause is unclear: say so. Do not guess.

## Simple Formatting
- No em dashes, smart quotes, or decorative Unicode symbols.
- Plain hyphens and straight quotes only.
- Natural language characters (accented letters, CJK, etc.) are fine when the content requires them.
- Code output must be copy-paste safe.

## Project Structure Rules
- All SDK classes extend ClientSDK or ApiResource
- API resource classes belong in the sdk package
- Model/DTO classes belong in the model package, organized by domain (conversation/, agent/, library/, ocr/, observability/, workflow/)
- Utility classes belong in the utils package
- Type/enum classes belong in the type package
- Library/infrastructure classes belong in the lib package

## Code Organization
- Each API endpoint group gets its own class in sdk package (Chat.java, Agents.java, Files.java, etc.)
- Each domain has its own subpackage under model/ for DTOs
- Follow the existing naming convention: API classes are singular nouns (Chat, Agents), model classes use descriptive names (ChatCompletionRequest, AgentAliasResponse)
- New API domains must follow the same pattern: create dedicated sdk class and model subpackage

## API Implementation Standards
- All API endpoints must be constructed using createURI() method with the exact path from openapi.yaml
- Endpoint paths must match openapi.yaml specification exactly
- HTTP methods must match openapi.yaml (GET, POST, DELETE, etc.)
- Request/response types must use the model classes that map to openapi.yaml schemas
- Query parameters must be properly URL-encoded and appended to the URI

## Implementation Standards
- Use Java 17 features (records, sealed classes, pattern matching)
- All API classes must extend ApiResource
- All model classes must be properly serialized with Jackson annotations
- Use ObjectMapper with FAIL_ON_UNKNOWN_PROPERTIES disabled for API responses
- HTTP requests must use the base class methods (sendRequest, sendRequestAsync, etc.)
- Never instantiate HttpClient directly in API classes - use the one from ClientSDK
- All endpoints must be constructed using createURI() method
- Stream responses must handle SSE (Server-Sent Events) format with [DONE] terminator

## Testing Rules
- Test files are placed in src/test/java mirroring the main package structure
- Use JUnit Jupiter (JUnit 5)
- Tests must be self-contained and not depend on external services
- Test DTOs with setter/getter round-trip patterns