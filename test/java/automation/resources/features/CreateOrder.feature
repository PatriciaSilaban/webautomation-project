Feature: Purchase the order from ecommerce

Background: Buyer landed to website
    Given Buyer landing to ecommerce

Scenario: Create Order Positive Case
    Given Buyer logged to website
    # When Buyer add product to Cart
    # And Buyer checkout product
    # And Buyer place order
    # Then Buyer will see message is displayed on confirmation page
    Then Buyer will see message is displayed on confirmation page THANKYOU FOR THE ORDER.


Scenario Outline: Create Order Positive Case
    Given Buyer logged to website
    Given Buyer logged to website email <email> and password <password>
    When Buyer add product <product_name> to Cart
    And Buyer checkout product <product_name>
    And Buyer place order <destination>
    Then Buyer will see message is displayed on confirmation page THANKYOU FOR THE ORDER.

    Examples:
    |email                         | password        | product_name | destination |
    |patriciasilaban99@gmail.com   | Silaban99       | ZARA COAT 3  | Indonesia   |
    |patriciasilaban99@gmail.com   | Silaban99       | ZARA COAT 3  | Indonesia   |


Scenario Outline: Create Order Positive Case1
    Given Buyer logged to website email <email> and password <password>
    When Buyer add product <product_name> to Cart
    And Buyer checkout product <product_name>
    And Buyer place order <destination>
    Then Buyer will see message is displayed on confirmation page THANKYOU FOR THE ORDER.

    Examples:
    |email                         | password        | product_name | destination |
    |patriciasilaban99@gmail.com   | Silaban99       | ZARA COAT 3  | Indonesia   |

# Scenario Outline: Login Negative Case
#     When Buyer logged to website email <email> and password <password>
#     Then Buyer will see toaster
    

#     Examples:
#     |email                         | password        |
#     |patriciasilaban99             | Silaban99       |
#     |patriciasilaban99@gmail.com   | Silaban         |
#     |patriciasilaban99             | Silaban         |