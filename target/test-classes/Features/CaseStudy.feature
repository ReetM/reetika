#Author: mca2012reetikamaheshwari@gmail.com
#@BorrowingCalculator
Feature: Case study borrowing calculator

  Background: Launch Browser and navigate to Borrow calculator Page
    Given Navigate to Calculator Home Page
    And Validate Page Loaded Successfully

  @EstimateTest
  Scenario Outline: Calculating borrowing estimate
    Given User enters Personal details <NumberOfDependent>
    And Enter your earnings <income> and <otherIncome>
    And Enter your expenses <livingExpenses>,<homeloanRepayments>,<otherloanRepayments>,<othercommitments> and <totalCreditCardLimit>
    When Click on workout how much I could borrow button
    Then Verify borrowing estimate <ExpectedAamount>

    Examples: 
      | NumberOfDependent | income | otherIncome | livingExpenses | homeloanRepayments | otherloanRepayments | othercommitments | totalCreditCardLimit | ExpectedAamount |
      |                 0 |  80000 |       10000 |            500 |                  0 |                 100 |                0 |                10000 | $482,000        |

  @ResetTest
  Scenario Outline: Clear borrowing estimate Form
    Given User has calculated borrowing estimate<NumberOfDependent>,<income>,<otherIncome>,<livingExpenses>,<homeloanRepayments>,<otherloanRepayments>,<othercommitments> and <totalCreditCardLimit>
    When User hit start over to clear form
    Then Form should clear

    Examples: 
      | NumberOfDependent | income | otherIncome | livingExpenses | homeloanRepayments | otherloanRepayments | othercommitments | totalCreditCardLimit | ExpectedAamount |
      |                 0 |  80000 |       10000 |            500 |                  0 |                 100 |                0 |                10000 | $482,000        |

  @VerifyErrorTest
  Scenario Outline: Calcuating Borrowing Estimates with Living Expenses
    Given User has calculated borrowing estimate with living expenses<livingExpenses>
    When Click on workout how much I could borrow button
    Then Verify the Error Message on Screen

    Examples: 
      | livingExpenses |
      |              1 |
