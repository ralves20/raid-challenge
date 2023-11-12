# Challenge 1 Details

## What I developed to cover this challenge 1
* A REST API that generates the flows described on the challenge
* Unit Tests to validate the REST API
* Description of E2E Test Scenarios to validate the flows defined on the challenge
* Automation of the E2E test scenarios defined to validate those flows


## 1. The Tech
In this challenge, was developed the items as told above, and use mainly (not only), the following technologies in general:

### 1.1. The Application
The REST API was developed using Java and SpringBoot, and also using an in-memory database H2, to be able to do the things very quick in a simple and temporary way, as it is what generates more value in the context that this challenge is presented.

### 1.1. The Architecture Used
* [Java](https://www.java.com/)
* [SpringBoot](https://spring.io/projects/spring-boot)
* [Sprinta Data JPA](https://spring.io/projects/spring-data-jpa)
* [H2](https://www.h2database.com)

## 2. Setup

### 2.1. Installing the dependencies
Inside the project folder run the command `mvn clean install` to install all the necessary dependencies.

### 2.2. Start up the application
Inside the project's application folder just run the command `mvn clean spring-boot:run`

### 2.3. FAQ / Troubleshooting
* Got an error related to database lock
```
If you get any error related to database lock, the quickest and simplest way to fix it, as the database is an in-memory database, you can just go to your home folder
and delete the file described on the property "spring.datasource.url" (that is on the application.properties)
```

## 3. The Unit Tests
The Unit tests were developed using JUnit, which is the most stable tool existent today for the Java language, and also has a lot of libraries that makes the tool much more powerfull.

### 3.1. Architecture
* [Java](https://www.java.com/)
* [JUnit](https://junit.org/junit5/)
* [Mockito](https://site.mockito.org/)

### 3.2. Installing the dependencies
Inside the project tests folder run the command `mvn clean install` to install all the necessary dependencies.

### 3.3. Running the tests
Inside the project tests folder run the command `mvn clean tests` to run all the tests.

## 4. The E2E Tests
The E2E Tests were developed using Serenity BDD, which is an open source library that aims to make the idea of living documentation a reality.
Serenity BDD allows the usage of the Screenplay Pattern, which also benefits also who uses it because it fits much better with Gherkin scenarios and the
BDD process, making the idea of living documentation work everytime better.

### 4.1.Architecture
Serenity BDD helps you write cleaner and more maintainable automated acceptance and regression tests faster.
* [Java](https://www.java.com/)
* [Serenity BDD](https://serenity-bdd.github.io/theserenitybook/latest/index.html)
* [Cucumber JVM](https://cucumber.io/docs/cucumber/)
* [Selenium Webdriver](https://selenium.dev/projects/)
* [RestAssured](http://rest-assured.io/)
* Screenplay Pattern ![ScreenPlay Pattern Model](https://serenity-bdd.github.io/assets/images/screenplay-model-d488f442690c701509fec447d3200a99.svg)

### 4.2. Installing the dependencies
Inside the project folder run the command `mvn clean install` to install all the necessary dependencies.

### 4.3. Running the E2E tests
Running all tests
```
mvn clean verify
```
or
```
mvn clean verify -Pcucumber 
```

Running specific scenarios using tags:
```
mvn clean verify -Dcucumber.options="--tags @lemonadeAccounts"
```

Running specific scenarios by its name:
```
mvn clean verify -Dcucumber.options="--name 'Customer buys a quantity of lemonades'"
```

### 4.4. Reporting
After the test execution the Serenity reports will be generated in the `target/site/serenity` directory, then you can see the report by just opening the `index.html` file