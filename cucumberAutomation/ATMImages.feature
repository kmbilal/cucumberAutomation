Feature: ATMImages

  Scenario Outline: Validate ATM check Images are displaying on transite.
    Given I is on QA Home Page
    When I enter "<CIF>" I should navigate to summary page
    Then I Click on the Account link
    Then I click on the ATM transaction
    Then I validate the "<drawertitle>","<amount>","<Toaccount>"
    Then I validate the front and back images of check
    Then I Click on the Print Tranction link
    And I Validate "<PTtitle>", "<PTamount>","<PTaccount>"

    Examples: 
      | CIF       |  | drawertitle   |  | amount  |  | Toaccount                     |  | PTtitle                                  |  | PTamount |  | PTaccount                     |
      | 46510130 |  | Check Deposit |  | $180.11 |  | EpsilonJoint360C, 10000009347 |  | Transaction Details - Print Confirmation |  | $180.11  |  | EpsilonJoint360C, 10000009347 |
