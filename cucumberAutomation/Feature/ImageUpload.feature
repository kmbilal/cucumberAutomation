Feature: Login Action

  Scenario Outline: Successful Login with Valid Credentials
    Given I am on QA Home Page
    When I enters "<username>" and "<password>" I navigate to summary page
    Then I clicks on Transfer&Deposits "<Tab>"
    Then I clicks on Image Upload "<Link>"
    And I enters Check Info
    Then I click on the continue button
    Then I Upload the "<fimage>" and "<bimage>"
    Then I validate the" <Message>"

    Examples: 
      | username         | password |  | fimage                                                                           |  | bimage                                                                  | Message |                                                                                                                                                                                                                                                    |
      | epsilon_reserved | test1234 |  | C:\\Users\\fvf767\\Documents\\Personal\\Checks For Automation\\$160.06_Front.jpg |  | C:\\Users\\fvf767\\Documents\\Personal\\Checks For Automation\\Back.jpg |         | Your check will NOT be deposited until you click the 'Deposit Now' button below. It may take a couple minutes, so please be patient. Generally deposits are available next business day. However, some may be held longer (up to 5 business days). |
