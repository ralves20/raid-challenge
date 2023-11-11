Explore the project vue-realworld-example-app(https://github.com/gothinkster/vuerealworld-example-app) by running the project locally, analyze the functionalities and
features, and answer the following questions:

=========================

1. What are the 3 most critical flows of this application? Explain why for each one.
   Senior QA Automation Engineer 4

* **The SignUP**
  * _The signup flow is extremely necessary and critical, due to this flow is where the user
  gets his access firstly, what means that, the first time that the user is access the application
   and to be able to perform any valid flow on the account, the user needs to have an account created
  and the flow that allows to do this, is the SignUp flow._

* **The SignIn**
  * _The signin flow is essential for the application and extremely critical as due to the reason of 
    if this flow stops working, no user is going to be able to do anything on the app, except for reading articles
    essential things like creating articles, favorites, management, none of them wouldn't be possible if the signin
    flow is not working._
* **The Article Management**
  * _This flow of article management is basically the most important flow of the application, because, this
    flow is the core of what application does, so, if this flow gets blocked, the application makes
    no sense to be used anymore. Is well-know that all the other flows are extremely essential too (just as said
  for signin and signup), however, if the article management flow is not working anymore, the application makes no sense no more._

=========================

2. Based on the 3 flows above, write how many test cases you consider important to
   ensure that these flows continue working. Feel free to write the test cases in the
   way that works best for you, using Gherkin, step-by-step, or any other format.

* **SignUP Scenarios**
    * Create an account using all valid information
    * Create an account of an user that already exists and verify the behavior
    * Verify the behavior of creating an account without filling any fields
    * Verify the behavior of creating an account by filling only username
    * Verify the behavior of creating an account by filling only e-mail and password
    * Verify the behavior of creating an account using an e-mail with an wrong format
    * Verify the behavior of creating an account using all empty fields
    * Try to create an account using a password that does not follow the security compliances
    * Try to create an account for an user that already existed but was deleted in some moment
    * Try to perform a SQL Injection
    * Try to perform a XSS Injection
  
* **SignIn Scenarios**
  * Login with a valid user
  * Try to login with an user that was already deleted
  * Try to login without filling any field
  * Try to login using valid user and wrong password
  * Try to login using wrong user and valid password
  * Try to login using different types of SQL Injection
  * Try to perform an XSS Injection
  * Try to login using an user and password with maximum quantity of chars allowed
  * Try to login trying to bypass the frontend
  * Try to login using whitespaces in the username and on the password

* **Article Management Scenarios**
  * Create an article
  * Read an article
  * Delete an article
  * Favourite an article
  * Favourite 2 or more articles
  * Try to create a duplicated article
  * Try to create an article using only invalid chars
  * Try to create an empty article
  * Try to delete an article that was already deleted
  * Try to favourite an article that was deleted
  * Try to create an article without being authenticated on the application
  * Try to delete an article without being authenticated on the application
  * Read an article being authenticated on the application
  * Read an article without being authenticated on the application


=========================

3. Automate, using the framework or language you feel most comfortable with, the test
   case that you consider the most important from each critical flow.