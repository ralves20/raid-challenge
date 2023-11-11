Feature: Lemonade Stand - Accounts
  As an admin who manages the accounts and products of the Lemonade stand
  Toni wants sell his lemonades of his stand with each lemonade costing $5
  So he will be able to have some profit with his stand and start help his little business to grow up

  Background:
    Given that Toni has his lemonade stand properly set up with everything that he needs to work on

  @e2e @happyFlow @priority:high @lemonadeAccounts
  Scenario Outline: Customer buys a quantity of lemonades using an accepted bill that he will not need to receive a change
    When the customer asks for the quantity of <quantityOfLemonades> lemonade(s) but pays using an allowed bill of <providedBill>
    Then Toni should provide to the customer the quantity of <quantityOfLemonades> lemonade(s)
    And the customer must receive a value of <changeToProvide> change

    Examples:
      | quantityOfLemonades | providedBill | changeToProvide      |
      | 1                   | 5            | NO_CHANGE_TO_PROVIDE |
      | 2                   | 10           | NO_CHANGE_TO_PROVIDE |
      | 4                   | 20           | NO_CHANGE_TO_PROVIDE |

  @e2e @happyFlow @priority:high @lemonadeAccounts
  Scenario Outline: Customer buys a quantity of lemonades using an accepted bill but that he will have to receive a change
    When the customer asks for the quantity of <quantityOfLemonades> lemonade(s) but pays using an allowed bill of <providedBill>
    Then Toni should provide to the customer the quantity of <quantityOfLemonades> lemonade(s)
    And the customer must receive a value of <changeToProvide> change

    Examples:
      | quantityOfLemonades | providedBill | changeToProvide |
      | 1                   | 10           | 5               |
      | 2                   | 20           | 10              |
      | 3                   | 20           | 5               |

  @e2e @happyFlow @priority:high @lemonadeAccounts @WIP
  Scenario: Each customer is answered by order of arrival when there are many customers requesting for lemonade
    When there are many customers requesting for lemonade
    Then the Toni's stand should have all of those requests properly organized by order of arrival also containing all the correct customer requested info

  @e2e @happyFlow @priority:high @lemonadeAccounts
  Scenario Outline: Customer buys using fake bills (5, 10, 20)
    When the customer asks for the quantity of <quantityOfLemonades> lemonade(s) but pays using an allowed bill of <providedBill> that is a fake one
    Then Toni should provide to the customer the quantity of <quantityOfLemonades> lemonade(s)
    And the customer must receive a value of <changeToProvide> change because there were no validation for fake bills due to in this busy workday it's possible to receive it from consumers

    Examples:
      | quantityOfLemonades | providedBill | changeToProvide      |
      | 1                   | 5            | NO_CHANGE_TO_PROVIDE |
      | 1                   | 10           | 5                    |
      | 2                   | 20           | 10                   |

  @e2e @alternativeFlow @priority:high @lemonadeAccounts @WIP
  Scenario Outline: Customer tries to buy using a valid non-accepted bill
    When the customer asks for the quantity of <quantityOfLemonades> lemonade(s) but pays using a valid bill of <nonAcceptedBill> that is non-accepted in the stand
    Then Toni should not provide to the customer any lemonade
    But Toni should tell to him a message that the bill is not accepted

    Examples:
      | quantityOfLemonades | nonAcceptedBill |
      | 1                   | 50              |
      | 2                   | 100             |

  @e2e @alternativeFlow @priority:high @lemonadeAccounts @WIP
  Scenario: Customer gets the lemonade but forget to pay
    When when customer requests for a lemonade without paying anything
    Then Toni should tell him that he cannot get the lemonade without paying
