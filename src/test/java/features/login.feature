Feature: Login

  @login
  Scenario: Login with valid email and password
    Given i am at TalentTEK Homepage
    And i enter my valid email address
    And i enter my valid password
    When i click on Login button
    Then i should be able to successfully login

    @login
    Scenario: Login with invalid email and valid password
      Given i am at TalentTEK Homepage
      And i enter my invalid email address
      And i enter my valid password
      When i click on Login button
      Then i should not be able to successfully login

  @login
  Scenario: Login with invalid email and valid password
    Given i am at TalentTEK Homepage
    And i enter my valid email address
    And i enter my invalid password
    When i click on Login button
    Then i should not be able to successfully login