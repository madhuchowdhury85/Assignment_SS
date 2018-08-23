Feature: Custom Made product create and verify

  Scenario: Create a custom made Jacket and verify the product details
    Given User is in home page and verify the title of home page 
    When Navigate to a product and user is in custom made product detail page
    Then Choose the color of the product
    Then Choose the design of the product
    Then Choose the product from color and design combination
    Then Choose the fit of the product
    Then Choose the size of the product
    Then Verify the product fabric in Custom made section
    Then Verify the product fit in Custom made section
    Then Verify the product size in Custom made section
    
    

