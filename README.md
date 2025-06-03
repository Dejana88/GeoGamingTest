# UI Automation Framework with Cucumber, Selenium & JUnit

This project contains automated UI tests written using [Cucumber](https://cucumber.io/) (Gherkin), [Selenium WebDriver](https://www.selenium.dev/), and [JUnit](https://junit.org/). The tests are run via Maven and structured using a BDD approach.

## Tech Stack

- Java 21
- Maven
- Cucumber (Gherkin syntax)
- JUnit 4
- Selenium WebDriver
- WebDriverManager (for automatic driver management)

## Project Structure
```
src
├── main
│ └── resources
├── test
│ ├── java
│   ├── pages/
│   └── runners/
│      ├── TestRunnerTest.java
│   ├── stepdefinitions/
│ ├──  resources
│      ├── features/
│         ├── Search.feature
```
## How to Run Tests

1. Clean and run tests:

   ```bash
   mvn clean install
   mvn test

## Test Runner:

Located at runners/TestRunnerTest.java

### Configured to:

* Run only scenarios tagged with @automated

* Look for step definitions in stepdefinitions and pages packages

* Generate an HTML report in target/cucumber-report.html

## Contact
For any questions or suggestions, feel free to reach out, [vukicdejana34@gmail.com](mailto:vukicdejana34@gmail.com)