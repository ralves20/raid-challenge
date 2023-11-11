# PROJECT: Challenges 
This repository consists in resolve 3 specific challenges, which are all described following.

## About the Challenge 1
Develop a function to manage transactions in a lemonade store. Add tests to ensure the
function works correctly.
Customers can buy multiple lemonades.
They pay with R$ 5, R$ 10, or R$ 20 bills.

### 🤑 Task 1: Creating a simple function and tests
Task Background:
* In a lemonade store, each drink costs R$ 5.
* Customers can buy multiple lemonades.
    * They pay with R$ 5, R$ 10, or R$ 20 bills.
    * Sometimes, customers pay with counterfeit (fake) bills.

Create a function to handle orders based on these rules:
1. **Starting Point**:
   The cash register begins with no money.
2. **Order Processing**:
   Handle orders in the order customers arrive.
   Senior QA Automation Engineer 2
3. **Handling Payments**:
   Add each bill received to the cash register for future change.
4. **Giving Change**:
   Provide correct change using the cash register.
   Remove the given change from the register.
5. **Counterfeit Bills**:
   If a bill is counterfeit (shown by a negative value), still give correct change.
   Do not add counterfeit bills to the register.
6. **Output**:
   Return a list of bills remaining in the cash register

## What I developed to cover this challenge 1
* A REST API that generates the flows described on the challenge
* Unit Tests to validate the REST API
* Description of E2E Test Scenarios to validate the flows defined on the challenge
* Automation of the E2E test scenarios defined to validate those flows


### Details about the stack and how to run Challenge 1
* [TASK 1 - Lemonade - DETAILS](task1-lemonade/README-TASK1.md)

## About the Challenge 2
Explore the project vue-realworld-example-app(https://github.com/gothinkster/vuerealworld-example-app) by running the project locally, analyze the functionalities and
features

### 🤑 Task 2: Front-end test
After analyzing the requested project, answer the following questions:
1. What are the 3 most critical flows of this application? Explain why for each one.
   Senior QA Automation Engineer 4
2. Based on the 3 flows above, write how many test cases you consider important to
   ensure that these flows continue working. Feel free to write the test cases in the
   way that works best for you, using Gherkin, step-by-step, or any other format.
3. Automate, using the framework or language you feel most comfortable with, the test
   case that you consider the most important from each critical flow.
4. Optional: Report any bugs found, define the priority of each bug, and explain your
   prioritization.
5. Optional 2: Create a CI/CD pipeline to run the project and run all your automated
   tests generating a report output of the test results. Your pipeline should fail if any
   tests fail


### Details about the stack and how to run Challenge 2
* [TASK 2 - Frontend - DETAILS](task2-frontend-test/README-TASK2.md)
* [TASK 2 - Frontend - Scenarios Resolution](task2-frontend-test/TASK-RESOLUTION.md)


## About the Challenge 3
Explore the Open Weather API (https://openweathermap.org/api/one-call-3)

### 🤑 Task 3: Front-end test
Explore the API, by making requests to test the following functionalities with any tool, language, or framework you
feel comfortable with like Postman or using a script with a programming language like
Python or JS. We expect you to test the following flows by also looking for edge case
scenarios, applying best practices like DRY, Design Pattern(or others you know), and
doing assertions on the responses:

* Current and forecasts weather data
* Weather data for timestamp
* Daily Aggregation
 

* **Try to create requests to reproduce the following errors:**
  * 400
  - 401
  - 404
  - 5xx
  - 429: _You don’t need to write a request or code to this one, just explain how you would
    reproduce the error 429_


### Details about the stack and how to run Challenge 3
* [TASK 3 - Openweather - DETAILS](task3-openweather/README-TASK3.md)


# About myself 
#### _(the guy who received the challenge)_

![ralves20-profile-avatar](https://avatars.githubusercontent.com/u/40844089)
#### This is my profile on Github: [ralves20](https://github.com/ralves20)

* I'm just a simple guy who is passionate about the testing automation and everything related to the software quality world.
* I'm enthusiastic about Design Patterns in software testing and the DevOps world too
* I love to watch comedy tv shows and movies
* Linux is the best!


