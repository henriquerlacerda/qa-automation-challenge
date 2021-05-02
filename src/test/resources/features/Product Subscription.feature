Feature: Product Subscription

  Validate the product price for a full special support plan for 6 months simulation

  Background:
    Given Product Subscription Configurator's home page is open


  @Regression
  Scenario Outline: Calculate the price of support plan
    When assigned "<Type>" "<Support Plan>" and "<Monthly duration>"
    And click Calculate
    Then the "<Price>" for this support plan will show on the screen


Examples:
| Type    | Support Plan | Monthly duration | Comments                                                          | Price     |
| Special | Full         | 6                | "Calculate the price of a full special support plan for 6 months" | 2249.10 $ |
