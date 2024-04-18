Feature: WebOrder
  @TestCase1
  Scenario: Create WebOrder
    Given enter username and password
    When click on login button
    And click on order button
    Then enter all the fields required to create a order and click on process button
    And validate the successful order creation message
    Then click on logout button
  @TestCase2
  Scenario: Update WebOrder
      Given enter username and password
      When click on login button
      And select order and click on edit button
      Then update required fields and click on update button
      And click on logout button
  @TestCase3
  Scenario: Delete order
    Given enter username and password
    When click on login button
    And select order and click on delete button
    Then click on logout button






