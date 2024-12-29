# Automation Testing Framework

This repository contains a **hybrid automation testing framework** for both **UI** and **API testing**, built using modern tools and technologies such as Selenium, TestNG, RestAssured, Log4j2, and Jenkins. The framework is modular, scalable, and integrated with a CI/CD pipeline.

---

## **Project Folder Structure**

```plaintext
Project Root Directory
|-- src
|   |-- main
|   |   |-- java
|   |   |   |-- com.framework.base
|   |   |   |   |-- BaseTest.java       // Base class for browser and API setup
|   |   |   |   |-- RestClient.java     // REST API utilities
|   |   |   |-- com.framework.pages.ui
|   |   |   |   |-- LoginPage.java      // Example UI Page Object
|   |   |   |   |-- HomePage.java       // Example UI Page Object
|   |   |   |-- com.framework.pages.api
|   |   |       |-- UserAPI.java        // API-specific Page Object
|   |   |-- com.framework.utils
|   |   |   |-- ConfigReader.java       // Utility to read config files
|   |   |   |-- ExcelReader.java        // Utility to read Excel test data
|   |   |   |-- LogHelper.java          // Log4j2 logging helper
|   |   |   |-- TestListeners.java      // TestNG Listeners for reporting
|   |   |-- resources
|   |       |-- config.properties       // Key configuration values
|   |       |-- log4j2.xml              // Log4j2 configuration
|   |       |-- ExtentReportConfig.xml  // Extent Report configuration
|-- src
|   |-- test
|   |   |-- java
|   |   |   |-- com.framework.tests.ui
|   |   |   |   |-- LoginTest.java      // UI Test for Login functionality
|   |   |   |-- com.framework.tests.api
|   |   |       |-- UserAPITest.java    // API Test for User API
|-- test-data
|   |-- TestData.xlsx                   // Test data in Excel format
|-- reports
|   |-- ExtentReports.html              // HTML report generated post-execution
|-- pom.xml                             // Maven dependencies
|-- Jenkinsfile                         // Jenkins Pipeline script
```

---

## **Features**

1. **UI Testing**:
   - Automates browser-based testing using **Selenium WebDriver**.
   - Implements **Page Object Model (POM)** for better test script maintainability.
   - Cross-browser testing with **WebDriver Manager**.

2. **API Testing**:
   - Uses **RestAssured** for API request handling and validations.
   - Includes a reusable **RestClient** to manage HTTP methods (GET, POST, PUT, DELETE).

3. **Test Framework**:
   - Built on **TestNG** for annotations, grouping, and test execution.
   - Custom **TestNG Listeners** for integrating logs and reports.

4. **Data-Driven Testing**:
   - Reads and writes test data from Excel using **Apache POI**.

5. **Logging**:
   - Configured with **Log4j2** for detailed execution logs.

6. **Reporting**:
   - Generates visually appealing **Extent Reports** for test results.

7. **CI/CD Integration**:
   - Fully integrated with **Jenkins** to automate test execution and reporting.

---

## **Setup Instructions**

1. **Clone the Repository**:
   ```bash
   git clone https://github.com/your-repo-url.git
   ```

2. **Update Configuration**:
   - Navigate to `src/main/resources/config.properties` and update necessary configurations (e.g., browser type, URLs).

3. **Install Dependencies**:
   - Ensure **Maven** is installed and run:
     ```bash
     mvn clean install
     ```

4. **Run Tests**:
   - To execute UI and API tests:
     ```bash
     mvn test
     ```

5. **Generate Reports**:
   - After execution, reports will be generated in the `reports` folder.

6. **Setup CI/CD Pipeline**:
   - Add the `Jenkinsfile` to your Jenkins project to automate testing and reporting.

---

## **Technologies Used**

- **Selenium**: For browser-based UI automation.
- **TestNG**: For test annotations and execution.
- **RestAssured**: For API testing and validation.
- **Log4j2**: For logging.
- **Extent Reports**: For reporting.
- **Apache POI**: For Excel-based test data management.
- **WebDriver Manager**: For managing browser driver binaries.
- **Maven**: For dependency management and project build.
- **Jenkins**: For CI/CD pipeline integration.

---

## **CI/CD Workflow**

The Jenkins pipeline includes the following stages:

1. **Clone Repository**: Pulls the code from GitHub.
2. **Setup Environment**: Configures Maven and Java.
3. **Run Tests**: Executes UI and API test cases.
4. **Generate Reports**: Creates Extent Reports for the executed tests.
5. **Archive Reports**: Saves reports in Jenkins for reference.
6. **Publish Test Results**: Displays test results in Jenkins.

---

## **Folder Details**

- **`src/main/java/com.framework.base`**:
  - `BaseTest.java`: Sets up browser and API configurations.
  - `RestClient.java`: Reusable class for API methods.

- **`src/main/java/com.framework.utils`**:
  - `ConfigReader.java`: Reads configurations from `config.properties`.
  - `LogHelper.java`: Sets up and manages Log4j2 logging.
  - `TestListeners.java`: Handles TestNG events for reporting.

- **`src/test/java/com.framework.tests`**:
  - `UITest.java`: Contains Selenium test cases.
  - `APITest.java`: Contains API test cases using RestAssured.

- **`resources`**:
  - `config.properties`: Stores key-value pairs for configurations.
  - `log4j2.xml`: Configures Log4j2 logging behavior.

- **`reports`**:
  - Stores Extent Reports generated post-execution.

---

