Feature: Navigate web page

  As a web page visitor
  I want to be able to login and navigate the page
  To see the contents


  Scenario: Get to the log in page
    Given the web page is up and running
    And I am not authenticated
    When I visit any page in the domain
    Then I am redirected to the log in page
    And I cannot visit any other page

#  Scenario: Log in
#    Given the web page is up and running
#    And I am not authenticated
#    When I submit the correct credentials
#    Then I am redirected to the landing page

  Scenario: Invalid log in
    Given the web page is up and running
    And I am not authenticated
    When I submit incorrect credentials
    Then I am redirected to the log in page

#  Scenario: Page not found
#    Given the web page is up and running
#    And I am authenticated
#    When I visit a page that does not exist
#    Then I am redirected to the error page

  Scenario: Log out
    Given the web page is up and running
    And I am authenticated
    When I click the logout button
    Then I am redirected to the log in page
    And I cannot visit any other page
