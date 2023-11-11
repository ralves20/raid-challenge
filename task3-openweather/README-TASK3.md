## What I developed to cover this challenge 3
* Besides it requests only to perform API requests on the OpenWeather API, I also added
some aditional scenarios, where it performs some search on Google and then compare the response with
the openweather API.

Apart from that, on this feature was covered
* Scenarios validating different API requests
* Usage of the Screenplay Pattern as a design pattern for the project
* Creation of scenarios using Cucumber (even for API purposes)





# 1. The Tech
In this challenge, was developed the items as told above, and use mainly (not only), the following technologies in general:

## 1.1. The Application, The Project
_"The Screenplay Pattern is a user-centered approach to writing high-quality automated acceptance tests. It steers you towards an effective use of layers of abstraction, helps your tests capture the business vernacular, and encourages good testing and software engineering habits. Instead of focusing on low-level, interface-centric interactions, you describe your test scenarios in a similar way you'd describe them to a human being - an actor in Screenplay-speak. You write simple, readable and highly-reusable code that instructs the actors what activities to perform and what things to check. The domain-specific test language you create is used to express screenplays - the activities for the actors to perform in a given test scenario. The Screenplay Pattern is one of the core design patterns behind Serenity/JS and in this chapter we'll look into how to apply it in practice."_

![Screenplay Pattern](https://serenity-bdd.github.io/assets/images/screenplay-model-d488f442690c701509fec447d3200a99.svg)




## 1.2. Structure of the project

Belows are the tool used to perform the development of this project.
- [Selenium Webdriver](https://www.selenium.dev/documentation/webdriver/)
- [Serenity-BDD Website](https://serenity-bdd.info/)
- [Cucumber](https://cucumber.io/)
- [Java JDK](https://www.oracle.com/br/java/technologies/downloads/),
- [Serenity BDD reports for this project](https://serenity-js.github.io/serenity-js-cucumber-webdriverio-template/)
- [Screenplay Pattern](https://serenity-bdd.github.io/assets/images/screenplay-model-d488f442690c701509fec447d3200a99.svg)

## 1.3. Prerequisites to run

To use this project, you'll need:
- Node.js, a Long-Term Support (LTS) release version 16 or later - [download](https://nodejs.org/en/)
- Java Development Kit (JDK) version 8 or later - [download](https://adoptopenjdk.net/)


### 1.4 Installation / Setup

Once you have the code on your computer, use your computer terminal to run the following command in the directory where you've cloned the project:
```
mvn clean install
```

## 2. RUNNING THE TESTS

### 2.1. Execution of the tests

```
mvn clean verify (Run all tests)
```


### 2.2. Test Report
After the test execution the reports (which also have screenshots) will be generated in the `target/site/serenity` directory, then you can see the report by just opening the `index.html` file


