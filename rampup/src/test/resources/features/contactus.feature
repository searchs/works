@complete
Feature: Contact Us Page
  As an end user
  I want a contact us page
  So that I can find out more about QAWorks exciting services!!

  Scenario: Valid Submission
    Given I am on the QAWorks Site
    And  I am on the QAWorks contacts page
    Then I should be able to contact QAWorks with the following information
      | name    | j.Bloggs                                  |
      | email   | j.Bloggs@qaworks.com                      |
      | message | please contact me I want to find out more |

  Scenario: Invalid Submission - All Details Missing
    Given I am on the QAWorks Site
    And  I am on the QAWorks contacts page
    When I enter no information and submit form
    Then I should get messages relating to all the missing information

  Scenario: Invalid Submission - Missing Name
    Given I am on the QAWorks contacts page
    When I enter only some details
      | name    |                                                          |
      | email   | j.Bloggs@qaworks.com                                     |
      | message | please contact me I want to find out more - Missing name |
    Then I should get a message related to the missing information
      | name    |                                                          |
      | email   | j.Bloggs@qaworks.com                                     |
      | message | please contact me I want to find out more - Missing name |



  Scenario: Invalid Submission - Missing Email
    Given I am on the QAWorks contacts page
    When I enter only some details
      | name    | j.Bloggs                                                |
      | email   |                                                         |
      | message | please contact me I want to find out more Missing email |
    Then I should get a message related to the missing information
      | name    | j.Bloggs                                                |
      | email   |                                                         |
      | message | please contact me I want to find out more Missing email |

  Scenario: Invalid Submission - Missing Message
    Given I am on the QAWorks contacts page
    When I enter only some details
      | name    | j.Bloggs Missing Message |
      | email   | j.Bloggs@qaworks.com     |
      | message |                          |
    Then I should get a message related to the missing information
      | name    | j.Bloggs Missing Message |
      | email   | j.Bloggs@qaworks.com     |
      | message |                          |