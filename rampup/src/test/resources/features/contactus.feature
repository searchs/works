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

  Scenario: Invalid Submission - Missing Message and Email
    Given I am on the QAWorks contacts page
    When I enter only some details
      | name    | j.Bloggs Missing Message Email |
      | email   |                                |
      | message |                                |
    Then I should get a message related to the missing information
      | name    | j.Bloggs Missing Message Email |
      | email   |                                |
      | message |                                |

  Scenario: Invalid Submission - Invalid Email Format Missing at sign
    Given I am on the QAWorks contacts page
    When I enter only some details
      | name    | j.Bloggs Missing Message                                        |
      | email   | jBloggsqaworks.com                                              |
      | message | please contact me I want to find out more Missing at sign email |
    Then I should get invalid email address error message

  Scenario: Invalid Submission - Invalid Email dot at the end
    Given I am on the QAWorks contacts page
    When I enter only some details
      | name    | j.Bloggs Missing Message                                        |
      | email   | j.Bloggs@qaworks.                                               |
      | message | please contact me I want to find out more Missing at sign email |
    Then I should get invalid email address error message

  Scenario: Invalid Submission - Invalid Email Format Missing at TLD
    Given I am on the QAWorks contacts page
    When I enter only some details
    Then I should get a message related to the missing information
      | name    | j.Bloggs Missing Message                                        |
      | email   | j.Bloggs@qaworks                                                |
      | message | please contact me I want to find out more Missing at sign email |


  Scenario: Invalid Submission - Field Boundaries
    Given I am on the QAWorks contacts page
    When I enter values exceeding field limits
      | name    |                                                          |
      | email   | j.Bloggs@qaworks.com                                     |
      | message | please contact me I want to find out more - Missing name |
    Then I should get error message indicating field limits
      | name    |                                                          |
      | email   | j.Bloggs@qaworks.com                                     |
      | message | please contact me I want to find out more - Missing name |

  Scenario: Invalid Submission - Names cannot be Numbers only
    Given I am on the QAWorks contacts page
    When I enter numbers as user name
      | name    | 12344567                                                         |
      | email   | j.Bloggs@qaworks.com                                     |
      | message | please contact me I want to find out more - Missing name |
    Then I should get error message indicating field requires alphanumeric values


  Scenario: XSS Attack Invalid Submission - Script tags Name Field
    Given I am on the QAWorks contacts page
    When I enter only some details
    Then I should get a message related to the missing information
      | name    | <script>alert('Name field. Never! ') </script>                  |
      | email   | j.Bloggsqaworks.com                                             |
      | message | please contact me I want to find out more Missing at sign email |

  Scenario: XSS Attack Invalid Submission - Script tags Email Field
    Given I am on the QAWorks contacts page
    When I enter only some details
    Then I should get a message related to the missing information
      | name    | j.Bloggs Missing Message                                        |
      | email   | <script>alert('Email field. Never! ') </script>                 |
      | message | please contact me I want to find out more Missing at sign email |

  Scenario: XSS Attack Invalid Submission - Script tags Message Field
    Given I am on the QAWorks contacts page
    When I enter only some details
    Then I should get a message related to the missing information
      | name    | j.Bloggs Missing Message                          |
      | email   | j.Bloggsqaworks.com                               |
      | message | <script>alert('Message field. Never! ') </script> |


