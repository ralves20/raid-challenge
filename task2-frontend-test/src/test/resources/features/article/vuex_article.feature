Feature: Usage of the Vuex Article Platform
  As a User who reads article
  Bernardo wants to navigate properly on the Vuex Article Platform
  So he can properly read all the articles that he wants

  Background:
    Given Bernardo is on the Vuex Website

  @signup
  Scenario: Sign Up
    When he tries to sign up filling all the information properly
    Then he should be able to successfully create an user on the application

    @article
  Scenario: Reads an Article
    When he opens the first article on the list
    Then he should see that the article is all properly showed