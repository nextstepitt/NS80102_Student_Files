# AddProductionItem.feature
# Copyright © 2019 NextStep IT Training. All rights reserved.
#

Feature: Add to cart
  The client application adds products to the shopping cart
  Scenario: Add product to cart
    Given The client has a customer login
    When The customer is logged in
    And The client application adds a product to the cart
    Then The client's shopping cart will contain the product
