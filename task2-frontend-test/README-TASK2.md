# Challenge 2 Details


## What I developed to cover this challenge 2
* The resolution of the challenges as requested on the challenge: 
    * [TASK 2 - Frontend - Scenarios Resolution](TASK-RESOLUTION.md)
* The definition of the most important flows (as requested)
* The scenarios to cover the defined flows
* The automation of some scenarios for the flow
* The usage of another design Pattern on the project to show the many
possibilities that we can use
* Usage of cucumber to allow insert these scenarios in a BDD approach


# 1. The Tech
In this challenge, was developed the items as told above, and use mainly (not only), the following technologies in general:

## 1.1. The Application
For this challenge was created a Frontend project using Java, Selenium, Serenity BDD and Cucumber, with all of it applying the 
Page Objects pattern.

## 1.2 The Architecture
Serenity BDD helps you write cleaner and more maintainable automated acceptance and regression tests faster.
* [Java](https://www.java.com/)
* [Serenity BDD](https://serenity-bdd.github.io/theserenitybook/latest/index.html)
* [Cucumber JVM](https://cucumber.io/docs/cucumber/)
* [Selenium Webdriver](https://selenium.dev/projects/)
* [RestAssured](http://rest-assured.io/)
* ![Page Object Model](https://martinfowler.com/bliki/images/pageObject/pageObject.png)

# 2. Setup

## 2.1. Installing the dependencies
Inside the project folder run the command `mvn clean install` to install all the necessary dependencies.

## 2.2. Running the tests
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
mvn clean verify -Dcucumber.options="--tags @scenarioTag"
```

Running specific scenarios by its name:
```
mvn clean verify -Dcucumber.options="--name 'Reads an Article'"
```

## 2.3. Reporting
After the test execution the Serenity reports will be generated in the `target/site/serenity` directory, then you can see the report by just opening the `index.html` file


## 3. Executing the tests in different ways
To run the sample project, you can either just run the `CucumberTestSuite` test runner class, or run either `mvn verify` or `gradle test` from the command line.

By default, the tests will run using Chrome. You can run them in Firefox by overriding the `driver` system property, e.g.
```json
$ mvn clean verify -Ddriver=firefox
```
Or
```json
$ gradle clean test -Pdriver=firefox
```

The test results will be recorded in the `target/site/serenity` directory.

## 3. Additional Configuration (if needed)
The sample projects both use some Serenity features which make configuring the tests easier. In particular, Serenity uses the `serenity.conf` file in the `src/test/resources` directory to configure test execution options.  

### 3.1 Webdriver configuration
The WebDriver configuration is managed entirely from this file, as illustrated below:
```java
webdriver {
    driver = chrome
}
headless.mode = true

chrome.switches="""--start-maximized;--test-type;--no-sandbox;--ignore-certificate-errors;
                   --disable-popup-blocking;--disable-default-apps;--disable-extensions-file-access-check;
                   --incognito;--disable-infobars,--disable-gpu"""

```

Serenity uses WebDriverManager to download the WebDriver binaries automatically before the tests are executed.

### 3.2. Environment-specific configurations
We can also configure environment-specific properties and options, so that the tests can be run in different environments. Here, we configure three environments, __dev__, _staging_ and _prod_, with different starting URLs for each:
```json
environments {
  default {
    webdriver.base.url = "https://duckduckgo.com"
  }
  dev {
    webdriver.base.url = "https://duckduckgo.com/dev"
  }
  staging {
    webdriver.base.url = "https://duckduckgo.com/staging"
  }
  prod {
    webdriver.base.url = "https://duckduckgo.com/prod"
  }
}
```

You use the `environment` system property to determine which environment to run against. For example to run the tests in the staging environment, you could run:
```json
$ mvn clean verify -Denvironment=staging
```