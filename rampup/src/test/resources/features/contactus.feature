@complete
Feature: Contact Us Page
  As an end user
  I want a contact us page
  So that I can find out more about QAWorks exciting services!!


  Background:
    Given I am on the QAWorks Site
    And  I am on the QAWorks contacts page

  @ignore
  Scenario: Valid Submission

    Then I should be able to contact QAWorks with the following information
      | name    | j.Bloggs                                  |
      | email   | j.Bloggs@qaworks.com                      |
      | message | please contact me I want to find out more |

  Scenario: Invalid Submission - All Details Missing
    When I enter no information and submit form
    Then I should get messages relating to all the missing information

  Scenario: Invalid Submission - Missing Name
    When I enter only some details
      | name    |                                                          |
      | email   | j.Bloggs@qaworks.com                                     |
      | message | please contact me I want to find out more - Missing name |
    Then I should get a message related to the missing information
      | name    |                                                          |
      | email   | j.Bloggs@qaworks.com                                     |
      | message | please contact me I want to find out more - Missing name |


  Scenario: Invalid Submission - Missing Email
    When I enter only some details
      | name    | j.Bloggs                                                |
      | email   |                                                         |
      | message | please contact me I want to find out more Missing email |
    Then I should get a message related to the missing information
      | name    | j.Bloggs                                                |
      | email   |                                                         |
      | message | please contact me I want to find out more Missing email |

  Scenario: Invalid Submission - Missing Message
    When I enter only some details
      | name    | j.Bloggs Missing Message |
      | email   | j.Bloggs@qaworks.com     |
      | message |                          |
    Then I should get a message related to the missing information
      | name    | j.Bloggs Missing Message |
      | email   | j.Bloggs@qaworks.com     |
      | message |                          |

  Scenario: Invalid Submission - Missing Message and Email
    When I enter only some details
      | name    | j.Bloggs Missing Message Email |
      | email   |                                |
      | message |                                |
    Then I should get a message related to the missing information
      | name    | j.Bloggs Missing Message Email |
      | email   |                                |
      | message |                                |

  Scenario: Invalid Submission - Invalid Email Format Missing at sign
    When I enter only some details
      | name    | j.Bloggs Missing Message                                        |
      | email   | jBloggsqaworks.com                                              |
      | message | please contact me I want to find out more Missing at sign email |
    Then I should get invalid email address error message



