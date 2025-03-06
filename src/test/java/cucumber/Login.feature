@tag
  Feature: Login on website

    Background:
      Given  I landed on Ecommerce Page
    @tag2
    Scenario Outline: Positive Test
      Given Logged with  name <name> and password <password>
      When I add the product <productName> to Cart
      Then "THANKYOU FOR THE ORDER"

      Examples:
        | name              | password    | productName     |  |
        | anshika@gmail.com | Iamking@000 | ADIDAS ORIGINAL |  |